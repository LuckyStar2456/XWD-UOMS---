package com.xwd.xwd_uoms.common.aspect;

import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.exception.LoginException;
import com.xwd.xwd_uoms.common.exception.PermissionException;
import com.xwd.xwd_uoms.common.util.JwtUtil;
import com.xwd.xwd_uoms.common.util.TokenExtractUtil;
import com.xwd.xwd_uoms.common.util.VerifyUtil;
import jakarta.annotation.Resource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class PermissionAspect {
    @Resource
    private TokenExtractUtil tokenExtractUtil;
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private RedisTemplate<String,String> redisTemplate;
    @Resource
    private VerifyUtil verifyUtil;

    @Pointcut("@annotation(com.xwd.xwd_uoms.common.annotation.RequirePermission)")
    public void permissionPointcut() {}

    @Around("permissionPointcut()")
    public Object aroundPermissionCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        String jwtToken = tokenExtractUtil.extractJwt();
        if (!verifyUtil.isExist(jwtToken)) {
            throw new LoginException("未检测到登录令牌，请先登录.");
        }
        String username = jwtUtil.getFromToken(jwtToken,"username");
        if (!verifyUtil.isExist(username)){
            throw new IllegalArgumentException("缺少用户信息.");
        }
        String redisKey = "access_token:" + username;
        if (!redisTemplate.hasKey(redisKey)){
            throw new IllegalArgumentException("令牌不存在." + redisKey + "---" + redisTemplate.opsForValue().get(redisKey));
        }
        if (redisTemplate.getExpire(redisKey, TimeUnit.SECONDS) <= 0 ||
                !verifyUtil.isExist(redisTemplate.getExpire(redisKey, TimeUnit.SECONDS))){
            redisTemplate.delete(redisKey);
            throw new IllegalArgumentException("令牌已过期.");
        }

        Long userRoleId = Long.valueOf(jwtUtil.getFromToken(jwtToken,"roleId"));

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        RequirePermission annotation = method.getAnnotation(RequirePermission.class);
        String requiredObject = annotation.object();
        String requiredOperation = annotation.operation();

        if (!verifyUtil.hasPerm(userRoleId, requiredObject, requiredOperation)) {
            throw new PermissionException("无当前操作权限，请提交提权申请.");
        }

        return joinPoint.proceed();
    }
}