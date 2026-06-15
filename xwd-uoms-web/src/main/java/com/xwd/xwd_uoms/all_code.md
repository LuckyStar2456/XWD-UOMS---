# Table of Contents
- XwdUomsApplication.java
- common\annotation\Log.java
- common\annotation\RequirePermission.java
- common\aspect\LogAspect.java
- common\aspect\PermissionAspect.java
- common\exception\GlobalExceptionHandler.java
- common\exception\LoginException.java
- common\exception\PermissionException.java
- common\filter\JwtAuthenticationFilter.java
- common\result\Result.java
- common\util\ConvertUtil.java
- common\util\JwtUtil.java
- common\util\PasswordEncryptUtil.java
- common\util\TokenExtractUtil.java
- common\util\VerifyUtil.java
- config\defaultconfig\SysApplyDefaultConfig.java
- config\defaultconfig\SysDeptDefaultConfig.java
- config\defaultconfig\SysEquipBorrowDefaultConfig.java
- config\defaultconfig\SysEquipDefaultConfig.java
- config\defaultconfig\SysFeedbackDefaultConfig.java
- config\defaultconfig\SysNoticeDefaultConfig.java
- config\defaultconfig\SysObjectDefaultConfig.java
- config\defaultconfig\SysOperationDefaultConfig.java
- config\defaultconfig\SysOrgDefaultConfig.java
- config\defaultconfig\SysRoleDefaultConfig.java
- config\defaultconfig\SysRolePermissionDefaultConfig.java
- config\defaultconfig\SysTaskDefaultConfig.java
- config\defaultconfig\SysTaskFeedbackDefaultConfig.java
- config\defaultconfig\SysUserDefaultConfig.java
- config\jwtconfig\JwtConfig.java
- config\securityconfig\SecurityConfig.java
- controller\apply\ApplyController.java
- controller\auth\AuthController.java
- controller\borrow\BorrowController.java
- controller\dept\DeptController.java
- controller\equip\EquipController.java
- controller\feedback\FeedbackController.java
- controller\home\HomeController.java
- controller\notice\NoticeController.java
- controller\org\OrgController.java
- controller\search\SearchController.java
- controller\task\TaskController.java
- controller\taskfeedback\TaskFeedbackController.java
- controller\user\UserController.java
- entity\SysApplyEntity.java
- entity\SysDepartmentEntity.java
- entity\SysEquipmentBorrowEntity.java
- entity\SysEquipmentEntity.java
- entity\SysFeedbackEntity.java
- entity\SysNoticeEntity.java
- entity\SysObjectEntity.java
- entity\SysOperationEntity.java
- entity\SysOrganizationEntity.java
- entity\SysRoleEntity.java
- entity\SysRolePermissionEntity.java
- entity\SysTaskEntity.java
- entity\SysTaskFeedbackEntity.java
- entity\SysUserEntity.java
- entity\dto\AdminDTO.java
- entity\dto\LoginDTO.java
- entity\dto\SysUserDTO.java
- repository\SysApplyRepository.java
- repository\SysDepartmentRepository.java
- repository\SysEquipmentBorrowRepository.java
- repository\SysEquipmentRepository.java
- repository\SysFeedbackRepository.java
- repository\SysNoticeRepository.java
- repository\SysObjectRepository.java
- repository\SysOperationRepository.java
- repository\SysOrganizationRepository.java
- repository\SysRolePermissionRepository.java
- repository\SysRoleRepository.java
- repository\SysTaskFeedbackRepository.java
- repository\SysTaskRepository.java
- repository\SysUserRepository.java
- service\apply\ApplyService.java
- service\apply\impl\ApplyServiceImpl.java
- service\auth\LoginService.java
- service\auth\TokenService.java
- service\auth\impl\LoginServiceImpl.java
- service\auth\impl\TokenServiceImpl.java
- service\borrow\BorrowService.java
- service\borrow\impl\BorrowServiceImpl.java
- service\dept\DeptService.java
- service\dept\impl\DeptServiceImpl.java
- service\equip\EquipService.java
- service\equip\impl\EquipServiceImpl.java
- service\feedback\FeedbackService.java
- service\feedback\impl\FeedbackServiceImpl.java
- service\home\HomeService.java
- service\home\impl\HomeServiceImpl.java
- service\notice\NoticeService.java
- service\notice\impl\NoticeServiceImpl.java
- service\org\OrgService.java
- service\org\impl\OrgServiceImpl.java
- service\search\SearchService.java
- service\search\impl\SearchServiceImpl.java
- service\task\TaskService.java
- service\task\impl\TaskServiceImpl.java
- service\taskfeedback\TaskFeedbackService.java
- service\taskfeedback\impl\TaskFeedbackServiceImpl.java
- service\user\PermService.java
- service\user\UserService.java
- service\user\impl\PermServiceImpl.java
- service\user\impl\UserServiceImpl.java

## File: XwdUomsApplication.java

- Extension: .java
- Language: java
- Size: 4219 bytes
- Created: 2026-01-26 11:18:27
- Modified: 2026-03-29 13:46:08

### Code

```java
package com.xwd.xwd_uoms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class XwdUomsApplication {
    public static void main(String[] args) {
        SpringApplication.run(XwdUomsApplication.class, args);
        System.out.println("\n" +
                "────────────────────────────────────────────────────────────────────────────────\n" +
                "๑˃̵ᴗ˂̵๑                          ๑˃̵ᴗ˂̵๑                          ๑˃̵ᴗ˂̵๑\n" +
                "────────────────────────────────────────────────────────────────────────────────\n" +
                "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
                "┃                                                                     _          ┃\n" +
                "┃                ┏━━┓┏━━┓┏━━┓┏━━┓┏━━┓┏━━┓┏━━┓┏━━┓  ┏━━┓┏━━┓┏━━┓┏━━┓  |||         ┃\n" +
                "┃                ┃X ┃┃W ┃┃D ┃┃_ ┃┃U ┃┃O ┃┃M ┃┃S ┃  ┃P ┃┃L ┃┃A ┃┃Y ┃  |||         ┃\n" +
                "┃                ┗━━┛┗━━┛┗━━┛┗━━┛┗━━┛┗━━┛┗━━┛┗━━┛  ┗━━┛┗━━┛┗━━┛┗━━┛   ~          ┃\n" +
                "┃                                                                     ⁕          ┃\n" +
                "┃        (◍•ᴗ•◍)❤                (◍•ᴗ•◍)❤                (◍•ᴗ•◍)❤           ┃\n" +
                "┃                                                                                ┃\n" +
                "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n" +
                "────────────────────────────────────────────────────────────────────────────────\n" +
                "          ʕ˙Ⱉ˙ʔ                      ʕ˙Ⱉ˙ʔ                      ʕ˙Ⱉ˙ʔ\n" +
                "────────────────────────────────────────────────────────────────────────────────\n" +
                "          ʕ•ᴥ•ʔ                      ʕ•ᴥ•ʔ                      ʕ•ᴥ•ʔ\n" +
                "────────────────────────────────────────────────────────────────────────────────\n" +
                "          ʕ˃̵ᴥ˂̵ʔ                     ʕ˃̵ᴥ˂̵ʔ                     ʕ˃̵ᴥ˂̵ʔ\n" +
                "────────────────────────────────────────────────────────────────────────────────");
    }

}

```

## File: common\annotation\Log.java

- Extension: .java
- Language: java
- Size: 433 bytes
- Created: 2026-03-29 18:52:32
- Modified: 2026-03-29 18:56:51

### Code

```java
package com.xwd.xwd_uoms.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块名称（如：用户管理、组织管理）
     */
    String module() default "";

    /**
     * 操作描述（如：添加用户、删除组织）
     */
    String operation() default "";
}
```

## File: common\annotation\RequirePermission.java

- Extension: .java
- Language: java
- Size: 313 bytes
- Created: 2026-01-29 11:18:44
- Modified: 2026-01-30 10:35:55

### Code

```java
package com.xwd.xwd_uoms.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE}) // 可用于方法、类
@Retention(RetentionPolicy.RUNTIME) // 运行时生效
@Documented
public @interface RequirePermission {
    String object();
    String operation();
}

```

## File: common\aspect\LogAspect.java

- Extension: .java
- Language: java
- Size: 5177 bytes
- Created: 2026-03-29 18:53:25
- Modified: 2026-03-29 19:05:32

### Code

```java
package com.xwd.xwd_uoms.common.aspect;

import com.xwd.xwd_uoms.common.annotation.Log;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    // 同时匹配类级别和方法级别的 @Log 注解
    @Pointcut("@within(com.xwd.xwd_uoms.common.annotation.Log) || @annotation(com.xwd.xwd_uoms.common.annotation.Log)")
    public void logPointcut() {}

    @Around("logPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Class<?> targetClass = joinPoint.getTarget().getClass();

        // 优先获取方法上的注解，若没有则获取类上的注解
        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation == null) {
            logAnnotation = targetClass.getAnnotation(Log.class);
        }

        String module = logAnnotation != null ? logAnnotation.module() : "";
        String operation = logAnnotation != null ? logAnnotation.operation() : "";
        String className = targetClass.getSimpleName();
        String methodName = method.getName();

        HttpServletRequest request = getHttpServletRequest();
        String requestUri = request != null ? request.getRequestURI() : "N/A";
        String httpMethod = request != null ? request.getMethod() : "N/A";
        String clientIp = request != null ? getClientIp(request) : "N/A";

        Object[] args = joinPoint.getArgs();
        String params = formatParams(args);

        logger.info("==================== 日志开始 ====================");
        logger.info("模块：{} | 操作：{}", module, operation);
        logger.info("类名：{} | 方法：{}", className, methodName);
        logger.info("请求URI：{} | HTTP方法：{} | 客户端IP：{}", requestUri, httpMethod, clientIp);
        logger.info("请求参数：{}", params);

        Object result = null;
        String errorMsg = null;
        try {
            result = joinPoint.proceed();
            return result;
        } catch (Throwable e) {
            errorMsg = e.getMessage();
            logger.error("方法执行异常：", e);
            throw e;
        } finally {
            long elapsedTime = System.currentTimeMillis() - startTime;
            String resultStr = formatResult(result);
            logger.info("方法返回值：{}", resultStr);
            if (errorMsg != null) {
                logger.error("异常信息：{}", errorMsg);
            }
            logger.info("执行耗时：{} ms", elapsedTime);
            logger.info("==================== 日志结束 ====================");
        }
    }

    private HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes != null ? attributes.getRequest() : null;
    }

    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private String formatParams(Object[] args) {
        if (args == null || args.length == 0) {
            return "无参数";
        }
        return Arrays.stream(args)
                .map(arg -> {
                    if (arg instanceof HttpServletRequest) {
                        return "HttpServletRequest";
                    }
                    return arg != null ? arg.toString() : "null";
                })
                .collect(Collectors.joining(", "));
    }

    private String formatResult(Object result) {
        if (result == null) {
            return "null";
        }
        String resultStr = result.toString();
        if (resultStr.length() > 500) {
            resultStr = resultStr.substring(0, 500) + "...(截断)";
        }
        return resultStr;
    }
}
```

## File: common\aspect\PermissionAspect.java

- Extension: .java
- Language: java
- Size: 2955 bytes
- Created: 2026-01-30 10:22:13
- Modified: 2026-03-29 18:54:42

### Code

```java
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
```

## File: common\exception\GlobalExceptionHandler.java

- Extension: .java
- Language: java
- Size: 1366 bytes
- Created: 2026-01-28 10:43:21
- Modified: 2026-03-29 13:33:51

### Code

```java
package com.xwd.xwd_uoms.common.exception;

import com.xwd.xwd_uoms.common.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClassCastException.class)
    public Result<?> handlerClassCastException(ClassCastException e){
        return Result.systemError();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Result<?> handlerIllegalArgumentException(IllegalArgumentException e){
        return Result.paramError("参数错误:" + e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result<?> handlerRuntimeException(RuntimeException e){
        return Result.systemError();
    }

    @ExceptionHandler(PermissionException.class)
    public Result<?> handlerPermissionException(PermissionException e){
        return Result.permError("权限异常:" + e.getMessage());
    }

    @ExceptionHandler(LoginException.class)
    public Result<?> handlerLoginException(LoginException e){
        return Result.loginError("登陆异常:" + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<?> handlerException(Exception e){
        return Result.systemError();
    }

}
```

## File: common\exception\LoginException.java

- Extension: .java
- Language: java
- Size: 426 bytes
- Created: 2026-02-09 11:24:19
- Modified: 2026-02-09 11:27:40

### Code

```java
package com.xwd.xwd_uoms.common.exception;

public class LoginException extends RuntimeException{
    
    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }
}

```

## File: common\exception\PermissionException.java

- Extension: .java
- Language: java
- Size: 446 bytes
- Created: 2026-02-09 11:21:09
- Modified: 2026-02-09 11:21:36

### Code

```java
package com.xwd.xwd_uoms.common.exception;

public class PermissionException extends RuntimeException {

    public PermissionException() {
        super();
    }

    public PermissionException(String message) {
        super(message);
    }

    public PermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionException(Throwable cause) {
        super(cause);
    }
}
```

## File: common\filter\JwtAuthenticationFilter.java

- Extension: .java
- Language: java
- Size: 2998 bytes
- Created: 2026-02-05 16:27:18
- Modified: 2026-03-24 22:17:06

### Code

```java
package com.xwd.xwd_uoms.common.filter;

import com.xwd.xwd_uoms.common.util.JwtUtil;
import com.xwd.xwd_uoms.common.util.TokenExtractUtil;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Resource
    private TokenExtractUtil tokenExtractUtil;
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private SysUserRepository sysUserRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            String jwt = tokenExtractUtil.extractJwt();

            if (jwt != null && !jwt.isEmpty() && SecurityContextHolder.getContext().getAuthentication() == null) {
                jwtUtil.validateToken(jwt);

                Claims claims = jwtUtil.parseToken(jwt);
                String username = claims.get("username", String.class);

                SysUserEntity sysUser = sysUserRepository.findSysUserEntityByUsername(username);
                if (sysUser == null) {
                    throw new IllegalArgumentException("Token中的用户不存在.");
                }

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + sysUser.getRoleId()))
                );
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("JWT拦截验证失败: " + e.getMessage());
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return path.startsWith("/xwd_uoms/api/auth/");
    }
}
```

## File: common\result\Result.java

- Extension: .java
- Language: java
- Size: 1455 bytes
- Created: 2026-01-27 13:58:52
- Modified: 2026-02-09 11:02:01

### Code

```java
package com.xwd.xwd_uoms.common.result;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;
    private Result(){}

    public static <T> Result<T> success(){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }
    public static <T> Result<T> success(String msg,T data){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(Integer code,String msg){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    public static <T> Result<T> paramError(String msg) {
        return error(400, msg);
    }
    public static <T> Result<T> loginError(String msg) {
        return error(401, msg);
    }
    public static <T> Result<T> permError(String msg) {
        return error(403, msg);
    }
    public static <T> Result<T> systemError() {
        return error(500, "系统繁忙，请稍后再试");
    }
}

```

## File: common\util\ConvertUtil.java

- Extension: .java
- Language: java
- Size: 9228 bytes
- Created: 2026-03-03 08:30:53
- Modified: 2026-03-29 19:38:58

### Code

```java
package com.xwd.xwd_uoms.common.util;

import com.xwd.xwd_uoms.entity.*;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import com.xwd.xwd_uoms.repository.SysDepartmentRepository;
import com.xwd.xwd_uoms.repository.SysOrganizationRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;

@Component
public class ConvertUtil {
    @Resource
    private SysDepartmentRepository sysDepartmentRepository;

    @Resource
    private VerifyUtil verifyUtil;

    @Resource
    private SysOrganizationRepository sysOrganizationRepository;

    public SysUserDTO userToDTO(SysUserEntity user){
        SysUserDTO userDTO = new SysUserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setGrade(user.getGrade());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setUsername(user.getUsername());
        userDTO.setRoleId(user.getRoleId());
        String deptName = sysDepartmentRepository.findNameById(user.getDeptId());
        if (verifyUtil.isExist(deptName)){
            userDTO.setDeptName(deptName);
        }
        String orgName = sysOrganizationRepository.findNameById(user.getOrgId());
        String orgType = sysOrganizationRepository.findTypeById(user.getOrgId());
        if (verifyUtil.isExist(orgName) && verifyUtil.isExist(orgType)){
            userDTO.setOrgName(orgName);
            userDTO.setOrgType(orgType);
        }
        return userDTO;
    }

    public SysUserDTO mapSOToUserDTO(Map<String,Object> map){
        SysUserDTO user = new SysUserDTO();
        LocalDate now = LocalDate.now();
        try {
            user.setId((Long) map.get("id"));
            user.setOrgName((String) map.get("orgName"));
            user.setDeptName((String) map.get("deptName"));
            user.setName((String) map.get("name"));
            user.setGrade((String) map.get("grade"));
            user.setEmail((String) map.get("email"));
            user.setPhone((String) map.get("phone"));
            user.setUsername((String) map.get("username"));
            user.setPassword((String) map.get("password"));
        }catch (Exception e){
            throw new IllegalArgumentException("参数获取异常:" + e.getMessage());
        }
        return user;
    }

    public SysOrganizationEntity mapSOToOrgEntity(Map<String,Object> map){
        SysOrganizationEntity org = new SysOrganizationEntity();
        LocalDate now = LocalDate.now();
        try {
            org.setId((Long) map.get("id"));
            org.setName((String) map.get("name"));
            org.setType((String) map.get("type"));
            org.setOrgDesc((String) map.get("orgDesc"));
            org.setAddress((String) map.get("address"));
            org.setPhone((String) map.get("phone"));
            org.setStatus((byte) map.get("status"));
            org.setIsDeleted((byte) map.get("isDeleted"));
            org.setCreateDate((LocalDate) map.get("createDate"));
            org.setUpdateDate(now);
        }catch (Exception e){
            throw new IllegalArgumentException("参数获取异常:" + e.getMessage());
        }
        return org;
    }

    public SysDepartmentEntity mapSOToDeptEntity(Map<String,Object> map){
        SysDepartmentEntity dept = new SysDepartmentEntity();
        LocalDate now = LocalDate.now();
        try {
            dept.setId((Long) map.get("id"));
            dept.setOrgId((Long) map.get("orgId"));
            dept.setName((String) map.get("name"));
            dept.setDeptDesc((String) map.get("deptDesc"));
            dept.setStatus((byte) map.get("status"));
            dept.setIsDeleted((byte) map.get("isDeleted"));
            dept.setCreateDate((LocalDate) map.get("createDate"));
            dept.setUpdateDate(now);
        }catch (Exception e){
            throw new IllegalArgumentException("参数获取异常:" + e.getMessage());
        }
        return dept;
    }

    public SysEquipmentEntity mapSOToEquipEntity(Map<String,Object> map){
        SysEquipmentEntity equip = new SysEquipmentEntity();
        LocalDate now = LocalDate.now();
        try {
            equip.setId((Long) map.get("id"));
            equip.setOrgId((Long) map.get("orgId"));
            equip.setDeptId((Long) map.get("deptId"));
            equip.setTotalNum((Integer) map.get("totalNum"));
            equip.setAvailableNum((Integer) map.get("availableNum"));
            equip.setName((String) map.get("name"));
            equip.setEquipmentDesc((String) map.get("equipDesc"));
            equip.setStatus((byte) map.get("status"));
            equip.setIsDeleted((byte) map.get("isDeleted"));
            equip.setCreateDate((LocalDate) map.get("createDate"));
            equip.setUpdateDate(now);
        }catch (Exception e){
            throw new IllegalArgumentException("参数获取异常:" + e.getMessage());
        }
        return equip;
    }

    public SysNoticeEntity mapSOToNoticeEntity(Map<String,Object> map){
        SysNoticeEntity notice = new SysNoticeEntity();
        LocalDate now = LocalDate.now();
        try {
            notice.setId((Long) map.get("id"));
            notice.setMandatoryId((Long) map.get("mandatoryId"));
            notice.setOriginatorId((Long) map.get("originatorId"));
            notice.setContent((String) map.get("content"));
            notice.setName((String) map.get("name"));
            notice.setIsDeleted((byte) map.get("isDeleted"));
            notice.setCreateDate((LocalDate) map.get("createDate"));
            notice.setUpdateDate(now);
        }catch (Exception e){
            throw new IllegalArgumentException("参数获取异常:" + e.getMessage());
        }
        return notice;
    }

    public SysTaskEntity mapSOToTaskEntity(Map<String,Object> map){
        SysTaskEntity task = new SysTaskEntity();
        LocalDate now = LocalDate.now();
        try {
            task.setId((Long) map.get("id"));
            task.setMandatoryId((Long) map.get("mandatoryId"));
            task.setOriginatorId((Long) map.get("originatorId"));
            task.setTaskDesc((String) map.get("taskDesc"));
            task.setName((String) map.get("name"));
            task.setStatus((byte) map.get("status"));
            task.setIsDeleted((byte) map.get("isDeleted"));
            task.setDeadline((LocalDate) map.get("deadline"));
            task.setCreateDate((LocalDate) map.get("createDate"));
            task.setUpdateDate(now);
        }catch (Exception e){
            throw new IllegalArgumentException("参数获取异常:" + e.getMessage());
        }
        return task;
    }

    public SysFeedbackEntity mapSOToFeedbackEntity(Map<String, Object> map) {
        SysFeedbackEntity feedback = new SysFeedbackEntity();
        LocalDate now = LocalDate.now();
        try {
            feedback.setId((Long) map.get("id"));
            feedback.setFeedbackUserId((Long) map.get("feedbackUserId"));
            feedback.setHandlerUserId((Long) map.get("handlerUserId"));
            feedback.setTargetObject((String) map.get("targetObject"));
            feedback.setFeedbackContent((String) map.get("feedbackContent"));
            feedback.setRemark((String) map.get("remark"));
            feedback.setFeedbackStatus((byte) map.get("feedbackStatus"));
            feedback.setIsDeleted((byte) map.get("isDeleted"));
            feedback.setFeedbackTime((LocalDate) map.get("feedbackTime"));
            feedback.setHandleTime((LocalDate) map.get("handleTime"));
            feedback.setCreateDate((LocalDate) map.get("createDate"));
            feedback.setUpdateDate(now);
        }catch (Exception e){
            throw new IllegalArgumentException("参数获取异常:" + e.getMessage());
        }
        return feedback;
    }

    public SysTaskFeedbackEntity mapSOToTaskFeedbackEntity(Map<String, Object> map) {
        SysTaskFeedbackEntity taskFeedback = new SysTaskFeedbackEntity();
        LocalDate now = LocalDate.now();
        try {
            taskFeedback.setId((Long) map.get("id"));
            taskFeedback.setTaskId((Long) map.get("taskId"));
            taskFeedback.setFeedbackUserId((Long) map.get("feedbackUserId"));
            taskFeedback.setReviewUserId((Long) map.get("reviewUserId"));
            taskFeedback.setFeedbackContent((String) map.get("feedbackContent"));
            taskFeedback.setReviewContent((String) map.get("reviewContent"));
            taskFeedback.setReviewStatus((byte) map.get("reviewStatus"));
            taskFeedback.setFeedbackTime((LocalDate) map.get("feedbackTime"));
            taskFeedback.setReviewTime((LocalDate) map.get("reviewTime"));
            taskFeedback.setCreateDate((LocalDate) map.get("createDate"));
            taskFeedback.setUpdateDate(now);
        }catch (Exception e){
            throw new IllegalArgumentException("参数获取异常:" + e.getMessage());
        }
        return taskFeedback;
    }
}

```

## File: common\util\JwtUtil.java

- Extension: .java
- Language: java
- Size: 3748 bytes
- Created: 2026-01-26 16:48:14
- Modified: 2026-03-29 12:42:13

### Code

```java
package com.xwd.xwd_uoms.common.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.xwd.xwd_uoms.common.exception.LoginException;
import com.xwd.xwd_uoms.config.jwtconfig.JwtConfig;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {
    @Resource
    private JwtConfig jwtConfig;

    private Key getSigningKey() {
        String secret = jwtConfig.getSecret();
        Assert.notBlank(secret, "JWT密钥不可为空.");
        Assert.isTrue(secret.getBytes(StandardCharsets.UTF_8).length >= 32,
                "JWT密钥长度至少为32字节.");
        byte[] secretByte = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(secretByte);
    }

    private String generateJwtToken(Map<String,Object> claims,Long expiretion){
        Date now = DateUtil.date();
        Date expiretionDate = DateUtil.offsetMillisecond(now,expiretion.intValue());
        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiretionDate)
                .signWith(getSigningKey(),SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

    public String generateAccessToken(Map<String, Object> claims) {
        Assert.notNull(claims, "JWT载荷数据不可为空.");
        return generateJwtToken(claims, jwtConfig.getAccessExpiration());
    }

    public String generateRefreshToken(Map<String, Object> claims) {
        Assert.notNull(claims, "JWT载荷数据不可为空.");
        return generateJwtToken(claims, jwtConfig.getRefreshExpiration());
    }

    private Jws<Claims> parseAndValidateToken(String token) {
        if (StrUtil.isBlank(token)) {
            throw new IllegalArgumentException("令牌不可为空.");
        }
        try {
            return  Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);

        } catch (ExpiredJwtException e) {
            throw new LoginException("令牌已过期.");
        } catch (UnsupportedJwtException e) {
            throw new IllegalArgumentException("令牌格式错误.");
        } catch (SignatureException e) {
            throw new IllegalArgumentException("令牌签名错误.");
        } catch (IllegalArgumentException | MalformedJwtException e) {
            throw new IllegalArgumentException("令牌格式非法.");
        } catch (Exception e) {
            throw new RuntimeException("未知错误-" + e.getMessage(), e);
        }
    }

    public void validateToken(String token) {
        if (token != null) {
            token = token.trim().replaceAll("^[\"']|[\"']$", "");
        }
        if (StrUtil.isBlank(token)) {
            throw new IllegalArgumentException("令牌不可为空.");
        }
        parseAndValidateToken(token);
    }

    public Claims parseToken(String token) {
        return parseAndValidateToken(token).getBody();
    }

    public String getFromToken(String token, String key) {
        Claims claims = parseToken(token);
        Object value = claims.get(key);
        if (value == null) {
            throw new IllegalArgumentException("JWT令牌中未包含指定key: " + key);
        }
        return value.toString();
    }
}
```

## File: common\util\PasswordEncryptUtil.java

- Extension: .java
- Language: java
- Size: 956 bytes
- Created: 2026-01-26 16:06:48
- Modified: 2026-02-05 18:23:16

### Code

```java
package com.xwd.xwd_uoms.common.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncryptUtil {
    private static final BCryptPasswordEncoder BCRYPT_PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public String encryptPassword(String password){
        if (password == null || password.trim().isEmpty()){
            throw new IllegalArgumentException("密码不能为空.");
        }
        return BCRYPT_PASSWORD_ENCODER.encode(password);
    }

    public boolean matchPassword(String password,String encryptedPassword){
        if (password == null || password.trim().isEmpty() || encryptedPassword == null || encryptedPassword.trim().isEmpty()){
            throw new IllegalArgumentException("密码不存在.");
        }
        return BCRYPT_PASSWORD_ENCODER.matches(password,encryptedPassword);
    }
}

```

## File: common\util\TokenExtractUtil.java

- Extension: .java
- Language: java
- Size: 1054 bytes
- Created: 2026-01-30 09:16:03
- Modified: 2026-01-30 11:47:26

### Code

```java
package com.xwd.xwd_uoms.common.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class TokenExtractUtil {
    public String extractJwt() {
        HttpServletRequest request = getRequest();
        if (request == null) return null;
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7).trim();
        }
        return null;
    }
    private HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return null;
        }else {
            return attributes.getRequest();
        }
    }
}

```

## File: common\util\VerifyUtil.java

- Extension: .java
- Language: java
- Size: 4747 bytes
- Created: 2026-02-04 15:07:49
- Modified: 2026-03-15 16:59:11

### Code

```java
package com.xwd.xwd_uoms.common.util;

import com.xwd.xwd_uoms.common.exception.PermissionException;
import com.xwd.xwd_uoms.entity.*;
import com.xwd.xwd_uoms.repository.SysObjectRepository;
import com.xwd.xwd_uoms.repository.SysOperationRepository;
import com.xwd.xwd_uoms.repository.SysOrganizationRepository;
import com.xwd.xwd_uoms.repository.SysRolePermissionRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class VerifyUtil {
    @Resource
    private SysObjectRepository sysObjectRepository;

    @Resource
    private SysOperationRepository sysOperationRepository;

    @Resource
    private SysRolePermissionRepository sysRolePermissionRepository;

    public boolean isExist(String str){
        if (str == null || str.trim().isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    public boolean isExist(SysUserEntity sysUser){
        if (sysUser == null || sysUser.getIsDeleted() == 1 || sysUser.getStatus() == 0){
            return false;
        }else{
            return true;
        }
    }
    public boolean isExist(SysOrganizationEntity sysOrganization){
        if (sysOrganization == null || sysOrganization.getIsDeleted() == 1 || sysOrganization.getStatus() == 0){
            return false;
        }else{
            return true;
        }
    }
    public boolean isExist(SysDepartmentEntity sysDepartment){
        if (sysDepartment == null || sysDepartment.getIsDeleted() == 1 || sysDepartment.getStatus() == 0){
            return false;
        }else{
            return true;
        }
    }
    public boolean isExist(SysEquipmentEntity sysEquipment){
        if (sysEquipment == null || sysEquipment.getIsDeleted() == 1 || sysEquipment.getStatus() == 0){
            return false;
        }else{
            return true;
        }
    }
    public boolean isExist(SysRoleEntity sysRole){
        if (sysRole == null || sysRole.getIsDeleted() == 1 || sysRole.getStatus() == 0){
            return false;
        }else{
            return true;
        }
    }
    public boolean isExist(SysNoticeEntity sysNotice){
        if (sysNotice == null || sysNotice.getIsDeleted() == 1){
            return false;
        }else{
            return true;
        }
    }
    public boolean isExist(SysApplyEntity apply){
        if (apply == null || apply.getIsDeleted() == 1){
            return false;
        }else{
            return true;
        }
    }
    public boolean isExist(Integer num){
        if (num == null || num < 0){
            return false;
        }else{
            return true;
        }
    }
    public <T> boolean isExist(T data){
        if (data == null){
            return false;
        }else{
            return true;
        }
    }

    public boolean hasPerm(Long userRoleId, String objectCode, String operationCode){
        if ((objectCode == null || objectCode.isEmpty()) && (operationCode == null || operationCode.isEmpty())) {
            return true;
        }

        if (userRoleId == null){
            return false;
        }

        try {
            Long objectId = sysObjectRepository.findIdByCode(objectCode);
            if (objectId == null) {
                return false;
            }

            Long operationId = sysOperationRepository.findIdByCode(operationCode);
            if (operationId == null) {
                return false;
            }

            boolean hasPermission = sysRolePermissionRepository.existsByRoleIdAndObjectIdAndOperationId(
                    userRoleId, objectId, operationId
            );
            if (hasPermission) {
                return true;
            }

            boolean hasAllPermission = sysRolePermissionRepository.existsByRoleIdAndObjectIdAndOperationId(
                    userRoleId, 1L, 1L
            );
            if (hasAllPermission) {
                return true;
            }

            boolean hasObjectPermission = sysRolePermissionRepository.existsByRoleIdAndObjectIdAndOperationId(
                    userRoleId,1L,operationId
            );
            if (hasObjectPermission) {
                return true;
            }

            boolean hasOperationPermission = sysRolePermissionRepository.existsByRoleIdAndObjectIdAndOperationId(
                    userRoleId,objectId,1L
            );
            if (hasOperationPermission){
                return true;
            }

        }catch(Exception e){
            throw new PermissionException("权限校验失败,"+e.getMessage());
        }
        return false;
    }
}

```

## File: config\defaultconfig\SysApplyDefaultConfig.java

- Extension: .java
- Language: java
- Size: 374 bytes
- Created: 2026-01-26 15:03:31
- Modified: 2026-01-26 15:03:38

### Code

```java
package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.apply.default")
public class SysApplyDefaultConfig {
    private Byte applyStatus;
    private Byte isDeleted;
}
```

## File: config\defaultconfig\SysDeptDefaultConfig.java

- Extension: .java
- Language: java
- Size: 397 bytes
- Created: 2026-01-26 14:56:21
- Modified: 2026-01-26 14:56:56

### Code

```java
package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.dept.default")
public class SysDeptDefaultConfig {
    private String deptDesc;
    private Byte status;
    private Byte isDeleted;
}
```

## File: config\defaultconfig\SysEquipBorrowDefaultConfig.java

- Extension: .java
- Language: java
- Size: 353 bytes
- Created: 2026-01-26 14:58:29
- Modified: 2026-01-26 14:59:23

### Code

```java
package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.equip.borrow.default")
public class SysEquipBorrowDefaultConfig {
    private Byte status;
}
```

## File: config\defaultconfig\SysEquipDefaultConfig.java

- Extension: .java
- Language: java
- Size: 406 bytes
- Created: 2026-01-26 14:57:46
- Modified: 2026-01-26 14:58:04

### Code

```java
package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.equip.default")
public class SysEquipDefaultConfig {
    private String equipmentDesc;
    private Byte status;
    private Byte isDeleted;
}

```

## File: config\defaultconfig\SysFeedbackDefaultConfig.java

- Extension: .java
- Language: java
- Size: 383 bytes
- Created: 2026-01-26 15:04:02
- Modified: 2026-01-26 15:06:00

### Code

```java
package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.feedback.default")
public class SysFeedbackDefaultConfig {
    private Byte feedbackStatus;
    private Byte isDeleted;
}
```

## File: config\defaultconfig\SysNoticeDefaultConfig.java

- Extension: .java
- Language: java
- Size: 345 bytes
- Created: 2026-01-26 15:03:03
- Modified: 2026-01-26 15:03:12

### Code

```java
package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.notice.default")
public class SysNoticeDefaultConfig {
    private Byte isDeleted;
}
```

## File: config\defaultconfig\SysObjectDefaultConfig.java

- Extension: .java
- Language: java
- Size: 342 bytes
- Created: 2026-01-26 15:01:16
- Modified: 2026-01-26 15:01:23

### Code

```java
package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.object.default")
public class SysObjectDefaultConfig {
    private Byte status;
}
```

## File: config\defaultconfig\SysOperationDefaultConfig.java

- Extension: .java
- Language: java
- Size: 348 bytes
- Created: 2026-01-26 15:02:03
- Modified: 2026-01-26 15:02:10

### Code

```java
package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.operation.default")
public class SysOperationDefaultConfig {
    private Byte status;
}
```

## File: config\defaultconfig\SysOrgDefaultConfig.java

- Extension: .java
- Language: java
- Size: 420 bytes
- Created: 2026-01-26 14:55:39
- Modified: 2026-01-26 14:56:01

### Code

```java
package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.org.default")
public class SysOrgDefaultConfig {
    private String type;
    private String orgDesc;
    private Byte status;
    private Byte isDeleted;
}
```

## File: config\defaultconfig\SysRoleDefaultConfig.java

- Extension: .java
- Language: java
- Size: 397 bytes
- Created: 2026-01-26 15:00:45
- Modified: 2026-01-26 15:00:51

### Code

```java
package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.role.default")
public class SysRoleDefaultConfig {
    private String roleDesc;
    private Byte status;
    private Byte isDeleted;
}
```

## File: config\defaultconfig\SysRolePermissionDefaultConfig.java

- Extension: .java
- Language: java
- Size: 361 bytes
- Created: 2026-01-26 15:02:37
- Modified: 2026-01-26 15:02:44

### Code

```java
package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.role.permission.default")
public class SysRolePermissionDefaultConfig {
    private Byte status;
}

```

## File: config\defaultconfig\SysTaskDefaultConfig.java

- Extension: .java
- Language: java
- Size: 397 bytes
- Created: 2026-01-26 14:57:15
- Modified: 2026-01-26 14:57:26

### Code

```java
package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.task.default")
public class SysTaskDefaultConfig {
    private String taskDesc;
    private Byte status;
    private Byte isDeleted;
}
```

## File: config\defaultconfig\SysTaskFeedbackDefaultConfig.java

- Extension: .java
- Language: java
- Size: 363 bytes
- Created: 2026-01-26 14:59:44
- Modified: 2026-01-26 15:00:26

### Code

```java
package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.task.feedback.default")
public class SysTaskFeedbackDefaultConfig {
    private Byte reviewStatus;
}

```

## File: config\defaultconfig\SysUserDefaultConfig.java

- Extension: .java
- Language: java
- Size: 425 bytes
- Created: 2026-01-26 14:33:06
- Modified: 2026-02-04 17:17:43

### Code

```java
package com.xwd.xwd_uoms.config.defaultconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sys.user.default")
public class SysUserDefaultConfig {
    private Long roleId;
    private Byte status;
    private Byte isDeleted;
    private String password;
}

```

## File: config\jwtconfig\JwtConfig.java

- Extension: .java
- Language: java
- Size: 470 bytes
- Created: 2026-01-27 09:08:40
- Modified: 2026-01-29 15:27:16

### Code

```java
package com.xwd.xwd_uoms.config.jwtconfig;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class JwtConfig {
    @Value("${sys.jwt.secret}")
    private String secret;

    @Value("${sys.jwt.token.expiration.access}")
    private Long accessExpiration;

    @Value("${sys.jwt.token.expiration.refresh}")
    private Long refreshExpiration;
}

```

## File: config\securityconfig\SecurityConfig.java

- Extension: .java
- Language: java
- Size: 3230 bytes
- Created: 2026-01-29 15:43:31
- Modified: 2026-03-29 12:33:20

### Code

```java
package com.xwd.xwd_uoms.config.securityconfig;

import com.xwd.xwd_uoms.common.filter.JwtAuthenticationFilter;
import com.xwd.xwd_uoms.common.util.JwtUtil;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)

                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/xwd_uoms/api/**").permitAll()
                        .anyRequest().authenticated()
                )

                .cors(cors -> cors.configurationSource(corsConfigurationSource()));

        return http.build();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setExposedHeaders(Arrays.asList("Authorization"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
```

## File: controller\apply\ApplyController.java

- Extension: .java
- Language: java
- Size: 2587 bytes
- Created: 2026-03-19 18:59:42
- Modified: 2026-03-29 19:00:48

### Code

```java
package com.xwd.xwd_uoms.controller.apply;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysApplyEntity;
import com.xwd.xwd_uoms.service.apply.ApplyService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Log(module = "apply")
@RestController
@RequestMapping("/xwd_uoms/api/apply")
public class ApplyController {
    @Resource
    private ApplyService applyService;

    @PostMapping("/add")
    @RequirePermission(object = "",operation = "")
    public Result<?> applyAdd(@RequestBody SysApplyEntity apply){
        applyService.createApply(apply);
        return Result.success("申请表创建成功.");
    }

    @GetMapping("/pending/view/{applyUserId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showPendApply(@PathVariable Long applyUserId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysApplyEntity> page = applyService.showPendApply(applyUserId, current, size);
        return Result.success(page);
    }

    @GetMapping("/received/view/{approveUserId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showRecApply(@PathVariable Long approveUserId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysApplyEntity> page = applyService.showRecApply(approveUserId, current, size);
        return Result.success(page);
    }

    @PutMapping("/approve/{approveUserId}")
    @RequirePermission(object = "apply",operation = "approve")
    public Result<?> approveApply(@PathVariable Long approveUserId, @RequestBody SysApplyEntity apply) throws Exception {
        applyService.approveApply(approveUserId, apply);
        return Result.success("申请表审批成功.");
    }

    @DeleteMapping("/deleted/{applyId}")
    @RequirePermission(object = "apply",operation = "deleted")
    public Result<?> deletedApply(@PathVariable Long applyId){
        applyService.deletedApply(applyId);
        return Result.success("申请表撤销成功.");
    }

    @GetMapping("/show/{applyId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showApply(@PathVariable Long applyId){
        SysApplyEntity apply = applyService.showApply(applyId);
        return Result.success(apply);
    }
}

```

## File: controller\auth\AuthController.java

- Extension: .java
- Language: java
- Size: 1367 bytes
- Created: 2026-02-02 16:21:52
- Modified: 2026-03-29 19:00:48

### Code

```java
package com.xwd.xwd_uoms.controller.auth;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.dto.LoginDTO;
import com.xwd.xwd_uoms.service.auth.LoginService;
import com.xwd.xwd_uoms.service.auth.TokenService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Log(module = "auth")
@RestController
@RequestMapping("/xwd_uoms/api/auth")
public class AuthController {
    @Resource
    private LoginService loginService;
    @Resource
    private TokenService tokenService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody LoginDTO loginDTO) throws Exception {
        loginService.verifyUserLogin(loginDTO);
        Map<String,Object> datas = loginService.generateDatas(loginDTO);
        return Result.success(datas);
    }

    @PostMapping("/refreshToken")
    public Result<?> refreshToken(@RequestBody String refreshToken) throws Exception {
        String accessToken = tokenService.refreshToken(refreshToken);
        return Result.success(accessToken);
    }

    @PostMapping("/logout")
    public Result<?> logout(@RequestBody String refreshToken) throws Exception {
        loginService.logout(refreshToken);
        return Result.success("登出成功.");
    }
}

```

## File: controller\borrow\BorrowController.java

- Extension: .java
- Language: java
- Size: 3477 bytes
- Created: 2026-03-22 19:34:23
- Modified: 2026-03-29 19:00:48

### Code

```java
package com.xwd.xwd_uoms.controller.borrow;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysEquipmentBorrowEntity;
import com.xwd.xwd_uoms.service.borrow.BorrowService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Log(module = "borrow")
@RestController
@RequestMapping("/xwd_uoms/api/borrow")
public class BorrowController {
    @Resource
    private BorrowService borrowService;

    @PostMapping("/add")
    @RequirePermission(object = "borrow",operation = "add")
    public Result<?> borrowAdd(@RequestBody SysEquipmentBorrowEntity borrow){
        borrowService.borrowAdd(borrow);
        return Result.success("借取表创建成功.");
    }

    @PutMapping("/update")
    @RequirePermission(object = "borrow",operation = "update")
    public Result<?> borrowUpdate(@RequestBody SysEquipmentBorrowEntity borrow){
        borrowService.borrowUpdate(borrow);
        return Result.success("截取表信息更新成功.");
    }

    @PutMapping("/approve/{approveUserId}")
    @RequirePermission(object = "borrow",operation = "approve")
    public Result<?> approveBorrow(@PathVariable Long approveUserId,@RequestBody SysEquipmentBorrowEntity borrow){
        borrowService.approveBorrow(approveUserId, borrow);
        return Result.success("借取表审批成功.");
    }

    @GetMapping("/org/view/{orgId}")
    @RequirePermission(object = "org",operation = "view")
    public Result<?> showOrgBorrow(@PathVariable Long orgId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentBorrowEntity> page = borrowService.showOrgBorrow(orgId, current, size);
        return Result.success(page);
    }

    @GetMapping("/dept/view/{deptId}")
    @RequirePermission(object = "dept",operation = "view")
    public Result<?> showDeptBorrow(@PathVariable Long deptId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentBorrowEntity> page = borrowService.showDeptBorrow(deptId, current, size);
        return Result.success(page);
    }

    @GetMapping("/received/view/{borrowerId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showUnfBorrow(@PathVariable Long borrowerId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentBorrowEntity> page = borrowService.showUnfBorrow(borrowerId, current, size);
        return Result.success(page);
    }

    @GetMapping("/pending/view/{approveId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showPendBorrow(@PathVariable Long approveId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentBorrowEntity> page = borrowService.showPendBorrow(approveId, current, size);
        return Result.success(page);
    }

    @GetMapping("/show/{borrowId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showBorrow(@PathVariable Long borrowId){
        SysEquipmentBorrowEntity borrow = borrowService.showBorrow(borrowId);
        return Result.success(borrow);
    }
}

```

## File: controller\dept\DeptController.java

- Extension: .java
- Language: java
- Size: 1626 bytes
- Created: 2026-03-22 19:27:44
- Modified: 2026-03-29 19:00:48

### Code

```java
package com.xwd.xwd_uoms.controller.dept;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysDepartmentEntity;
import com.xwd.xwd_uoms.service.dept.DeptService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Log(module = "dept")
@RestController
@RequestMapping("/xwd_uoms/api/dept")
public class DeptController {
    @Resource
    private DeptService deptService;

    @PutMapping("/update")
    @RequirePermission(object = "dept",operation = "update")
    public Result<?> deptUpdate(@RequestBody SysDepartmentEntity dept){
        deptService.deptUpdate(dept);
        return Result.success("部门信息更新成功.");
    }

    @PostMapping("/add")
    @RequirePermission(object = "dept",operation = "add")
    public Result<?> deptAdd(@RequestBody SysDepartmentEntity dept){
        deptService.deptAdd(dept);
        return Result.success("部门信息创建成功.");
    }

    @DeleteMapping("/deleted/{deptId}")
    @RequirePermission(object = "dept",operation = "deleted")
    public Result<?> deptDeleted(@PathVariable Long deptId){
        deptService.deptDeleted(deptId);
        return Result.success("部门解散成功.");
    }

    @GetMapping("/show/{deptId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showDept(@PathVariable Long deptId){
        SysDepartmentEntity dept = deptService.showDept(deptId);
        return Result.success(dept);
    }
}

```

## File: controller\equip\EquipController.java

- Extension: .java
- Language: java
- Size: 2808 bytes
- Created: 2026-03-22 19:13:41
- Modified: 2026-03-29 19:00:48

### Code

```java
package com.xwd.xwd_uoms.controller.equip;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysEquipmentEntity;
import com.xwd.xwd_uoms.service.equip.EquipService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Log(module = "equip")
@RestController
@RequestMapping("/xwd_uoms/api/equip")
public class EquipController {
    @Resource
    private EquipService equipService;

    @PutMapping("/update")
    @RequirePermission(object = "equip",operation = "update")
    public Result<?> equipUpdate(@RequestBody SysEquipmentEntity equip){
        equipService.equipUpdate(equip);
        return Result.success("设备信息更新成功.");
    }

    @PostMapping("/add")
    @RequirePermission(object = "equip",operation = "add")
    public Result<?> equipAdd(@RequestBody SysEquipmentEntity equip){
        equipService.equipAdd(equip);
        return Result.success("设备添加成功.");
    }

    @PutMapping("/borrow/{equipId}/{borrowNum}")
    @RequirePermission(object = "equip",operation = "update")
    public Result<?> equipBorrow(@PathVariable Long equipId, @PathVariable Integer borrowNum){
        equipService.equipBorrow(equipId,borrowNum);
        return Result.success("设备借取成功.");
    }

    @DeleteMapping("/deleted/{equipId}")
    @RequirePermission(object = "equip",operation = "deleted")
    public Result<?> equipDeleted(@PathVariable Long equipId){
        equipService.equipDeleted(equipId);
        return Result.success("设备删除成功.");
    }

    @GetMapping("/org/view/{orgId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showOrgEquip(@PathVariable Long orgId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size) {
        Page<SysEquipmentEntity> page = equipService.showOrgEquip(orgId, current, size);
        return Result.success(page);
    }

    @GetMapping("/dept/view/{deptId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showDeptEquip(@PathVariable Long deptId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size) {
        Page<SysEquipmentEntity> page = equipService.showDeptEquip(deptId, current, size);
        return Result.success(page);
    }

    @GetMapping("/show/{equipId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showEquip(@PathVariable Long equipId){
        SysEquipmentEntity equip = equipService.showEquip(equipId);
        return Result.success(equip);
    }
}

```

## File: controller\feedback\FeedbackController.java

- Extension: .java
- Language: java
- Size: 2971 bytes
- Created: 2026-03-19 20:35:00
- Modified: 2026-03-29 19:00:48

### Code

```java
package com.xwd.xwd_uoms.controller.feedback;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysFeedbackEntity;
import com.xwd.xwd_uoms.service.feedback.FeedbackService;
import jakarta.annotation.Resource;
import jakarta.persistence.Lob;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Log(module = "fb")
@RestController
@RequestMapping("/xwd_uoms/api/feedback")
public class FeedbackController {
    @Resource
    private FeedbackService feedbackService;

    @PutMapping("/update")
    @RequirePermission(object = "feedback",operation = "update")
    public Result<?> feedbackUpdate(@RequestBody SysFeedbackEntity feedback){
        feedbackService.feedbackUpdate(feedback);
        return Result.success("反馈信息更新成功.");
    }

    @PostMapping("/add")
    @RequirePermission(object = "",operation = "")
    public Result<?> feedbackAdd(@RequestBody SysFeedbackEntity feedback){
        feedbackService.feedbackAdd(feedback);
        return Result.success("反馈信息创建成功.");
    }

    @DeleteMapping("/deleted/{feedbackId}")
    @RequirePermission(object = "feedback",operation = "deleted")
    public Result<?> feedbackDeleted(@PathVariable Long feedbackId){
        feedbackService.feedbackDeleted(feedbackId);
        return Result.success("反馈信息删除成功.");
    }

    @GetMapping("/received/view/{handlerUserId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showRecFeedback(@PathVariable Long handlerUserId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysFeedbackEntity> page = feedbackService.showRecFeedback(handlerUserId,current,size);
        return Result.success(page);
    }

    @GetMapping("/pending/view/{feedbackUserId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showPendFeedback(@PathVariable Long feedbackUserId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysFeedbackEntity> page = feedbackService.showPendFeedback(feedbackUserId,current,size);
        return Result.success(page);
    }

    @GetMapping("/show/{feedbackId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showFeedback(@PathVariable Long feedbackId){
        SysFeedbackEntity feedback = feedbackService.showFeedback(feedbackId);
        return Result.success(feedback);
    }

    @PutMapping("/approve")
    @RequirePermission(object = "feedback",operation = "approve")
    public Result<?> approveFeedback(@RequestBody SysFeedbackEntity feedback){
        feedbackService.approveFeedback(feedback);
        return Result.success("反馈表审批成功.");
    }
}

```

## File: controller\home\HomeController.java

- Extension: .java
- Language: java
- Size: 2938 bytes
- Created: 2026-02-09 13:48:26
- Modified: 2026-03-29 19:00:48

### Code

```java
package com.xwd.xwd_uoms.controller.home;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.*;
import com.xwd.xwd_uoms.service.home.HomeService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Log(module = "home")
@RestController
@RequestMapping("/xwd_uoms/api/home")
public class HomeController {
    @Resource
    private HomeService homeService;

    @RequirePermission(object = "",operation = "")
    @GetMapping("/received/apply/{userId}")
    public Result<?> showUnfApply(@PathVariable Long userId, @RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysApplyEntity> page = homeService.showUnfApply(userId, current, size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/received/task/{userId}")
    public Result<?> showUnfTask(@PathVariable Long userId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysTaskEntity> page = homeService.showUnfTask(userId, current, size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/received/equipborrow/{userId}")
    public Result<?> showUnfEquipBorrow(@PathVariable Long userId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentBorrowEntity> page = homeService.showUnfEquipBorrow(userId, current, size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/received/feedback/{userId}")
    public Result<?> showUnfFeedback(@PathVariable Long userId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysFeedbackEntity> page = homeService.showUnfFeedBack(userId, current, size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/received/notice/{userId}")
    public Result<?> showRecNotice(@PathVariable Long userId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysNoticeEntity> page = homeService.showRecNotice(userId, current, size);
        return Result.success(page);
    }

    @RequirePermission(object = "admin",operation = "view")
    @GetMapping("/show/admin")
    public Result<?> showAdmin(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysUserEntity> page = homeService.showAdmin(current, size);
        return Result.success(page);
    }
}

```

## File: controller\notice\NoticeController.java

- Extension: .java
- Language: java
- Size: 2652 bytes
- Created: 2026-03-19 19:15:54
- Modified: 2026-03-29 19:00:48

### Code

```java
package com.xwd.xwd_uoms.controller.notice;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysNoticeEntity;
import com.xwd.xwd_uoms.service.apply.ApplyService;
import com.xwd.xwd_uoms.service.notice.NoticeService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Log(module = "notice")
@RestController
@RequestMapping("/xwd_uoms/api/notice")
public class NoticeController {
    @Resource
    private NoticeService noticeService;

    @PostMapping("/add")
    @RequirePermission(object = "notice",operation = "add")
    public Result<?> noticeAdd(@RequestBody SysNoticeEntity notice){
        noticeService.noticeAdd(notice);
        return Result.success("通知创建成功.");
    }

    @PutMapping("/update")
    @RequirePermission(object = "notice",operation = "update")
    public Result<?> noticeUpdate(@RequestBody SysNoticeEntity notice){
        noticeService.noticeUpdate(notice);
        return Result.success("通知更新成功.");
    }

    @GetMapping("/received/view/{mandatoryId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showRecApply(@PathVariable Long mandatoryId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysNoticeEntity> page = noticeService.showRecNotice(mandatoryId, current, size);
        return Result.success(page);
    }

    @GetMapping("/pending/view/{originatorId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showPendApply(@PathVariable Long originatorId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysNoticeEntity> page = noticeService.showIniNotice(originatorId, current, size);
        return Result.success(page);
    }

    @DeleteMapping("/deleted/{noticeId}")
    @RequirePermission(object = "notice",operation = "deleted")
    public Result<?> applyDeleted(@PathVariable Long noticeId){
        noticeService.noticeDeleted(noticeId);
        return Result.success("通知撤销成功.");
    }

    @GetMapping("/show/{noticeId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showApply(@PathVariable Long noticeId){
        SysNoticeEntity notice = noticeService.showNotice(noticeId);
        return Result.success(notice);
    }
}

```

## File: controller\org\OrgController.java

- Extension: .java
- Language: java
- Size: 1605 bytes
- Created: 2026-03-12 13:25:10
- Modified: 2026-03-29 19:00:48

### Code

```java
package com.xwd.xwd_uoms.controller.org;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysOrganizationEntity;
import com.xwd.xwd_uoms.service.org.OrgService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Log(module = "org")
@RestController
@RequestMapping("/xwd_uoms/api/org")
public class OrgController {
    @Resource
    private OrgService orgService;

    @RequirePermission(object = "",operation = "")
    @GetMapping("/show/{orgId}")
    public Result<?> showOrg(@PathVariable Long orgId){
        SysOrganizationEntity org = orgService.showOrg(orgId);
        return Result.success(org);
    }

    @RequirePermission(object = "org",operation = "update")
    @PutMapping("/update")
    public Result<?> updateOrg(@RequestBody SysOrganizationEntity newOrg){
        orgService.orgUpdate(newOrg);
        return Result.success("组织信息更新成功.");
    }

    @RequirePermission(object = "org",operation = "add")
    @PostMapping("/add")
    public Result<?> addOrg(@RequestBody SysOrganizationEntity org){
        orgService.orgAdd(org);
        return Result.success("组织信息添加成功.");
    }

    @RequirePermission(object = "org",operation = "deleted")
    @DeleteMapping("/deleted/{orgId}")
    public Result<?> deletedOrg(@PathVariable Long orgId){
        orgService.orgDeleted(orgId);
        return Result.success("组织解散成功.");
    }
}

```

## File: controller\search\SearchController.java

- Extension: .java
- Language: java
- Size: 5443 bytes
- Created: 2026-02-09 13:43:48
- Modified: 2026-03-29 21:18:11

### Code

```java
package com.xwd.xwd_uoms.controller.search;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysDepartmentEntity;
import com.xwd.xwd_uoms.entity.SysEquipmentEntity;
import com.xwd.xwd_uoms.entity.SysOrganizationEntity;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import com.xwd.xwd_uoms.service.search.SearchService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Log(module = "search")
@RestController
@RequestMapping("/xwd_uoms/api/search")
public class SearchController {
    @Resource
    private SearchService searchService;

    @RequirePermission(object = "",operation = "")
    @GetMapping("/user/{userName}")
    public Result<?> searchUser(@PathVariable(required = false) String userName, @RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysUserDTO> page = searchService.searchUser(userName,current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/user/all")
    public Result<?> searchAllUser(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysUserDTO> page = searchService.searchAllUser(current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/org/all")
    public Result<?> searchAllOrg(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysOrganizationEntity> page = searchService.searchAllOrg(current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/dept/all")
    public Result<?> searchAllDept(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysDepartmentEntity> page = searchService.searchAllDept(current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/equip/all")
    public Result<?> searchAllEquip(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentEntity> page = searchService.searchAllEquip(current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/org/{orgName}")
    public Result<?> searchOrg(@PathVariable(required = false) String orgName,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysOrganizationEntity> page = searchService.searchOrg(orgName,current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/org/{orgId}/dept")
    public Result<?> searchOrgDept(@PathVariable(required = false) Long orgId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysDepartmentEntity> page = searchService.searchOrgDept(orgId,current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/org/{orgId}/equip")
    public Result<?> searchOrgEquip(@PathVariable(required = false) Long orgId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentEntity> page = searchService.searchOrgEquip(orgId,current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/dept/{deptName}")
    public Result<?> searchDept(@PathVariable(required = false) String deptName,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysDepartmentEntity> page = searchService.searchDept(deptName,current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/dept/{deptId}/user")
    public Result<?> searchDeptUser(@PathVariable(required = false) Long deptId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysUserDTO> page = searchService.searchDeptUser(deptId,current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/dept/{deptId}/equip")
    public Result<?> searchDeptEquip(@PathVariable(required = false) Long deptId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentEntity> page = searchService.searchDeptEquip(deptId,current,size);
        return Result.success(page);
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/equip/{equipName}")
    public Result<?> searchEquip(@PathVariable(required = false) String equipName,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysEquipmentEntity> page = searchService.searchEquip(equipName,current,size);
        return Result.success(page);
    }
}

```

## File: controller\task\TaskController.java

- Extension: .java
- Language: java
- Size: 2751 bytes
- Created: 2026-03-18 20:53:21
- Modified: 2026-03-29 19:00:48

### Code

```java
package com.xwd.xwd_uoms.controller.task;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysTaskEntity;
import com.xwd.xwd_uoms.service.task.TaskService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.web.bind.annotation.*;

@Log(module = "task")
@RestController
@RequestMapping("/xwd_uoms/api/task")
public class TaskController {
    @Resource
    private TaskService taskService;

    @PutMapping("/update")
    @RequirePermission(object = "task",operation = "update")
    public Result<?> taskUpdate(@RequestBody SysTaskEntity task){
        taskService.taskUpdate(task);
        return Result.success("任务更新成功.");
    }

    @PostMapping("/add")
    @RequirePermission(object = "task",operation = "add")
    public Result<?> taskAdd(@RequestBody SysTaskEntity task){
        taskService.taskAdd(task);
        return Result.success("任务创建成功.");
    }

    @DeleteMapping("/deleted/{taskId}")
    @RequirePermission(object = "task",operation = "deleted")
    public Result<?> taskDeleted(@PathVariable Long taskId){
        taskService.taskDeleted(taskId);
        return Result.success("任务删除成功.");
    }

    @PutMapping("/approve")
    @RequirePermission(object = "task",operation = "approve")
    public Result<?> approveTask(@RequestBody SysTaskEntity task){
        taskService.finiTask(task);
        return Result.success("任务审批成功.");
    }

    @GetMapping("/received/{mandatoryId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showRecTask(@PathVariable Long mandatoryId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysTaskEntity> page = taskService.showRecTask(mandatoryId, current, size);
        return Result.success(page);
    }

    @GetMapping("/pending/{originatorId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showPendTask(@PathVariable Long originatorId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysTaskEntity> page = taskService.showPendTask(originatorId, current, size);
        return Result.success(page);
    }

    @GetMapping("/show/{taskId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showTask(@PathVariable Long taskId){
        SysTaskEntity task = taskService.showTask(taskId);
        return Result.success(task);
    }
}

```

## File: controller\taskfeedback\TaskFeedbackController.java

- Extension: .java
- Language: java
- Size: 2915 bytes
- Created: 2026-03-18 20:35:29
- Modified: 2026-03-29 19:00:48

### Code

```java
package com.xwd.xwd_uoms.controller.taskfeedback;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.entity.SysTaskFeedbackEntity;
import com.xwd.xwd_uoms.service.taskfeedback.TaskFeedbackService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.web.bind.annotation.*;

@Log(module = "tfb")
@RestController
@RequestMapping("/xwd_uoms/api/taskfeedback")
public class TaskFeedbackController {
    @Resource
    private TaskFeedbackService taskFeedbackService;

    @PutMapping("/update")
    @RequirePermission(object = "",operation = "")
    public Result<?> taskFeedbackUpdate(@RequestBody SysTaskFeedbackEntity taskFeedback){
        taskFeedbackService.taskFeedbackUpdate(taskFeedback);
        return Result.success("任务反馈信息更新成功.");
    }

    @PostMapping("/add")
    @RequirePermission(object = "",operation = "")
    public Result<?> taskFeedbackAdd(@RequestBody SysTaskFeedbackEntity taskFeedback){
        taskFeedbackService.taskFeedbackAdd(taskFeedback);
        return Result.success("任务反馈成功.");
    }

    @GetMapping("/received/view/{reviewUserId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showRecTaskFeedback(@PathVariable Long reviewUserId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysTaskFeedbackEntity> page = taskFeedbackService.showRecTaskFeedback(reviewUserId, current, size);
        return Result.success(page);
    }

    @GetMapping("/pending/view/{feedbackUserId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showPendTaskFeedback(@PathVariable Long feedbackUserId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysTaskFeedbackEntity> page = taskFeedbackService.showPendTaskFeedback(feedbackUserId, current, size);
        return Result.success(page);
    }

    @PutMapping("/approve/{reviewUserId}")
    @RequirePermission(object = "taskFeedback",operation = "approve")
    public Result<?> approveTaskFeedback(@PathVariable Long reviewUserId , @RequestBody SysTaskFeedbackEntity taskFeedback){
        taskFeedbackService.approveTaskFeedback(reviewUserId,taskFeedback);
        return Result.success("任务反馈审批成功.");
    }

    @GetMapping("/show/{taskFeedbackId}")
    @RequirePermission(object = "",operation = "")
    public Result<?> showTaskFeedback(@PathVariable Long taskFeedbackId){
        SysTaskFeedbackEntity taskFeedback = taskFeedbackService.showTaskFeedback(taskFeedbackId);
        return Result.success(taskFeedback);
    }
}

```

## File: controller\user\UserController.java

- Extension: .java
- Language: java
- Size: 3512 bytes
- Created: 2026-02-04 11:14:02
- Modified: 2026-03-29 19:00:48

### Code

```java
package com.xwd.xwd_uoms.controller.user;

import com.xwd.xwd_uoms.common.annotation.Log;
import com.xwd.xwd_uoms.common.annotation.RequirePermission;
import com.xwd.xwd_uoms.common.result.Result;
import com.xwd.xwd_uoms.common.util.JwtUtil;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.entity.dto.AdminDTO;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import com.xwd.xwd_uoms.service.user.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Log(module = "user")
@RestController
@RequestMapping("/xwd_uoms/api/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequirePermission(object = "",operation = "")
    @PutMapping("/self/update/{userId}")
    public Result<?> updateSelf(@PathVariable Long userId,@RequestBody SysUserDTO sysUserDTO) throws Exception {
        userService.userUpdate(userId,sysUserDTO);
        return Result.success("用户数据更新成功.");
    }

    @RequirePermission(object = "",operation = "")
    @PutMapping("/self/cancel")
    public Result<?> cancelSelf(@RequestBody String refreshToken) throws Exception {
        userService.userDelete(refreshToken);
        return Result.success("用户注销成功.");
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/view/{userId}")
    public Result<?> showSelf(@PathVariable Long userId) throws Exception {
        SysUserDTO self = userService.userView(userId);
        return Result.success(self);
    }

    @RequirePermission(object = "user",operation = "add")
    @PostMapping("/oth/add")
    public Result<?> userAdd(@RequestBody SysUserDTO sysUserDTO) throws Exception {
        userService.userAdd(sysUserDTO);
        return Result.success("用户添加成功.");
    }

    @RequirePermission(object = "user",operation = "update")
    @PutMapping("/oth/update")
    public Result<?> userUpdate(@RequestBody SysUserDTO sysUserDTO) throws Exception {
        userService.userUpdate(sysUserDTO);
        return Result.success("用户数据更新成功.");
    }

    @RequirePermission(object = "user",operation = "move")
    @PutMapping("/oth/move")
    public Result<?> userMove(@RequestBody SysUserDTO sysUserDTO) throws Exception {
        userService.userMove(sysUserDTO);
        return Result.success("用户迁移成功.");
    }

    @RequirePermission(object = "user",operation = "delete")
    @DeleteMapping("/oth/delete/{userId}")
    public Result<?> userDelete(@PathVariable Long userId) throws Exception {
        userService.userDelete(userId);
        return Result.success("用户删除成功.");
    }

    @RequirePermission(object = "perm",operation = "update")
    @PutMapping("/perm/update")
    public Result<?> permUpdate(@RequestBody AdminDTO adminDTO) throws Exception {
        userService.permUpdate(adminDTO);
        return Result.success("用户权限变更成功.");
    }

    @RequirePermission(object = "",operation = "")
    @GetMapping("/show/admin/{orgId}")
    public Result<?> showOrgAdmin(@PathVariable(required = false) Long orgId,@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size){
        Page<SysUserEntity> page = userService.showAdmin(orgId, current, size);
        return Result.success(page);
    }
}

```

## File: entity\SysApplyEntity.java

- Extension: .java
- Language: java
- Size: 1560 bytes
- Created: 2026-01-26 15:34:01
- Modified: 2026-03-07 14:03:17

### Code

```java
package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.Map;

@Data
@Entity
@Table(name = "sys_apply")
public class SysApplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apply_user_id", nullable = false)
    private Long applyUserId;

    @Column(name = "apply_operation_code", length = 50, nullable = false)
    private String applyOperationCode;

    @Column(name = "target_object", length = 20, nullable = false)
    private String targetObject;

    @Column(name = "apply_desc", length = 2000)
    private String applyDesc;

    @Column(name = "apply_content", nullable = false, columnDefinition = "JSON")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> applyContent;

    @Column(name = "apply_time")
    private LocalDate applyTime;

    @Column(name = "approver_user_id")
    private Long approverUserId;

    @Column(name = "apply_status", nullable = false)
    private Byte applyStatus;

    @Column(length = 1000)
    private String remark;

    @Column(name = "is_deleted", nullable = false)
    private Byte isDeleted;

    @Column(name = "approve_time")
    private LocalDate approveTime;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}
```

## File: entity\SysDepartmentEntity.java

- Extension: .java
- Language: java
- Size: 1012 bytes
- Created: 2026-01-26 15:12:22
- Modified: 2026-02-05 17:48:14

### Code

```java
package com.xwd.xwd_uoms.entity;

import cn.hutool.core.date.DateTime;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_department", uniqueConstraints = {
        @UniqueConstraint(name = "uk_sys_dept_orgid_name", columnNames = {"org_id", "name"})
})
public class SysDepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "org_id", nullable = false)
    private Long orgId;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(name = "dept_desc", length = 1000)
    private String deptDesc;

    @Column(nullable = false)
    private Byte status;

    @Column(name = "is_deleted", nullable = false)
    private Byte isDeleted;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}

```

## File: entity\SysEquipmentBorrowEntity.java

- Extension: .java
- Language: java
- Size: 1304 bytes
- Created: 2026-01-26 15:16:22
- Modified: 2026-02-05 17:48:14

### Code

```java
package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_equipment_borrow")
public class SysEquipmentBorrowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "equipment_id", nullable = false)
    private Long equipmentId;

    @Column(name = "org_id", nullable = false)
    private Long orgId;

    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "borrow_num", nullable = false)
    private Integer borrowNum;

    @Column(name = "borrower_id", nullable = false)
    private Long borrowerId;

    @Column(name = "borrow_time")
    private LocalDate borrowTime;

    @Column(name = "approver_id", nullable = false)
    private Long approverId;

    @Column(name = "approve_time")
    private LocalDate approveTime;

    @Column(name = "return_time")
    private LocalDate returnTime;

    @Column(nullable = false)
    private Byte status;

    @Column(length = 500)
    private String remark;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}
```

## File: entity\SysEquipmentEntity.java

- Extension: .java
- Language: java
- Size: 1229 bytes
- Created: 2026-01-26 15:15:07
- Modified: 2026-02-05 17:48:14

### Code

```java
package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_equipment", uniqueConstraints = {
        @UniqueConstraint(name = "uk_sys_equip_org_dept_name", columnNames = {"org_id", "dept_id", "name"})
})
public class SysEquipmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(name = "equipment_desc", length = 500)
    private String equipmentDesc;

    @Column(name = "org_id", nullable = false)
    private Long orgId;

    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "total_num", nullable = false)
    private Integer totalNum;

    @Column(name = "available_num", nullable = false)
    private Integer availableNum;

    @Column(nullable = false)
    private Byte status;

    @Column(name = "is_deleted", nullable = false)
    private Byte isDeleted;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}
```

## File: entity\SysFeedbackEntity.java

- Extension: .java
- Language: java
- Size: 1244 bytes
- Created: 2026-01-26 15:34:40
- Modified: 2026-03-23 19:14:52

### Code

```java
package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_feedback")
public class SysFeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "feedback_user_id", nullable = false)
    private Long feedbackUserId;

    @Column(name = "target_object", length = 20, nullable = false)
    private String targetObject;

    @Column(name = "feedback_content", length = 5000)
    private String feedbackContent;

    @Column(name = "feedback_time")
    private LocalDate feedbackTime;

    @Column(name = "handler_user_id", nullable = false)
    private Long handlerUserId;

    @Column(name = "feedback_status", nullable = false)
    private Byte feedbackStatus;

    @Column(length = 1000)
    private String remark;

    @Column(name = "is_deleted", nullable = false)
    private Byte isDeleted;

    @Column(name = "handle_time")
    private LocalDate handleTime;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}
```

## File: entity\SysNoticeEntity.java

- Extension: .java
- Language: java
- Size: 865 bytes
- Created: 2026-01-26 15:32:31
- Modified: 2026-03-23 19:14:52

### Code

```java
package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_notice")
public class SysNoticeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 2000)
    private String content;

    @Column(name = "originator_id", nullable = false)
    private Long originatorId;

    @Column(name = "mandatory_id", nullable = false)
    private Long mandatoryId;

    @Column(name = "is_deleted", nullable = false)
    private Byte isDeleted;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}
```

## File: entity\SysObjectEntity.java

- Extension: .java
- Language: java
- Size: 846 bytes
- Created: 2026-01-26 15:23:35
- Modified: 2026-02-05 17:48:14

### Code

```java
package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_object", uniqueConstraints = {
        @UniqueConstraint(name = "uk_sys_object_code", columnNames = "code")
})
public class SysObjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50, nullable = false)
    private String code;

    @Column(name = "object_desc", length = 500)
    private String objectDesc;

    @Column(nullable = false)
    private Byte status;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}
```

## File: entity\SysOperationEntity.java

- Extension: .java
- Language: java
- Size: 863 bytes
- Created: 2026-01-26 15:28:01
- Modified: 2026-02-05 17:48:14

### Code

```java
package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_operation", uniqueConstraints = {
        @UniqueConstraint(name = "uk_sys_operation_code", columnNames = "code")
})
public class SysOperationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50, nullable = false)
    private String code;

    @Column(name = "operation_desc", length = 500)
    private String operationDesc;

    @Column(nullable = false)
    private Byte status;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}

```

## File: entity\SysOrganizationEntity.java

- Extension: .java
- Language: java
- Size: 1080 bytes
- Created: 2026-01-26 14:15:18
- Modified: 2026-03-23 19:14:52

### Code

```java
package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_organization", uniqueConstraints = {
        @UniqueConstraint(name = "uk_sys_org_name_type", columnNames = {"name", "type"})
})
public class SysOrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String type;

    @Column(name = "org_desc", length = 1000)
    private String orgDesc;

    @Column(length = 255)
    private String address;

    @Column(length = 20)
    private String phone;

    @Column(nullable = false)
    private Byte status;

    @Column(name = "is_deleted", nullable = false)
    private Byte isDeleted;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}
```

## File: entity\SysRoleEntity.java

- Extension: .java
- Language: java
- Size: 885 bytes
- Created: 2026-01-26 15:23:03
- Modified: 2026-02-05 17:48:14

### Code

```java
package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_role", uniqueConstraints = {
        @UniqueConstraint(name = "uk_sys_role_name", columnNames = "name")
})
public class SysRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(name = "role_desc", length = 500)
    private String roleDesc = "暂无描述。";

    @Column(nullable = false)
    private Byte status;

    @Column(name = "is_deleted", nullable = false)
    private Byte isDeleted;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}
```

## File: entity\SysRolePermissionEntity.java

- Extension: .java
- Language: java
- Size: 743 bytes
- Created: 2026-01-26 15:31:47
- Modified: 2026-02-05 17:48:14

### Code

```java
package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_role_permission")
public class SysRolePermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "object_id")
    private Long objectId;

    @Column(name = "operation_id")
    private Long operationId;

    @Column(nullable = false)
    private Byte status;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}

```

## File: entity\SysTaskEntity.java

- Extension: .java
- Language: java
- Size: 991 bytes
- Created: 2026-01-26 15:13:09
- Modified: 2026-03-23 19:14:52

### Code

```java
package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_task")
public class SysTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(name = "task_desc", length = 2000)
    private String taskDesc;

    @Column(name = "originator_id", nullable = false)
    private Long originatorId;

    @Column(name = "mandatory_id", nullable = false)
    private Long mandatoryId;

    @Column()
    private LocalDate deadline;

    @Column(nullable = false)
    private Byte status;

    @Column(name = "is_deleted", nullable = false)
    private Byte isDeleted;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}
```

## File: entity\SysTaskFeedbackEntity.java

- Extension: .java
- Language: java
- Size: 1151 bytes
- Created: 2026-01-26 15:22:09
- Modified: 2026-03-23 19:14:52

### Code

```java
package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_task_feedback")
public class SysTaskFeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_id", nullable = false)
    private Long taskId;

    @Column(name = "feedback_user_id", nullable = false)
    private Long feedbackUserId;

    @Column(name = "feedback_content", length = 1000)
    private String feedbackContent;

    @Column(name = "feedback_time")
    private LocalDate feedbackTime;

    @Column(name = "review_user_id")
    private Long reviewUserId;

    @Column(name = "review_content", length = 1000)
    private String reviewContent;

    @Column(name = "review_status", nullable = false)
    private Byte reviewStatus;

    @Column(name = "review_time")
    private LocalDate reviewTime;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}
```

## File: entity\SysUserEntity.java

- Extension: .java
- Language: java
- Size: 1421 bytes
- Created: 2026-01-26 11:28:16
- Modified: 2026-03-23 19:14:52

### Code

```java
package com.xwd.xwd_uoms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_user", uniqueConstraints = {
        @UniqueConstraint(name = "uk_sys_user_username", columnNames = "username"),
        @UniqueConstraint(name = "uk_sys_user_phone", columnNames = "phone")
})
public class SysUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String grade;

    @Column(length = 20, nullable = false)
    private String phone;

    @Column(length = 100)
    private String email;

    @Column(name = "org_id")
    private Long orgId;

    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(nullable = false)
    private Byte status;

    @Column(name = "is_deleted", nullable = false)
    private Byte isDeleted;

    @Column(name = "create_date", updatable = false)
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;
}
```

## File: entity\dto\AdminDTO.java

- Extension: .java
- Language: java
- Size: 150 bytes
- Created: 2026-02-04 16:42:30
- Modified: 2026-02-04 17:17:43

### Code

```java
package com.xwd.xwd_uoms.entity.dto;

import lombok.Data;

@Data
public class AdminDTO {
    private Long userId;
    private Long roleId;
}

```

## File: entity\dto\LoginDTO.java

- Extension: .java
- Language: java
- Size: 305 bytes
- Created: 2026-01-29 10:08:50
- Modified: 2026-02-02 16:28:23

### Code

```java
package com.xwd.xwd_uoms.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDTO {
    @NotBlank(message = "账号不能为空.")
    private String username;

    @NotBlank(message = "密码不能为空.")
    private String password;
}

```

## File: entity\dto\SysUserDTO.java

- Extension: .java
- Language: java
- Size: 401 bytes
- Created: 2026-01-29 10:00:06
- Modified: 2026-03-29 19:38:58

### Code

```java
package com.xwd.xwd_uoms.entity.dto;

import lombok.Data;

@Data
public class SysUserDTO {
    private Long id;
    private Long roleId;
    private String username;
    private String name;
    private String password;
    private String grade;
    private String phone;
    private String email;
    private String orgType;
    private String orgName;
    private String deptName;
}
```

## File: repository\SysApplyRepository.java

- Extension: .java
- Language: java
- Size: 787 bytes
- Created: 2026-01-29 09:12:02
- Modified: 2026-03-10 14:55:50

### Code

```java
package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysApplyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysApplyRepository extends JpaRepository<SysApplyEntity,Long> {
    Page<SysApplyEntity> findAllByApproverUserIdAndApplyStatus(Long approverUserId, byte applyStatus, Pageable pageable);

    Page<SysApplyEntity> findAllByApplyUserIdAndApplyStatus(Long applyUserId, byte applyStatus, Pageable pageable);

    Page<SysApplyEntity> findAllByApplyUserId(Long applyUserId, Pageable pageable);

    SysApplyEntity findSysApplyEntityById(Long applyId);
}

```

## File: repository\SysDepartmentRepository.java

- Extension: .java
- Language: java
- Size: 1098 bytes
- Created: 2026-01-29 09:13:18
- Modified: 2026-03-29 19:11:45

### Code

```java
package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysDepartmentEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface SysDepartmentRepository extends JpaRepository<SysDepartmentEntity,Long> {
    Long findIdByOrgIdAndName(Long orgId, String deptName);

    Page<SysDepartmentEntity> findAllByOrgId(Long orgId, Pageable pageable);

    Page<SysDepartmentEntity> findAllByNameLike(String name, Pageable pageable);

    @Query("SELECT d.name FROM SysDepartmentEntity d WHERE d.id = :deptId")
    String findNameById(@Param("deptId") Long deptId);

    SysDepartmentEntity findSysDepartmentEntityById(Long dept);

    SysDepartmentEntity findSysDepartmentEntityByOrgIdAndName(Long orgId, String name);
}

```

## File: repository\SysEquipmentBorrowRepository.java

- Extension: .java
- Language: java
- Size: 1097 bytes
- Created: 2026-01-29 09:00:41
- Modified: 2026-03-16 15:38:40

### Code

```java
package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysEquipmentBorrowEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysEquipmentBorrowRepository extends JpaRepository<SysEquipmentBorrowEntity,Long> {
    Page<SysEquipmentBorrowEntity> findAllByBorrowerIdAndStatus(Long borrowerId, byte status, Pageable pageable);

    Page<SysEquipmentBorrowEntity> findAllByApproverIdAndStatus(Long approverId, byte status, Pageable pageable);

    SysEquipmentBorrowEntity findSysEquipmentBorrowEntityById(Long id);

    Page<SysEquipmentBorrowEntity> findAllByApproverId(Long approverId, Pageable pageable);

    Page<SysEquipmentBorrowEntity> findAllByBorrowerId(Long borrowerId, Pageable pageable);

    Page<SysEquipmentBorrowEntity> findAllByDeptId(Long deptId, Pageable pageable);

    Page<SysEquipmentBorrowEntity> findAllByOrgId(Long orgId, Pageable pageable);
}

```

## File: repository\SysEquipmentRepository.java

- Extension: .java
- Language: java
- Size: 766 bytes
- Created: 2026-01-29 08:57:55
- Modified: 2026-03-15 16:51:58

### Code

```java
package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysEquipmentEntity;
import com.xwd.xwd_uoms.entity.SysTaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysEquipmentRepository extends JpaRepository<SysEquipmentEntity,Long> {
    Page<SysEquipmentEntity> findAllByOrgId(Long orgId, Pageable pageable);

    Page<SysEquipmentEntity> findAllByDeptId(Long deptId, Pageable pageable);

    Page<SysEquipmentEntity> findAllByNameLike(String name, Pageable pageable);

    SysEquipmentEntity findSysEquipmentEntityById(Long equipId);
}

```

## File: repository\SysFeedbackRepository.java

- Extension: .java
- Language: java
- Size: 1024 bytes
- Created: 2026-01-29 09:12:35
- Modified: 2026-03-19 23:20:08

### Code

```java
package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysFeedbackEntity;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysFeedbackRepository extends JpaRepository<SysFeedbackEntity,Long> {
    Page<SysFeedbackEntity> findAllByHandlerUserIdAndFeedbackStatus(Long handlerUserId, byte feedbackStatus, Pageable pageable);

    Page<SysFeedbackEntity> findAllByFeedbackUserIdAndFeedbackStatus(Long feedbackUserId, byte feedbackStatus, Pageable pageable);

    SysFeedbackEntity findSysFeedbackEntityById(Long id);

    Page<SysFeedbackEntity> findAllByHandlerUserId(Long handlerUserId, Pageable pageable);

    Page<SysFeedbackEntity> findAllByFeedbackUserId(Long feedbackUserId, Pageable pageable);

    SysFeedbackEntity findSysFeedbackById(Long id);
}

```

## File: repository\SysNoticeRepository.java

- Extension: .java
- Language: java
- Size: 640 bytes
- Created: 2026-01-29 09:11:29
- Modified: 2026-03-12 17:31:10

### Code

```java
package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysNoticeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysNoticeRepository extends JpaRepository<SysNoticeEntity,Long> {
    Page<SysNoticeEntity> findAllByOriginatorId(Long originatorId, Pageable pageable);

    Page<SysNoticeEntity> findAllByMandatoryId(Long mandatoryId, Pageable pageable);

    SysNoticeEntity findSysNoticeEntityById(Long noticeId);
}

```

## File: repository\SysObjectRepository.java

- Extension: .java
- Language: java
- Size: 342 bytes
- Created: 2026-01-29 09:03:21
- Modified: 2026-01-30 10:57:57

### Code

```java
package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysObjectRepository extends JpaRepository<SysObjectEntity,Long> {
    Long findIdByCode(String code);
}

```

## File: repository\SysOperationRepository.java

- Extension: .java
- Language: java
- Size: 351 bytes
- Created: 2026-01-29 09:10:07
- Modified: 2026-01-30 10:57:57

### Code

```java
package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysOperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysOperationRepository extends JpaRepository<SysOperationEntity,Long> {
    Long findIdByCode(String code);
}

```

## File: repository\SysOrganizationRepository.java

- Extension: .java
- Language: java
- Size: 1153 bytes
- Created: 2026-01-29 08:55:39
- Modified: 2026-03-29 19:11:29

### Code

```java
package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysOrganizationEntity;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SysOrganizationRepository extends JpaRepository<SysOrganizationEntity,Long> {
    Long findIdByTypeAndName(String orgType, String orgName);

    Page<SysOrganizationEntity> findAllByNameLike(String name, Pageable pageable);

    @Query("SELECT o.name FROM SysOrganizationEntity o WHERE o.id = :orgId")
    String findNameById(@Param("orgId") Long orgId);

    @Query("SELECT o.type FROM SysOrganizationEntity o WHERE o.id = :orgId")
    String findTypeById(@Param("orgId") Long orgId);

    SysOrganizationEntity findSysOrganizationEntityById(Long id);

    SysOrganizationEntity findSysOrganizationEntityByNameAndType(String name, String type);
}

```

## File: repository\SysRolePermissionRepository.java

- Extension: .java
- Language: java
- Size: 429 bytes
- Created: 2026-01-29 09:10:51
- Modified: 2026-01-30 11:03:42

### Code

```java
package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysRolePermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRolePermissionRepository extends JpaRepository<SysRolePermissionEntity,Long> {
    boolean existsByRoleIdAndObjectIdAndOperationId(Long roleId, Long objectId, Long operationId);
}

```

## File: repository\SysRoleRepository.java

- Extension: .java
- Language: java
- Size: 354 bytes
- Created: 2026-01-29 09:02:21
- Modified: 2026-02-04 17:17:43

### Code

```java
package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleRepository extends JpaRepository<SysRoleEntity,Long> {
    SysRoleEntity findSysRoleEntityById(Long roleId);
}

```

## File: repository\SysTaskFeedbackRepository.java

- Extension: .java
- Language: java
- Size: 843 bytes
- Created: 2026-01-29 09:01:40
- Modified: 2026-03-19 23:20:08

### Code

```java
package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysFeedbackEntity;
import com.xwd.xwd_uoms.entity.SysTaskFeedbackEntity;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysTaskFeedbackRepository extends JpaRepository<SysTaskFeedbackEntity,Long> {
    SysTaskFeedbackEntity findSysTaskFeedbackEntityById(Long id);

    Page<SysTaskFeedbackEntity> findAllByFeedbackUserId(Long feedbackUserId, Pageable pageable);

    Page<SysTaskFeedbackEntity> findAllByReviewUserId(Long reviewUserId, Pageable pageable);

    SysTaskFeedbackEntity findSysTaskFeedbackById(Long id);
}

```

## File: repository\SysTaskRepository.java

- Extension: .java
- Language: java
- Size: 832 bytes
- Created: 2026-01-29 08:57:04
- Modified: 2026-03-12 18:04:21

### Code

```java
package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysTaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysTaskRepository extends JpaRepository<SysTaskEntity,Long> {
    Page<SysTaskEntity> findAllByMandatoryIdAndStatus(Long mandatoryId, byte b, Pageable pageable);

    Page<SysTaskEntity> findAllByOriginatorIdAndStatus(Long originatorId, byte b, Pageable pageable);

    SysTaskEntity findSysTaskEntityById(Long taskId);

    Page<SysTaskEntity> findAllByMandatoryId(Long mandatoryId, Pageable pageable);

    Page<SysTaskEntity> findAllByOriginatorId(Long originatorId, Pageable pageable);
}

```

## File: repository\SysUserRepository.java

- Extension: .java
- Language: java
- Size: 1075 bytes
- Created: 2026-01-29 08:52:26
- Modified: 2026-03-29 17:58:46

### Code

```java
package com.xwd.xwd_uoms.repository;

import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends JpaRepository<SysUserEntity,Long> {
    SysUserEntity findSysUserEntityByUsername(String username);

    SysUserEntity findSysUserEntityById(Long id);

    SysUserEntity findByUsername(@NotBlank(message = "账号不能为空.") String username);

    Page<SysUserEntity> findAllByNameLike(String name, Pageable pageable);

    Page<SysUserEntity> findAllByDeptId(Long deptId, Pageable pageable);

    Page<SysUserEntity> findAllByRoleIdNot(long roleId, Pageable pageable);

    Long findRoleIdById(Long userId);

    Page<SysUserEntity> findAllByOrgIdAndRoleIdNot(Long orgId, long l, Pageable pageable);
}

```

## File: service\apply\ApplyService.java

- Extension: .java
- Language: java
- Size: 582 bytes
- Created: 2026-03-05 14:07:28
- Modified: 2026-03-18 06:29:58

### Code

```java
package com.xwd.xwd_uoms.service.apply;

import com.xwd.xwd_uoms.entity.SysApplyEntity;
import org.springframework.data.domain.Page;

public interface ApplyService {
    void createApply(SysApplyEntity sysApplyEntity);

    Page<SysApplyEntity> showPendApply(Long applyUserId,Integer current,Integer size);

    Page<SysApplyEntity> showRecApply(Long approveUserId,Integer current,Integer size);

    void approveApply(Long approveUserId, SysApplyEntity apply) throws Exception;

    void deletedApply(Long applyId);

    SysApplyEntity showApply(Long applyId);
}

```

## File: service\apply\impl\ApplyServiceImpl.java

- Extension: .java
- Language: java
- Size: 15721 bytes
- Created: 2026-03-10 13:30:54
- Modified: 2026-03-29 16:48:43

### Code

```java
package com.xwd.xwd_uoms.service.apply.impl;

import com.xwd.xwd_uoms.common.util.ConvertUtil;
import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.entity.*;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import com.xwd.xwd_uoms.repository.*;
import com.xwd.xwd_uoms.service.apply.ApplyService;
import com.xwd.xwd_uoms.service.dept.DeptService;
import com.xwd.xwd_uoms.service.equip.EquipService;
import com.xwd.xwd_uoms.service.feedback.FeedbackService;
import com.xwd.xwd_uoms.service.notice.NoticeService;
import com.xwd.xwd_uoms.service.org.OrgService;
import com.xwd.xwd_uoms.service.task.TaskService;
import com.xwd.xwd_uoms.service.taskfeedback.TaskFeedbackService;
import com.xwd.xwd_uoms.service.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional
public class ApplyServiceImpl implements ApplyService {
    @Resource
    private ConvertUtil convertUtil;

    @Resource
    private VerifyUtil verifyUtil;

    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysOrganizationRepository sysOrganizationRepository;

    @Resource
    private SysDepartmentRepository sysDepartmentRepository;

    @Resource
    private SysEquipmentRepository sysEquipmentRepository;

    @Resource
    private SysApplyRepository sysApplyRepository;

    @Resource
    private SysTaskRepository sysTaskRepository;

    @Resource
    private SysNoticeRepository sysNoticeRepository;

    @Resource
    private SysTaskFeedbackRepository sysTaskFeedbackRepository;

    @Resource
    private SysFeedbackRepository sysFeedbackRepository;

    @Resource
    private UserService userService;

    @Resource
    private OrgService orgService;

    @Resource
    private DeptService deptService;

    @Resource
    private EquipService equipService;

    @Resource
    private NoticeService noticeService;

    @Resource
    private TaskService taskService;

    @Resource
    private FeedbackService feedbackService;

    @Resource
    private TaskFeedbackService taskFeedbackService;

    @Override
    public void createApply(SysApplyEntity apply) {
        String type = apply.getTargetObject();
        Long approveUserRoleId = sysUserRepository.findRoleIdById(apply.getApproverUserId());
        if (!verifyUtil.isExist(approveUserRoleId) ||
                !verifyUtil.hasPerm(approveUserRoleId,type,apply.getApplyOperationCode())){
            throw new IllegalArgumentException("目标审批用户无权审批此操作.");
        }
        switch (type){
            case "user":{
                SysUserDTO user = convertUtil.mapSOToUserDTO(apply.getApplyContent());
                if (!apply.getApplyOperationCode().equals("add")) {
                    Long userId = user.getId();
                    if (!verifyUtil.isExist(userId) || !verifyUtil.isExist(sysUserRepository.findSysUserEntityById(userId))) {
                        throw new IllegalArgumentException("操作对象不存在.");
                    }
                }
                sysApplyRepository.save(apply);
                break;
            } case "org":{
                SysOrganizationEntity org = convertUtil.mapSOToOrgEntity(apply.getApplyContent());
                if (!apply.getApplyOperationCode().equals("add")){
                    Long orgId = org.getId();
                    if (!verifyUtil.isExist(orgId) || !verifyUtil.isExist(sysOrganizationRepository.findSysOrganizationEntityById(orgId))){
                        throw new IllegalArgumentException("操作对象不存在.");
                    }
                }
                sysApplyRepository.save(apply);
                break;
            } case "dept":{
                SysDepartmentEntity dept = convertUtil.mapSOToDeptEntity(apply.getApplyContent());
                if (!apply.getApplyOperationCode().equals("add")){
                    Long deptId = dept.getId();
                    if (!verifyUtil.isExist(deptId) || !verifyUtil.isExist(sysDepartmentRepository.findSysDepartmentEntityById(deptId))){
                        throw new IllegalArgumentException("操作对象不存在.");
                    }
                }
                sysApplyRepository.save(apply);
                break;
            } case "equip":{
                SysEquipmentEntity equip = convertUtil.mapSOToEquipEntity(apply.getApplyContent());
                if (!apply.getApplyOperationCode().equals("add")){
                    Long equipId = equip.getId();
                    if (!verifyUtil.isExist(equipId) || !verifyUtil.isExist(sysEquipmentRepository.findSysEquipmentEntityById(equipId))){
                        throw new IllegalArgumentException("操作对象不存在.");
                    }
                }
                sysApplyRepository.save(apply);
                break;
            } case "task": {
                SysTaskEntity task = convertUtil.mapSOToTaskEntity(apply.getApplyContent());
                if (!apply.getApplyOperationCode().equals("add")){
                    Long taskId = task.getId();
                    if (!verifyUtil.isExist(taskId) || !verifyUtil.isExist(sysTaskRepository.findSysTaskEntityById(taskId))){
                        throw new IllegalArgumentException("操作对象不存在.");
                    }
                }
                sysApplyRepository.save(apply);
                break;
            } case "notice": {
                SysNoticeEntity notice = convertUtil.mapSOToNoticeEntity(apply.getApplyContent());
                if (!apply.getApplyOperationCode().equals("add")){
                    Long noticeId = notice.getId();
                    if (!verifyUtil.isExist(noticeId) || !verifyUtil.isExist(sysNoticeRepository.findSysNoticeEntityById(noticeId))){
                        throw new IllegalArgumentException("操作对象不存在.");
                    }
                }
                sysApplyRepository.save(apply);
                break;
            } case "feedback": {
                SysFeedbackEntity feedback = convertUtil.mapSOToFeedbackEntity(apply.getApplyContent());
                if (!apply.getApplyOperationCode().equals("add")){
                    Long feedbackId = feedback.getId();
                    if (!verifyUtil.isExist(feedbackId) || !verifyUtil.isExist(sysFeedbackRepository.findSysFeedbackById(feedbackId))){
                        throw new IllegalArgumentException("操作对象不存在.");
                    }
                }
                sysApplyRepository.save(apply);
                break;
            } case "taskFeedback": {
                SysTaskFeedbackEntity taskFeedback = convertUtil.mapSOToTaskFeedbackEntity(apply.getApplyContent());
                if (!apply.getApplyOperationCode().equals("add")){
                    Long taskFeedbackId = taskFeedback.getId();
                    if (!verifyUtil.isExist(taskFeedbackId) || !verifyUtil.isExist(sysTaskFeedbackRepository.findSysTaskFeedbackById(taskFeedbackId))){
                        throw new IllegalArgumentException("操作对象不存在.");
                    }
                }
                sysApplyRepository.save(apply);
                break;
            } default :{
                throw new IllegalArgumentException("申请目标类型不存在.");
            }
        }
    }

    @Override
    public Page<SysApplyEntity> showPendApply(Long applyUserId,Integer current,Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysApplyEntity> page = sysApplyRepository.findAllByApplyUserId(applyUserId,pageable);
        return page;
    }

    @Override
    public Page<SysApplyEntity> showRecApply(Long approveUserId,Integer current,Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysApplyEntity> page = sysApplyRepository.findAllByApplyUserId(approveUserId,pageable);
        return page;
    }

    @Override
    public void approveApply(Long approveUserId, SysApplyEntity apply) throws Exception {
        if (Objects.equals(apply.getApplyStatus(),(byte)1)) {
            if (!verifyUtil.isExist(apply)) {
                throw new IllegalArgumentException("申请表不存在.");
            }
            if (!Objects.equals(apply.getApproverUserId(), approveUserId)) {
                throw new IllegalArgumentException("审批人不匹配.");
            }
            String type = apply.getTargetObject();
            switch (type) {
                case "user": {
                    SysUserDTO user = convertUtil.mapSOToUserDTO(apply.getApplyContent());
                    if (apply.getApplyOperationCode().equals("add")) {
                        userService.userAdd(user);
                    } else if (apply.getApplyOperationCode().equals("update")){
                        userService.userUpdate(user);
                    } else if (apply.getApplyOperationCode().equals("deleted")){
                        userService.userDelete(user.getId());
                    } else {
                        throw new IllegalArgumentException("操作代码非法.");
                    }
                    break;
                }
                case "org": {
                    SysOrganizationEntity org = convertUtil.mapSOToOrgEntity(apply.getApplyContent());
                    if (apply.getApplyOperationCode().equals("update")) {
                        orgService.orgUpdate(org);
                    } else if(apply.getApplyOperationCode().equals("add")){
                        orgService.orgAdd(org);
                    } else if (apply.getApplyOperationCode().equals("deleted")) {
                        orgService.orgDeleted(org.getId());
                    } else {
                        throw new IllegalArgumentException("操作代码非法.");
                    }
                    break;
                }
                case "dept": {
                    SysDepartmentEntity dept = convertUtil.mapSOToDeptEntity(apply.getApplyContent());
                    if (apply.getApplyOperationCode().equals("update")) {
                        deptService.deptUpdate(dept);
                    } else if (apply.getApplyOperationCode().equals("add")){
                        deptService.deptAdd(dept);
                    } else if (apply.getApplyOperationCode().equals("deleted")){
                        deptService.deptDeleted(dept.getId());
                    } else {
                        throw new IllegalArgumentException("操作代码非法.");
                    }
                    break;
                }
                case "equip": {
                    SysEquipmentEntity equip = convertUtil.mapSOToEquipEntity(apply.getApplyContent());
                    if (apply.getApplyOperationCode().equals("update")) {
                        equipService.equipUpdate(equip);
                    } else if (apply.getApplyOperationCode().equals("add")){
                        equipService.equipAdd(equip);
                    } else if (apply.getApplyOperationCode().equals("deleted")) {
                        equipService.equipDeleted(equip.getId());
                    } else {
                        throw new IllegalArgumentException("操作代码非法.");
                    }
                    break;
                }
                case "task": {
                    SysTaskEntity task = convertUtil.mapSOToTaskEntity(apply.getApplyContent());
                    if (apply.getApplyOperationCode().equals("update")) {
                        taskService.taskUpdate(task);
                    } else if (apply.getApplyOperationCode().equals("add")){
                        taskService.taskAdd(task);
                    } else if (apply.getApplyOperationCode().equals("deleted")) {
                        taskService.taskDeleted(task.getId());
                    } else {
                        throw new IllegalArgumentException("操作代码非法.");
                    }
                    break;
                }
                case "notice": {
                    SysNoticeEntity notice = convertUtil.mapSOToNoticeEntity(apply.getApplyContent());
                    if (apply.getApplyOperationCode().equals("update")) {
                        noticeService.noticeUpdate(notice);
                    } else if (apply.getApplyOperationCode().equals("add")){
                        noticeService.noticeAdd(notice);
                    } else if (apply.getApplyOperationCode().equals("deleted")) {
                        noticeService.noticeDeleted(notice.getId());
                    } else {
                        throw new IllegalArgumentException("操作代码非法.");
                    }
                    break;
                }
                case "feedback": {
                    SysFeedbackEntity feedback = convertUtil.mapSOToFeedbackEntity(apply.getApplyContent());
                    if (apply.getApplyOperationCode().equals("update")) {
                        feedbackService.feedbackUpdate(feedback);
                    } else if (apply.getApplyOperationCode().equals("add")){
                        feedbackService.feedbackAdd(feedback);
                    } else if (apply.getApplyOperationCode().equals("deleted")) {
                        feedbackService.feedbackDeleted(feedback.getId());
                    } else {
                        throw new IllegalArgumentException("操作代码非法.");
                    }
                    break;
                }
                case "taskFeedback": {
                    SysTaskFeedbackEntity taskFeedback = convertUtil.mapSOToTaskFeedbackEntity(apply.getApplyContent());
                    if (apply.getApplyOperationCode().equals("update")) {
                        taskFeedbackService.taskFeedbackUpdate(taskFeedback);
                    } else if (apply.getApplyOperationCode().equals("add")){
                        taskFeedbackService.taskFeedbackAdd(taskFeedback);
                    } else {
                        throw new IllegalArgumentException("操作代码非法.");
                    }
                    break;
                }
                default: {
                    throw new IllegalArgumentException("目标代码不存在.");
                }
            }
        }
        sysApplyRepository.save(apply);
    }

    @Override
    public void deletedApply(Long applyId){
        SysApplyEntity apply = sysApplyRepository.findSysApplyEntityById(applyId);
        if (!verifyUtil.isExist(apply)){
            throw new IllegalArgumentException("申请表不存在.");
        }

        apply.setIsDeleted((byte)1);
        LocalDate now = LocalDate.now();
        apply.setUpdateDate(now);
        sysApplyRepository.save(apply);
    }

    @Override
    public SysApplyEntity showApply(Long applyId){
        SysApplyEntity apply = sysApplyRepository.findSysApplyEntityById(applyId);
        if (!verifyUtil.isExist(apply)){
            throw new IllegalArgumentException("申请表不存在.");
        }
        return apply;
    }
}

```

## File: service\auth\LoginService.java

- Extension: .java
- Language: java
- Size: 349 bytes
- Created: 2026-02-02 16:44:55
- Modified: 2026-03-26 20:07:35

### Code

```java
package com.xwd.xwd_uoms.service.auth;

import com.xwd.xwd_uoms.entity.dto.LoginDTO;

import java.util.Map;

public interface LoginService {
    void verifyUserLogin(LoginDTO loginDTO) throws Exception;

    Map<String,Object> generateDatas(LoginDTO loginDTO) throws Exception;

    void logout(String refreshToken) throws Exception;
}

```

## File: service\auth\TokenService.java

- Extension: .java
- Language: java
- Size: 399 bytes
- Created: 2026-02-03 10:21:35
- Modified: 2026-02-28 11:06:47

### Code

```java
package com.xwd.xwd_uoms.service.auth;

import java.util.Map;

public interface TokenService {
    void verifyRefreshToken(String refreshToken) throws Exception;

    Map<String,String> generateTokens(Map<String, Object> claims, String Key) throws Exception;

    void deleteToken(String refreshToken) throws Exception;

    String refreshToken(String refreshToken) throws Exception;
}

```

## File: service\auth\impl\LoginServiceImpl.java

- Extension: .java
- Language: java
- Size: 2418 bytes
- Created: 2026-02-02 17:04:26
- Modified: 2026-03-26 20:07:35

### Code

```java
package com.xwd.xwd_uoms.service.auth.impl;

import com.xwd.xwd_uoms.common.util.ConvertUtil;
import com.xwd.xwd_uoms.common.util.PasswordEncryptUtil;
import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.entity.dto.LoginDTO;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import com.xwd.xwd_uoms.service.auth.LoginService;
import com.xwd.xwd_uoms.service.auth.TokenService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private PasswordEncryptUtil passwordEncryptUtil;

    @Resource
    private TokenService tokenService;

    @Resource
    private VerifyUtil verifyUtil;

    @Resource
    private ConvertUtil convertUtil;

    @Override
    public void verifyUserLogin(LoginDTO loginDTO) throws Exception {
        SysUserEntity sysUser = sysUserRepository.findByUsername(loginDTO.getUsername());

        if (!verifyUtil.isExist(sysUser)) {
            throw new LoginException("找不到用户.");
        }

        if (!passwordEncryptUtil.matchPassword(loginDTO.getPassword(), sysUser.getPassword())) {

            throw new LoginException("密码错误.");
        }
    }

    @Override
    public Map<String,Object> generateDatas(LoginDTO loginDTO) throws Exception {
        SysUserEntity sysUser = sysUserRepository.findSysUserEntityByUsername(loginDTO.getUsername());
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", sysUser.getId());
        claims.put("username", sysUser.getUsername());
        claims.put("roleId", sysUser.getRoleId());

        Map<String,String> tokens = tokenService.generateTokens(claims, sysUser.getUsername());

        Map<String,Object> result = new HashMap<>();
        result.put("accessToken",tokens.get("accessToken"));
        result.put("refreshToken",tokens.get("refreshToken"));
        result.put("userInfo",convertUtil.userToDTO(sysUser));

        return result;
    }

    @Override
    public void logout(String refreshToken) throws Exception {
        tokenService.deleteToken(refreshToken);
    }
}

```

## File: service\auth\impl\TokenServiceImpl.java

- Extension: .java
- Language: java
- Size: 4078 bytes
- Created: 2026-02-03 10:22:06
- Modified: 2026-03-24 22:09:32

### Code

```java
package com.xwd.xwd_uoms.service.auth.impl;

import com.xwd.xwd_uoms.common.util.JwtUtil;
import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.jwtconfig.JwtConfig;
import com.xwd.xwd_uoms.service.auth.TokenService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class TokenServiceImpl implements TokenService {
    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private JwtConfig jwtConfig;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void verifyRefreshToken(String refreshToken) throws Exception {
        try {
            jwtUtil.validateToken(refreshToken);
            String username = jwtUtil.getFromToken(refreshToken,"username");
            String redisKey = "refresh_token:" + username;

            String redisRefreshToken = redisTemplate.opsForValue().get(redisKey);
            if (!verifyUtil.isExist(redisRefreshToken)) {
                throw new IllegalArgumentException("Token不存在，请重新登录.");
            }
            if (!Objects.equals(redisRefreshToken,refreshToken)) {
                throw new IllegalArgumentException("Token无效，请重新登录.");
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (Exception e) {
            throw new Exception("Token校验失败：" + e.getMessage());
        }
    }

    @Override
    public Map<String,String> generateTokens(Map<String, Object> claims, String key) throws Exception {
        String refreshToken = jwtUtil.generateRefreshToken(claims);
        String accessToken = jwtUtil.generateAccessToken(claims);

        try {
            String redisKey = "refresh_token:" + key;
            redisTemplate.opsForValue().set(
                    redisKey,
                    refreshToken,
                    jwtConfig.getRefreshExpiration(),
                    TimeUnit.MILLISECONDS
            );

            redisKey = "access_token:" + key;
            redisTemplate.opsForValue().set(
                    redisKey,
                    accessToken,
                    jwtConfig.getAccessExpiration(),
                    TimeUnit.MILLISECONDS
            );

        }catch (RuntimeException e){
            throw new RuntimeException("Redis服务异常.");
        }

        Map<String,String> tokens = new HashMap<>();
        tokens.put("refreshToken",refreshToken);
        tokens.put("accessToken",accessToken);
        return tokens;
    }

    @Override
    public void deleteToken(String refreshToken) throws Exception {
        String username = jwtUtil.getFromToken(refreshToken,"username");
        String redisKey = "refresh_token:" + username;
        redisTemplate.delete(redisKey);
    }

    @Override
    public String refreshToken(String refreshToken) throws Exception {
        verifyRefreshToken(refreshToken);

        Map<String, Object> claims = jwtUtil.parseToken(refreshToken);
        String accessToken = jwtUtil.generateAccessToken(claims);

        String username = jwtUtil.getFromToken(refreshToken,"username");

        try {
            String redisKey = "access_token:" + username;
            redisTemplate.delete(redisKey);

            redisTemplate.opsForValue().set(
                    redisKey,
                    accessToken,
                    jwtConfig.getAccessExpiration(),
                    TimeUnit.MILLISECONDS
            );
        }catch (RuntimeException e){
            throw new RuntimeException("Redis服务异常.");
        }

        return accessToken;
    }
}

```

## File: service\borrow\BorrowService.java

- Extension: .java
- Language: java
- Size: 836 bytes
- Created: 2026-03-05 14:09:40
- Modified: 2026-03-18 06:29:58

### Code

```java
package com.xwd.xwd_uoms.service.borrow;

import com.xwd.xwd_uoms.entity.SysEquipmentBorrowEntity;
import org.springframework.data.domain.Page;

public interface BorrowService {
    void borrowAdd(SysEquipmentBorrowEntity borrow);

    void approveBorrow(Long approveUserId, SysEquipmentBorrowEntity borrow);

    void borrowUpdate(SysEquipmentBorrowEntity borrow);

    Page<SysEquipmentBorrowEntity> showOrgBorrow(Long orgId, Integer current, Integer size);

    Page<SysEquipmentBorrowEntity> showDeptBorrow(Long deptId, Integer current, Integer size);

    Page<SysEquipmentBorrowEntity> showUnfBorrow(Long borrowerId, Integer current, Integer size);

    Page<SysEquipmentBorrowEntity> showPendBorrow(Long approverId, Integer current, Integer size);

    SysEquipmentBorrowEntity showBorrow(Long borrowId);
}

```

## File: service\borrow\impl\BorrowServiceImpl.java

- Extension: .java
- Language: java
- Size: 11102 bytes
- Created: 2026-03-15 16:38:42
- Modified: 2026-03-18 06:29:58

### Code

```java
package com.xwd.xwd_uoms.service.borrow.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysEquipBorrowDefaultConfig;
import com.xwd.xwd_uoms.entity.*;
import com.xwd.xwd_uoms.repository.*;
import com.xwd.xwd_uoms.service.borrow.BorrowService;
import com.xwd.xwd_uoms.service.equip.EquipService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {
    @Resource
    private SysEquipmentBorrowRepository sysEquipmentBorrowRepository;

    @Resource
    private SysEquipmentRepository sysEquipmentRepository;

    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysOrganizationRepository sysOrganizationRepository;

    @Resource
    private SysDepartmentRepository sysDepartmentRepository;

    @Resource
    private SysEquipBorrowDefaultConfig sysEquipBorrowDefaultConfig;

    @Resource
    private EquipService equipService;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void borrowAdd(SysEquipmentBorrowEntity borrow){
        LocalDate now = LocalDate.now();
        SysEquipmentEntity equip = sysEquipmentRepository.findSysEquipmentEntityById(borrow.getEquipmentId());
        if (!verifyUtil.isExist(equip)){
            throw new IllegalArgumentException("借取设备不存在.");
        }
        if (!verifyUtil.isExist(borrow.getBorrowNum()) ||
                !verifyUtil.isExist(equip.getAvailableNum() - borrow.getBorrowNum())){
            throw new IllegalArgumentException("借取数量异常.");
        }
        SysOrganizationEntity org = sysOrganizationRepository.findSysOrganizationEntityById(borrow.getOrgId());
        if (!verifyUtil.isExist(org) || !Objects.equals(borrow.getOrgId(), equip.getOrgId())){
            throw new IllegalArgumentException("借取表所属组织信息错误.");
        }
        if (verifyUtil.isExist(borrow.getDeptId())){
            SysDepartmentEntity dept = sysDepartmentRepository.findSysDepartmentEntityById(borrow.getDeptId());
            if (!Objects.equals(borrow.getDeptId(), equip.getDeptId()) || !verifyUtil.isExist(dept)){
                throw new IllegalArgumentException("借取表所属部门信息错误.");
            }
        }
        SysUserEntity borrowUser = sysUserRepository.findSysUserEntityById(borrow.getBorrowerId());
        if (!verifyUtil.isExist(borrowUser)){
            throw new IllegalArgumentException("设备借取人不存在.");
        }
        SysUserEntity approveUser = sysUserRepository.findSysUserEntityById(borrow.getApproverId());
        if (!verifyUtil.isExist(approveUser)){
            throw new IllegalArgumentException("审批人不存在.");
        }
        if (!verifyUtil.hasPerm(approveUser.getRoleId(), "borrow", "approve")){
            throw new IllegalArgumentException("审批人无权审批借取表.");
        }

        borrow.setStatus(sysEquipBorrowDefaultConfig.getStatus());
        borrow.setCreateDate(now);
        borrow.setUpdateDate(now);

        sysEquipmentBorrowRepository.save(borrow);
    }

    @Override
    public void approveBorrow(Long approveUserId, SysEquipmentBorrowEntity borrow){
        LocalDate now = LocalDate.now();
        if (!Objects.equals(approveUserId,borrow.getApproverId())){
            throw new IllegalArgumentException("审批人与借取表不匹配.");
        }
        SysEquipmentEntity equip = sysEquipmentRepository.findSysEquipmentEntityById(borrow.getEquipmentId());
        if (!verifyUtil.isExist(equip)){
            throw new IllegalArgumentException("借取设备不存在.");
        }
        SysOrganizationEntity org = sysOrganizationRepository.findSysOrganizationEntityById(borrow.getOrgId());
        if (!verifyUtil.isExist(org) || !Objects.equals(borrow.getOrgId(), equip.getOrgId())){
            throw new IllegalArgumentException("借取表所属组织信息错误.");
        }
        if (verifyUtil.isExist(borrow.getDeptId())){
            SysDepartmentEntity dept = sysDepartmentRepository.findSysDepartmentEntityById(borrow.getDeptId());
            if (!Objects.equals(borrow.getDeptId(), equip.getDeptId()) || !verifyUtil.isExist(dept)){
                throw new IllegalArgumentException("借取表所属部门信息错误.");
            }
        }
        SysUserEntity borrowUser = sysUserRepository.findSysUserEntityById(borrow.getBorrowerId());
        if (!verifyUtil.isExist(borrowUser)){
            throw new IllegalArgumentException("设备借取人不存在.");
        }
        SysUserEntity approveUser = sysUserRepository.findSysUserEntityById(approveUserId);
        if (!verifyUtil.isExist(approveUser)){
            throw new IllegalArgumentException("审批人不存在.");
        }
        if (!verifyUtil.isExist(borrow.getBorrowNum()) ||
                !verifyUtil.isExist(equip.getAvailableNum() - borrow.getBorrowNum())){
            throw new IllegalArgumentException("借取数量异常.");
        }
        SysEquipmentBorrowEntity oldBorrow = sysEquipmentBorrowRepository.findSysEquipmentBorrowEntityById(borrow.getId());
        if (!verifyUtil.isExist(oldBorrow)){
            throw new IllegalArgumentException("借取表不存在.");
        }
        if (oldBorrow.getStatus() == (byte)0 &&
                (borrow.getStatus() == (byte)1 || borrow.getStatus() == (byte)2)){
            oldBorrow.setStatus(borrow.getStatus());
            oldBorrow.setApproveTime(now);
            if (verifyUtil.isExist(borrow.getRemark())){
                oldBorrow.setRemark(borrow.getRemark());
            }
            if (borrow.getStatus() == (byte)2){
                equipService.equipBorrow(borrow.getId(), borrow.getBorrowNum());

                oldBorrow.setBorrowTime(now);
            }
        }else if(oldBorrow.getStatus() == (byte)2 &&
                (borrow.getStatus() == (byte)3 || borrow.getStatus() == (byte)4)){
            oldBorrow.setStatus(borrow.getStatus());
            oldBorrow.setApproveTime(now);
            if (borrow.getStatus() == (byte)3){
                oldBorrow.setReturnTime(now);
                equipService.equipBorrow(borrow.getId(), -borrow.getBorrowNum());
            }
        }else {
            throw new IllegalArgumentException("借取表借还状态异常.");
        }
        if (!verifyUtil.isExist(oldBorrow.getCreateDate())){
            oldBorrow.setCreateDate(now);
        }
        oldBorrow.setUpdateDate(now);

        sysEquipmentBorrowRepository.save(oldBorrow);
    }

    @Override
    public void borrowUpdate(SysEquipmentBorrowEntity borrow){
        LocalDate now = LocalDate.now();

        Long borrowId = borrow.getId();
        SysEquipmentBorrowEntity oldBorrow = sysEquipmentBorrowRepository.findSysEquipmentBorrowEntityById(borrowId);
        if (!verifyUtil.isExist(oldBorrow)){
            throw new IllegalArgumentException("借取表不存在.");
        }
        SysEquipmentEntity equip = sysEquipmentRepository.findSysEquipmentEntityById(borrow.getEquipmentId());
        if (!verifyUtil.isExist(equip)){
            throw new IllegalArgumentException("借取设备不存在.");
        }
        if (!verifyUtil.isExist(borrow.getBorrowNum()) ||
                !verifyUtil.isExist(equip.getAvailableNum() - borrow.getBorrowNum())){
            throw new IllegalArgumentException("借取数量异常.");
        }
        if (verifyUtil.isExist(borrow.getDeptId())){
            SysDepartmentEntity dept = sysDepartmentRepository.findSysDepartmentEntityById(borrow.getDeptId());
            if (!Objects.equals(borrow.getDeptId(), equip.getDeptId()) || !verifyUtil.isExist(dept)){
                throw new IllegalArgumentException("借取表所属部门信息错误.");
            }
        }
        SysUserEntity borrowUser = sysUserRepository.findSysUserEntityById(borrow.getBorrowerId());
        if (!verifyUtil.isExist(borrowUser)){
            throw new IllegalArgumentException("设备借取人不存在.");
        }
        SysUserEntity approveUser = sysUserRepository.findSysUserEntityById(borrow.getApproverId());
        if (!verifyUtil.isExist(approveUser)){
            throw new IllegalArgumentException("审批人不存在.");
        }
        if (!verifyUtil.hasPerm(approveUser.getRoleId(), "borrow", "approve")){
            throw new IllegalArgumentException("审批人无权审批借取表.");
        }

        oldBorrow.setEquipmentId(borrow.getEquipmentId());
        oldBorrow.setDeptId(borrow.getDeptId());
        oldBorrow.setBorrowNum(borrow.getBorrowNum());
        oldBorrow.setBorrowerId(borrow.getBorrowerId());
        oldBorrow.setApproverId(borrow.getApproverId());
        if (verifyUtil.isExist(borrow.getRemark())){
            oldBorrow.setRemark(borrow.getRemark());
        }
        oldBorrow.setUpdateDate(now);
        sysEquipmentBorrowRepository.save(oldBorrow);
    }

    @Override
    public Page<SysEquipmentBorrowEntity> showOrgBorrow(Long orgId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentBorrowEntity> page = sysEquipmentBorrowRepository.findAllByOrgId(orgId,pageable);
        return page;
    }

    @Override
    public Page<SysEquipmentBorrowEntity> showDeptBorrow(Long deptId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentBorrowEntity> page = sysEquipmentBorrowRepository.findAllByDeptId(deptId,pageable);
        return page;
    }

    @Override
    public Page<SysEquipmentBorrowEntity> showUnfBorrow(Long borrowerId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentBorrowEntity> page = sysEquipmentBorrowRepository.findAllByBorrowerId(borrowerId,pageable);
        return page;
    }

    @Override
    public Page<SysEquipmentBorrowEntity> showPendBorrow(Long approverId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentBorrowEntity> page = sysEquipmentBorrowRepository.findAllByApproverId(approverId,pageable);
        return page;
    }

    @Override
    public SysEquipmentBorrowEntity showBorrow(Long borrowId){
        SysEquipmentBorrowEntity borrow = sysEquipmentBorrowRepository.findSysEquipmentBorrowEntityById(borrowId);
        if (!verifyUtil.isExist(borrow)){
            throw new IllegalArgumentException("借取表不存在.");
        }
        return borrow;
    }
}

```

## File: service\dept\DeptService.java

- Extension: .java
- Language: java
- Size: 315 bytes
- Created: 2026-03-05 14:09:24
- Modified: 2026-03-12 16:25:21

### Code

```java
package com.xwd.xwd_uoms.service.dept;

import com.xwd.xwd_uoms.entity.SysDepartmentEntity;

public interface DeptService {
    void deptUpdate(SysDepartmentEntity dept);

    void deptAdd(SysDepartmentEntity dept);

    SysDepartmentEntity showDept(Long deptId);

    void deptDeleted(Long deptId);
}

```

## File: service\dept\impl\DeptServiceImpl.java

- Extension: .java
- Language: java
- Size: 4384 bytes
- Created: 2026-03-12 13:38:39
- Modified: 2026-03-15 16:51:58

### Code

```java
package com.xwd.xwd_uoms.service.dept.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysDeptDefaultConfig;
import com.xwd.xwd_uoms.entity.SysDepartmentEntity;
import com.xwd.xwd_uoms.entity.SysOrganizationEntity;
import com.xwd.xwd_uoms.repository.SysDepartmentRepository;
import com.xwd.xwd_uoms.repository.SysOrganizationRepository;
import com.xwd.xwd_uoms.service.dept.DeptService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {
    @Resource
    private SysDepartmentRepository sysDepartmentRepository;

    @Resource
    private SysOrganizationRepository sysOrganizationRepository;

    @Resource
    private SysDeptDefaultConfig sysDeptDefaultConfig;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void deptUpdate(SysDepartmentEntity dept) {
        Long deptId = dept.getId();
        SysDepartmentEntity oldDept = sysDepartmentRepository.findSysDepartmentEntityById(deptId);
        if (!verifyUtil.isExist(oldDept) || !verifyUtil.isExist(dept)){
            throw new IllegalArgumentException("部门不存在.");
        }
        SysOrganizationEntity org = sysOrganizationRepository.findSysOrganizationEntityById(dept.getOrgId());
        if (!verifyUtil.isExist(org)){
            throw new IllegalArgumentException("部门所属组织信息不存在.");
        }
        if (!Objects.equals(dept.getName(),oldDept.getName()) &&
                verifyUtil.isExist(sysDepartmentRepository.findSysDepartmentEntityByOrgIdAndName(dept.getOrgId(),dept.getName()))){
            throw new IllegalArgumentException("该部门已存在.");
        }

        oldDept.setName(dept.getName());
        oldDept.setDeptDesc(dept.getDeptDesc());

        LocalDate now = LocalDate.now();
        if (!verifyUtil.isExist(oldDept.getUpdateDate())){
            oldDept.setCreateDate(now);
        }
        oldDept.setUpdateDate(now);

        sysDepartmentRepository.save(oldDept);
    }

    @Override
    public void deptAdd(SysDepartmentEntity dept) {
        SysOrganizationEntity org = sysOrganizationRepository.findSysOrganizationEntityById(dept.getOrgId());
        if (!verifyUtil.isExist(org)){
            throw new IllegalArgumentException("部门所属组织信息不存在.");
        }
        if (verifyUtil.isExist(sysDepartmentRepository.findSysDepartmentEntityByOrgIdAndName(dept.getOrgId(),dept.getName()))){
            throw new IllegalArgumentException("该部门已存在.");
        }
        if (!verifyUtil.isExist(dept.getName())){
            throw new IllegalArgumentException("部门名称不可为空.");
        }
        if (!verifyUtil.isExist(dept.getDeptDesc())){
            dept.setDeptDesc(sysDeptDefaultConfig.getDeptDesc());
        }

        dept.setStatus(sysDeptDefaultConfig.getStatus());
        dept.setIsDeleted(sysDeptDefaultConfig.getIsDeleted());

        LocalDate now = LocalDate.now();
        dept.setCreateDate(now);
        dept.setUpdateDate(now);

        sysDepartmentRepository.save(dept);
    }

    @Override
    public SysDepartmentEntity showDept(Long deptId) {
        SysDepartmentEntity dept = sysDepartmentRepository.findSysDepartmentEntityById(deptId);
        if (!verifyUtil.isExist(dept)){
            throw new IllegalArgumentException("部门不存在.");
        }
        SysOrganizationEntity org = sysOrganizationRepository.findSysOrganizationEntityById(dept.getOrgId());
        if (!verifyUtil.isExist(org)){
            throw new IllegalArgumentException("部门所属组织信息不存在.");
        }
        return dept;
    }

    @Override
    public void deptDeleted(Long deptId){
        SysDepartmentEntity dept = sysDepartmentRepository.findSysDepartmentEntityById(deptId);
        if (!verifyUtil.isExist(dept)){
            throw new IllegalArgumentException("部门信息不存在.");
        }
        dept.setIsDeleted((byte)1);

        LocalDate now = LocalDate.now();
        dept.setUpdateDate(now);

        sysDepartmentRepository.save(dept);
    }
}

```

## File: service\equip\EquipService.java

- Extension: .java
- Language: java
- Size: 600 bytes
- Created: 2026-03-05 14:14:06
- Modified: 2026-03-18 06:29:58

### Code

```java
package com.xwd.xwd_uoms.service.equip;

import com.xwd.xwd_uoms.entity.SysEquipmentEntity;
import org.springframework.data.domain.Page;

public interface EquipService {
    void equipUpdate(SysEquipmentEntity equip);

    void equipAdd(SysEquipmentEntity equip);

    SysEquipmentEntity showEquip(Long equipId);

    void equipDeleted(Long id);

    void equipBorrow(Long equipId, Integer borrowNum);

    Page<SysEquipmentEntity> showOrgEquip(Long orgId, Integer current, Integer size);

    Page<SysEquipmentEntity> showDeptEquip(Long deptId, Integer current, Integer size);
}

```

## File: service\equip\impl\EquipServiceImpl.java

- Extension: .java
- Language: java
- Size: 6588 bytes
- Created: 2026-03-13 12:10:01
- Modified: 2026-03-18 06:29:58

### Code

```java
package com.xwd.xwd_uoms.service.equip.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysEquipDefaultConfig;
import com.xwd.xwd_uoms.entity.SysDepartmentEntity;
import com.xwd.xwd_uoms.entity.SysEquipmentEntity;
import com.xwd.xwd_uoms.entity.SysOrganizationEntity;
import com.xwd.xwd_uoms.repository.SysDepartmentRepository;
import com.xwd.xwd_uoms.repository.SysEquipmentRepository;
import com.xwd.xwd_uoms.repository.SysOrganizationRepository;
import com.xwd.xwd_uoms.service.equip.EquipService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class EquipServiceImpl implements EquipService {
    @Resource
    private SysEquipmentRepository sysEquipmentRepository;

    @Resource
    private SysOrganizationRepository sysOrganizationRepository;

    @Resource
    private SysDepartmentRepository sysDepartmentRepository;

    @Resource
    private SysEquipDefaultConfig sysEquipDefaultConfig;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void equipUpdate(SysEquipmentEntity equip) {
        Long equipId = equip.getId();
        SysEquipmentEntity oldEquip = sysEquipmentRepository.findSysEquipmentEntityById(equipId);
        if (!verifyUtil.isExist(oldEquip)){
            throw new IllegalArgumentException("设备不存在.");
        }
        if (!verifyUtil.isExist(equip.getName())){
            throw new IllegalArgumentException("设备名称不可为空.");
        }
        SysOrganizationEntity org = sysOrganizationRepository.findSysOrganizationEntityById(equip.getOrgId());
        if (!verifyUtil.isExist(org)){
            throw new IllegalArgumentException("设备所属组织不存在.");
        }
        if (verifyUtil.isExist(equip.getDeptId())) {
            SysDepartmentEntity dept = sysDepartmentRepository.findSysDepartmentEntityById(equip.getDeptId());
            if (!verifyUtil.isExist(dept)) {
                throw new IllegalArgumentException("设备所属部门不存在.");
            }
        }
        if (!verifyUtil.isExist(equip.getTotalNum()) || !verifyUtil.isExist(equip.getAvailableNum())){
            throw new IllegalArgumentException("设备储量非法.");
        }
        if (!verifyUtil.isExist(equip.getEquipmentDesc())){
            oldEquip.setEquipmentDesc(sysEquipDefaultConfig.getEquipmentDesc());
        } else {
            oldEquip.setEquipmentDesc(equip.getEquipmentDesc());
        }
        oldEquip.setName(equip.getName());
        oldEquip.setTotalNum(equip.getTotalNum());
        oldEquip.setAvailableNum(equip.getAvailableNum());
        oldEquip.setOrgId(equip.getOrgId());
        oldEquip.setDeptId(equip.getDeptId());

        LocalDate now = LocalDate.now();
        if (!verifyUtil.isExist(oldEquip.getCreateDate())){
            oldEquip.setCreateDate(now);
        }
        oldEquip.setUpdateDate(now);

        sysEquipmentRepository.save(oldEquip);
    }

    @Override
    public void equipAdd(SysEquipmentEntity equip) {
        if (!verifyUtil.isExist(equip)){
            throw new IllegalArgumentException("设备信息不可为空.");
        }
        if (!verifyUtil.isExist(equip.getName())){
            throw new IllegalArgumentException("设备名称不可为空.");
        }
        if (!verifyUtil.isExist(equip.getOrgId())){
            throw new IllegalArgumentException("设备所属组织不可为空.");
        }
        if (!verifyUtil.isExist(equip.getTotalNum()) || !verifyUtil.isExist(equip.getAvailableNum())){
            throw new IllegalArgumentException("设备储量非法.");
        }

        if (!verifyUtil.isExist(equip.getEquipmentDesc())){
            equip.setEquipmentDesc(sysEquipDefaultConfig.getEquipmentDesc());
        }
        equip.setStatus(sysEquipDefaultConfig.getStatus());
        equip.setIsDeleted(sysEquipDefaultConfig.getIsDeleted());

        LocalDate now = LocalDate.now();
        equip.setCreateDate(now);
        equip.setUpdateDate(now);

        sysEquipmentRepository.save(equip);
    }

    @Override
    public SysEquipmentEntity showEquip(Long equipId) {
        SysEquipmentEntity equip = sysEquipmentRepository.findSysEquipmentEntityById(equipId);
        if (!verifyUtil.isExist(equip)){
            throw new IllegalArgumentException("设备不存在.");
        }

        return equip;
    }

    @Override
    public void equipDeleted(Long equipId) {
        SysEquipmentEntity equip = sysEquipmentRepository.findSysEquipmentEntityById(equipId);
        if (!verifyUtil.isExist(equip)){
            throw new IllegalArgumentException("设备不存在.");
        }

        equip.setIsDeleted((byte)1);

        LocalDate now =LocalDate.now();
        equip.setUpdateDate(now);

        sysEquipmentRepository.save(equip);
    }

    @Override
    public void equipBorrow(Long equipId, Integer borrowNum){
        SysEquipmentEntity equip = sysEquipmentRepository.findSysEquipmentEntityById(equipId);
        if (!verifyUtil.isExist(equip)){
            throw new IllegalArgumentException("设备不存在.");
        }
        Integer newNum = equip.getAvailableNum() - borrowNum;
        if (!verifyUtil.isExist(newNum)){
            throw new IllegalArgumentException("借取数量非法.");
        }
        equip.setAvailableNum(newNum);
        LocalDate now = LocalDate.now();
        if (!verifyUtil.isExist(equip.getCreateDate())){
            equip.setCreateDate(now);
        }
        equip.setUpdateDate(now);

        sysEquipmentRepository.save(equip);
    }

    @Override
    public Page<SysEquipmentEntity> showOrgEquip(Long orgId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentEntity> page = sysEquipmentRepository.findAllByOrgId(orgId,pageable);
        return page;
    }

    @Override
    public Page<SysEquipmentEntity> showDeptEquip(Long deptId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentEntity> page = sysEquipmentRepository.findAllByDeptId(deptId,pageable);
        return page;
    }
}

```

## File: service\feedback\FeedbackService.java

- Extension: .java
- Language: java
- Size: 650 bytes
- Created: 2026-03-05 14:08:25
- Modified: 2026-03-23 13:39:42

### Code

```java
package com.xwd.xwd_uoms.service.feedback;

import com.xwd.xwd_uoms.entity.SysFeedbackEntity;
import org.springframework.data.domain.Page;

public interface FeedbackService {
    void feedbackUpdate(SysFeedbackEntity feedback);

    void feedbackAdd(SysFeedbackEntity feedback);

    void approveFeedback(SysFeedbackEntity feedback);

    void feedbackDeleted(Long feedbackId);

    Page<SysFeedbackEntity> showRecFeedback(Long handlerUserId, Integer current, Integer size);

    Page<SysFeedbackEntity> showPendFeedback(Long feedbackUserId, Integer current, Integer size);

    SysFeedbackEntity showFeedback(Long feedbackId);
}

```

## File: service\feedback\impl\FeedbackServiceImpl.java

- Extension: .java
- Language: java
- Size: 7670 bytes
- Created: 2026-03-16 21:05:40
- Modified: 2026-03-23 13:39:42

### Code

```java
package com.xwd.xwd_uoms.service.feedback.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysFeedbackDefaultConfig;
import com.xwd.xwd_uoms.entity.SysFeedbackEntity;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.repository.SysFeedbackRepository;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import com.xwd.xwd_uoms.service.feedback.FeedbackService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private SysFeedbackRepository sysFeedbackRepository;

    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysFeedbackDefaultConfig sysFeedbackDefaultConfig;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void feedbackAdd(SysFeedbackEntity feedback){
        LocalDate now = LocalDate.now();
        if (!verifyUtil.isExist(feedback)){
            throw new IllegalArgumentException("反馈表不可为空.");
        }
        SysUserEntity feedbackUser = sysUserRepository.findSysUserEntityById(feedback.getFeedbackUserId());
        if (!verifyUtil.isExist(feedback.getFeedbackUserId()) ||
                !verifyUtil.isExist(feedbackUser)){
            throw new IllegalArgumentException("反馈人信息不存在.");
        }
        if (!verifyUtil.isExist(feedback.getTargetObject())){
            throw new IllegalArgumentException("反馈目标不可为空.");
        }
        SysUserEntity handlerUser = sysUserRepository.findSysUserEntityById(feedback.getHandlerUserId());
        if (!verifyUtil.isExist(feedback.getHandlerUserId()) ||
                !verifyUtil.isExist(handlerUser)){
            throw new IllegalArgumentException("反馈对象信息不存在.");
        }

        feedback.setFeedbackTime(now);
        feedback.setFeedbackStatus(sysFeedbackDefaultConfig.getFeedbackStatus());
        feedback.setIsDeleted(sysFeedbackDefaultConfig.getIsDeleted());
        feedback.setCreateDate(now);
        feedback.setUpdateDate(now);

        sysFeedbackRepository.save(feedback);
    }

    @Override
    public void feedbackUpdate(SysFeedbackEntity feedback){
        LocalDate now = LocalDate.now();
        SysFeedbackEntity oldFeedback = sysFeedbackRepository.findSysFeedbackEntityById(feedback.getId());
        if (!verifyUtil.isExist(oldFeedback)){
            throw new IllegalArgumentException("反馈信息不存在.");
        }
        SysUserEntity feedbackUser = sysUserRepository.findSysUserEntityById(feedback.getFeedbackUserId());
        if (!verifyUtil.isExist(feedback.getFeedbackUserId()) ||
                !verifyUtil.isExist(feedbackUser)){
            throw new IllegalArgumentException("反馈人信息不存在.");
        }
        if (!verifyUtil.isExist(feedback.getTargetObject())){
            throw new IllegalArgumentException("反馈目标不可为空.");
        }
        SysUserEntity handlerUser = sysUserRepository.findSysUserEntityById(feedback.getHandlerUserId());
        if (!verifyUtil.isExist(feedback.getHandlerUserId()) ||
                !verifyUtil.isExist(handlerUser)){
            throw new IllegalArgumentException("反馈对象信息不存在.");
        }
        oldFeedback.setTargetObject(feedback.getTargetObject());
        if (verifyUtil.isExist(feedback.getFeedbackContent()) &&
                !Objects.equals(feedback.getFeedbackContent(),oldFeedback.getFeedbackContent())) {
            oldFeedback.setFeedbackContent(feedback.getFeedbackContent());
            oldFeedback.setFeedbackTime(now);
        }
        if (verifyUtil.isExist(feedback.getFeedbackStatus()) &&
                !Objects.equals(oldFeedback.getFeedbackStatus(),feedback.getFeedbackStatus())){
            oldFeedback.setFeedbackStatus(feedback.getFeedbackStatus());
            oldFeedback.setHandleTime(now);
        }
        if (verifyUtil.isExist(feedback.getRemark())){
            oldFeedback.setRemark(feedback.getRemark());
        }
        if (!verifyUtil.isExist(oldFeedback.getCreateDate())){
            oldFeedback.setCreateDate(now);
        }
        oldFeedback.setUpdateDate(now);
        sysFeedbackRepository.save(oldFeedback);
    }

    @Override
    public void approveFeedback(SysFeedbackEntity feedback){
        LocalDate now = LocalDate.now();
        SysFeedbackEntity oldFeedback = sysFeedbackRepository.findSysFeedbackEntityById(feedback.getId());
        if (!verifyUtil.isExist(oldFeedback)){
            throw new IllegalArgumentException("反馈信息不存在.");
        }
        SysUserEntity feedbackUser = sysUserRepository.findSysUserEntityById(feedback.getFeedbackUserId());
        if (!verifyUtil.isExist(feedback.getFeedbackUserId()) ||
                !verifyUtil.isExist(feedbackUser)){
            throw new IllegalArgumentException("反馈人信息不存在.");
        }
        if (!verifyUtil.isExist(feedback.getTargetObject())){
            throw new IllegalArgumentException("反馈目标不可为空.");
        }
        SysUserEntity handlerUser = sysUserRepository.findSysUserEntityById(feedback.getHandlerUserId());
        if (!verifyUtil.isExist(feedback.getHandlerUserId()) ||
                !verifyUtil.isExist(handlerUser)){
            throw new IllegalArgumentException("反馈对象信息不存在.");
        }
        oldFeedback.setFeedbackStatus(feedback.getFeedbackStatus());
        oldFeedback.setRemark(feedback.getRemark());
        oldFeedback.setHandleTime(now);
        if (!verifyUtil.isExist(oldFeedback.getCreateDate())){
            oldFeedback.setCreateDate(now);
        }
        oldFeedback.setUpdateDate(now);
        sysFeedbackRepository.save(oldFeedback);
    }

    @Override
    public void feedbackDeleted(Long feedbackId){
        SysFeedbackEntity feedback  = sysFeedbackRepository.findSysFeedbackEntityById(feedbackId);
        if (!verifyUtil.isExist(feedback)){
            throw new IllegalArgumentException("反馈表不存在.");
        }
        feedback.setIsDeleted((byte)1);

        LocalDate now = LocalDate.now();
        feedback.setUpdateDate(now);

        sysFeedbackRepository.save(feedback);
    }

    @Override
    public Page<SysFeedbackEntity> showRecFeedback(Long handlerUserId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysFeedbackEntity> page = sysFeedbackRepository.findAllByHandlerUserId(handlerUserId,pageable);
        return page;
    }

    @Override
    public Page<SysFeedbackEntity> showPendFeedback(Long feedbackUserId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysFeedbackEntity> page = sysFeedbackRepository.findAllByFeedbackUserId(feedbackUserId,pageable);
        return page;
    }

    @Override
    public SysFeedbackEntity showFeedback(Long feedbackId){
        SysFeedbackEntity feedback = sysFeedbackRepository.findSysFeedbackEntityById(feedbackId);
        if (!verifyUtil.isExist(feedback)){
            throw new IllegalArgumentException("反馈表不存在.");
        }
        return feedback;
    }
}

```

## File: service\home\HomeService.java

- Extension: .java
- Language: java
- Size: 681 bytes
- Created: 2026-03-01 19:38:10
- Modified: 2026-03-23 19:14:52

### Code

```java
package com.xwd.xwd_uoms.service.home;

import com.xwd.xwd_uoms.entity.*;
import org.springframework.data.domain.Page;

public interface HomeService {

    Page<SysApplyEntity> showUnfApply(Long userId, Integer current, Integer size);

    Page<SysTaskEntity> showUnfTask(Long userId, Integer current, Integer size);

    Page<SysEquipmentBorrowEntity> showUnfEquipBorrow(Long userId, Integer current, Integer size);

    Page<SysFeedbackEntity> showUnfFeedBack(Long userId, Integer current, Integer size);

    Page<SysNoticeEntity> showRecNotice(Long userId, Integer current, Integer size);

    Page<SysUserEntity> showAdmin(Integer current, Integer size);
}

```

## File: service\home\impl\HomeServiceImpl.java

- Extension: .java
- Language: java
- Size: 2847 bytes
- Created: 2026-03-01 19:38:34
- Modified: 2026-03-15 16:51:58

### Code

```java
package com.xwd.xwd_uoms.service.home.impl;

import com.xwd.xwd_uoms.entity.*;
import com.xwd.xwd_uoms.repository.*;
import com.xwd.xwd_uoms.service.home.HomeService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HomeServiceImpl implements HomeService {
    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysApplyRepository sysApplyRepository;

    @Resource
    private SysNoticeRepository sysNoticeRepository;

    @Resource
    private SysTaskRepository sysTaskRepository;

    @Resource
    private SysEquipmentBorrowRepository sysEquipmentBorrowRepository;

    @Resource
    private SysFeedbackRepository sysFeedbackRepository;

    @Override
    public Page<SysApplyEntity> showUnfApply(Long userId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysApplyEntity> page = sysApplyRepository.findAllByApproverUserIdAndApplyStatus(userId, (byte) 0, pageable);
        return page;
    }

    @Override
    public Page<SysTaskEntity> showUnfTask(Long userId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysTaskEntity> page = sysTaskRepository.findAllByMandatoryIdAndStatus(userId,(byte)0,pageable);
        return page;
    }

    @Override
    public Page<SysEquipmentBorrowEntity> showUnfEquipBorrow(Long userId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentBorrowEntity> page = sysEquipmentBorrowRepository.findAllByBorrowerIdAndStatus(userId,(byte)0,pageable);
        return page;
    }

    @Override
    public Page<SysFeedbackEntity> showUnfFeedBack(Long userId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysFeedbackEntity> page = sysFeedbackRepository.findAllByHandlerUserIdAndFeedbackStatus(userId,(byte)0,pageable);
        return page;
    }

    @Override
    public Page<SysNoticeEntity> showRecNotice(Long userId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysNoticeEntity> page = sysNoticeRepository.findAllByMandatoryId(userId,pageable);
        return page;
    }

    @Override
    public Page<SysUserEntity> showAdmin(Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysUserEntity> page = sysUserRepository.findAllByRoleIdNot(2L,pageable);
        return page;
    }
}

```

## File: service\notice\NoticeService.java

- Extension: .java
- Language: java
- Size: 552 bytes
- Created: 2026-03-05 14:08:11
- Modified: 2026-03-18 06:29:58

### Code

```java
package com.xwd.xwd_uoms.service.notice;

import com.xwd.xwd_uoms.entity.SysNoticeEntity;
import org.springframework.data.domain.Page;

public interface NoticeService {
    void noticeAdd(SysNoticeEntity notice);

    void noticeUpdate(SysNoticeEntity notice);

    Page<SysNoticeEntity> showRecNotice(Long mandatoryId, Integer current, Integer size);

    Page<SysNoticeEntity> showIniNotice(Long originatorId, Integer current, Integer size);

    void noticeDeleted(Long noticeId);

    SysNoticeEntity showNotice(Long noticeId);
}

```

## File: service\notice\impl\NoticeServiceImpl.java

- Extension: .java
- Language: java
- Size: 4942 bytes
- Created: 2026-03-12 16:28:07
- Modified: 2026-03-18 06:29:58

### Code

```java
package com.xwd.xwd_uoms.service.notice.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysNoticeDefaultConfig;
import com.xwd.xwd_uoms.entity.SysNoticeEntity;
import com.xwd.xwd_uoms.repository.SysNoticeRepository;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import com.xwd.xwd_uoms.service.notice.NoticeService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private SysNoticeRepository sysNoticeRepository;

    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysNoticeDefaultConfig sysNoticeDefaultConfig;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void noticeAdd(SysNoticeEntity notice) {
        if (!verifyUtil.isExist(notice.getName())){
            throw new IllegalArgumentException("通知标题不可为空.");
        }
        if (!verifyUtil.isExist(notice.getOriginatorId()) ||
                !verifyUtil.isExist(sysUserRepository.findSysUserEntityById(notice.getOriginatorId()))){
            throw new IllegalArgumentException("通知发起人不存在.");
        }
        if (!verifyUtil.isExist(notice.getMandatoryId()) ||
                !verifyUtil.isExist(sysUserRepository.findSysUserEntityById(notice.getMandatoryId()))){
            throw new IllegalArgumentException("通知对象不可为空.");
        }
        notice.setIsDeleted(sysNoticeDefaultConfig.getIsDeleted());

        LocalDate now = LocalDate.now();
        notice.setCreateDate(now);
        notice.setUpdateDate(now);

        sysNoticeRepository.save(notice);
    }

    @Override
    public void noticeUpdate(SysNoticeEntity notice) {
        Long noticeId = notice.getId();
        SysNoticeEntity oldNotice = sysNoticeRepository.findSysNoticeEntityById(noticeId);
        if (!verifyUtil.isExist(oldNotice)){
            throw new IllegalArgumentException("通知不存在.");
        }
        if (!verifyUtil.isExist(notice.getName())){
            throw new IllegalArgumentException("通知标题不可为空.");
        }
        oldNotice.setName(notice.getName());
        oldNotice.setContent(notice.getContent());
        if (!Objects.equals(notice.getOriginatorId(),oldNotice.getOriginatorId()) &&
                !verifyUtil.isExist(sysUserRepository.findSysUserEntityById(notice.getOriginatorId()))){
            throw new IllegalArgumentException("通知发起人不存在.");
        }
        if (!Objects.equals(notice.getMandatoryId(),oldNotice.getMandatoryId()) &&
                !verifyUtil.isExist(sysUserRepository.findSysUserEntityById(notice.getMandatoryId()))){
            throw new IllegalArgumentException("通知接收人不存在.");
        }
        oldNotice.setOriginatorId(notice.getOriginatorId());
        oldNotice.setMandatoryId(notice.getMandatoryId());

        LocalDate now = LocalDate.now();
        if (!verifyUtil.isExist(oldNotice.getCreateDate())){
            oldNotice.setCreateDate(now);
        }
        oldNotice.setUpdateDate(now);
        sysNoticeRepository.save(oldNotice);
    }

    @Override
    public Page<SysNoticeEntity> showRecNotice(Long mandatoryId, Integer current, Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysNoticeEntity> page = sysNoticeRepository.findAllByMandatoryId(mandatoryId,pageable);
        return page;
    }

    @Override
    public Page<SysNoticeEntity> showIniNotice(Long originatorId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysNoticeEntity> page = sysNoticeRepository.findAllByOriginatorId(originatorId,pageable);
        return page;
    }

    @Override
    public void noticeDeleted(Long noticeId){
        SysNoticeEntity notice = sysNoticeRepository.findSysNoticeEntityById(noticeId);
        if (!verifyUtil.isExist(notice)){
            throw new IllegalArgumentException("通知不存在.");
        }
        notice.setIsDeleted((byte)1);

        LocalDate now = LocalDate.now();
        notice.setUpdateDate(now);
        sysNoticeRepository.save(notice);
    }

    @Override
    public SysNoticeEntity showNotice(Long noticeId){
        SysNoticeEntity notice = sysNoticeRepository.findSysNoticeEntityById(noticeId);
        if (!verifyUtil.isExist(notice)){
            throw new IllegalArgumentException("通知不存在.");
        }
        return notice;
    }
}

```

## File: service\org\OrgService.java

- Extension: .java
- Language: java
- Size: 313 bytes
- Created: 2026-03-03 11:08:45
- Modified: 2026-03-11 21:54:25

### Code

```java
package com.xwd.xwd_uoms.service.org;

import com.xwd.xwd_uoms.entity.SysOrganizationEntity;

public interface OrgService {
    SysOrganizationEntity showOrg(Long orgId);

    void orgUpdate(SysOrganizationEntity org);

    void orgAdd(SysOrganizationEntity org);

    void orgDeleted(Long orgId);
}

```

## File: service\org\impl\OrgServiceImpl.java

- Extension: .java
- Language: java
- Size: 4116 bytes
- Created: 2026-03-05 14:11:51
- Modified: 2026-03-15 16:51:58

### Code

```java
package com.xwd.xwd_uoms.service.org.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysOrgDefaultConfig;
import com.xwd.xwd_uoms.entity.SysOrganizationEntity;
import com.xwd.xwd_uoms.repository.SysOrganizationRepository;
import com.xwd.xwd_uoms.service.org.OrgService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class OrgServiceImpl implements OrgService {
    @Resource
    private SysOrganizationRepository sysOrganizationRepository;

    @Resource
    private SysOrgDefaultConfig sysOrgDefaultConfig;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public SysOrganizationEntity showOrg(Long orgId) {
        SysOrganizationEntity org = sysOrganizationRepository.findSysOrganizationEntityById(orgId);
        if (!verifyUtil.isExist(org)){
            throw new IllegalArgumentException("组织不存在.");
        }
        return org;
    }

    @Override
    public void orgUpdate(SysOrganizationEntity org) {
        Long orgId = org.getId();
        if (!verifyUtil.isExist(orgId) || !verifyUtil.isExist(org)){
            throw new IllegalArgumentException("组织不存在.");
        }
        SysOrganizationEntity oldOrg = sysOrganizationRepository.findSysOrganizationEntityById(orgId);
        if (verifyUtil.isExist(sysOrganizationRepository.findSysOrganizationEntityByNameAndType(org.getName(),org.getType())) &&
                (!oldOrg.getName().equals(org.getName()) || !oldOrg.getType().equals(org.getType()))){
            throw new IllegalArgumentException("组织已存在.");
        }

        oldOrg.setType(org.getType());
        oldOrg.setName(org.getName());
        oldOrg.setOrgDesc(org.getOrgDesc());
        oldOrg.setPhone(org.getPhone());
        oldOrg.setAddress(org.getAddress());

        LocalDate now = LocalDate.now();
        if (!verifyUtil.isExist(oldOrg.getCreateDate())){
            oldOrg.setCreateDate(now);
        }
        oldOrg.setUpdateDate(now);

        sysOrganizationRepository.save(oldOrg);
    }

    @Override
    public void orgAdd(SysOrganizationEntity org) {
        SysOrganizationEntity newOrg = new SysOrganizationEntity();
        if (!verifyUtil.isExist(org)){
            throw new IllegalArgumentException("组织参数不存在.");
        }
        if (!verifyUtil.isExist(org.getName())){
            throw new IllegalArgumentException("组织名称不可为空.");
        }
        if (verifyUtil.isExist(sysOrganizationRepository.findSysOrganizationEntityByNameAndType(org.getName(), org.getType()))){
            throw new IllegalArgumentException("组织已存在.");
        }
        newOrg.setName(org.getName());
        if (!verifyUtil.isExist(org.getType())){
            newOrg.setType(sysOrgDefaultConfig.getType());
        }else {
            newOrg.setType(org.getType());
        }if (!verifyUtil.isExist(org.getOrgDesc())){
            newOrg.setOrgDesc(sysOrgDefaultConfig.getOrgDesc());
        }else {
            newOrg.setOrgDesc(org.getOrgDesc());
        }
        newOrg.setAddress(org.getAddress());
        newOrg.setPhone(org.getPhone());
        newOrg.setStatus(sysOrgDefaultConfig.getStatus());
        newOrg.setIsDeleted(sysOrgDefaultConfig.getIsDeleted());

        LocalDate now = LocalDate.now();
        newOrg.setCreateDate(now);
        newOrg.setUpdateDate(now);

        sysOrganizationRepository.save(newOrg);
    }

    @Override
    public void orgDeleted(Long orgId){
        SysOrganizationEntity org = sysOrganizationRepository.findSysOrganizationEntityById(orgId);
        if (!verifyUtil.isExist(org)){
            throw new IllegalArgumentException("组织不存在.");
        }
        org.setIsDeleted((byte)1);
        LocalDate now = LocalDate.now();
        org.setUpdateDate(now);
        sysOrganizationRepository.save(org);
    }
}

```

## File: service\search\SearchService.java

- Extension: .java
- Language: java
- Size: 1332 bytes
- Created: 2026-02-18 21:25:12
- Modified: 2026-03-29 13:40:32

### Code

```java
package com.xwd.xwd_uoms.service.search;

import com.xwd.xwd_uoms.entity.SysDepartmentEntity;
import com.xwd.xwd_uoms.entity.SysEquipmentEntity;
import com.xwd.xwd_uoms.entity.SysOrganizationEntity;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import org.springframework.data.domain.Page;

public interface SearchService {
    Page<SysUserDTO> searchUser(String userName,Integer current,Integer size);
    Page<SysOrganizationEntity> searchOrg(String orgName,Integer current,Integer size);
    Page<SysDepartmentEntity> searchOrgDept(Long orgId,Integer current,Integer size);
    Page<SysEquipmentEntity> searchOrgEquip(Long orgId,Integer current,Integer size);
    Page<SysDepartmentEntity> searchDept(String deptName, Integer current, Integer size);
    Page<SysUserDTO> searchDeptUser(Long deptId,Integer current,Integer size);
    Page<SysEquipmentEntity> searchDeptEquip(Long deptId,Integer current,Integer size);
    Page<SysEquipmentEntity> searchEquip(String equipName,Integer current,Integer size);

    Page<SysUserDTO> searchAllUser(Integer current, Integer size);
    Page<SysOrganizationEntity> searchAllOrg(Integer current, Integer size);
    Page<SysDepartmentEntity> searchAllDept(Integer current, Integer size);
    Page<SysEquipmentEntity> searchAllEquip(Integer current, Integer size);
}

```

## File: service\search\impl\SearchServiceImpl.java

- Extension: .java
- Language: java
- Size: 5882 bytes
- Created: 2026-02-18 21:25:43
- Modified: 2026-03-29 13:11:51

### Code

```java
package com.xwd.xwd_uoms.service.search.impl;

import com.xwd.xwd_uoms.common.util.ConvertUtil;
import com.xwd.xwd_uoms.entity.SysDepartmentEntity;
import com.xwd.xwd_uoms.entity.SysEquipmentEntity;
import com.xwd.xwd_uoms.entity.SysOrganizationEntity;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import com.xwd.xwd_uoms.repository.SysDepartmentRepository;
import com.xwd.xwd_uoms.repository.SysEquipmentRepository;
import com.xwd.xwd_uoms.repository.SysOrganizationRepository;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import com.xwd.xwd_uoms.service.search.SearchService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {
    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysOrganizationRepository sysOrganizationRepository;

    @Resource
    private SysDepartmentRepository sysDepartmentRepository;

    @Resource
    private SysEquipmentRepository sysEquipmentRepository;

    @Resource
    private ConvertUtil convertUtil;

    @Override
    public Page<SysUserDTO> searchUser(String userName,Integer current,Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysUserEntity> page = sysUserRepository.findAllByNameLike(userName,pageable);
        List<SysUserDTO> dtoList = page.getContent().stream()
                .map(entity -> {
                    SysUserDTO dto = convertUtil.userToDTO(entity);
                    return dto;
                })
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, page.getTotalElements());
    }

    @Override
    public Page<SysOrganizationEntity> searchOrg(String orgName,Integer current,Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysOrganizationEntity> page = sysOrganizationRepository.findAllByNameLike(orgName,pageable);
        return page;
    }

    @Override
    public Page<SysDepartmentEntity> searchOrgDept(Long orgId, Integer current, Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysDepartmentEntity> page = sysDepartmentRepository.findAllByOrgId(orgId,pageable);
        return page;
    }

    @Override
    public Page<SysEquipmentEntity> searchOrgEquip(Long orgId, Integer current, Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentEntity> page = sysEquipmentRepository.findAllByOrgId(orgId,pageable);
        return page;
    }
    @Override
    public Page<SysDepartmentEntity> searchDept(String deptName,Integer current,Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysDepartmentEntity> page = sysDepartmentRepository.findAllByNameLike(deptName,pageable);
        return page;
    }

    @Override
    public Page<SysUserDTO> searchDeptUser(Long deptId, Integer current, Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysUserEntity> page = sysUserRepository.findAllByDeptId(deptId,pageable);
        List<SysUserDTO> dtoList = page.getContent().stream()
                .map(entity -> {
                    SysUserDTO dto = convertUtil.userToDTO(entity);
                    return dto;
                })
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, page.getTotalElements());
    }

    @Override
    public Page<SysEquipmentEntity> searchDeptEquip(Long deptId, Integer current, Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentEntity> page = sysEquipmentRepository.findAllByDeptId(deptId,pageable);
        return page;
    }

    @Override
    public Page<SysEquipmentEntity> searchEquip(String equipName, Integer current, Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentEntity> page = sysEquipmentRepository.findAllByNameLike(equipName,pageable);
        return page;
    }

    @Override
    public Page<SysUserDTO> searchAllUser(Integer current, Integer size) {
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysUserEntity> page = sysUserRepository.findAll(pageable);
        List<SysUserDTO> dtoList = page.getContent().stream()
                .map(entity -> {
                    SysUserDTO dto = convertUtil.userToDTO(entity);
                    return dto;
                })
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, page.getTotalElements());
    }

    @Override
    public Page<SysOrganizationEntity> searchAllOrg(Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysOrganizationEntity> page = sysOrganizationRepository.findAll(pageable);
        return page;
    }

    @Override
    public Page<SysDepartmentEntity> searchAllDept(Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysDepartmentEntity> page = sysDepartmentRepository.findAll(pageable);
        return page;
    }

    @Override
    public Page<SysEquipmentEntity> searchAllEquip(Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysEquipmentEntity> page = sysEquipmentRepository.findAll(pageable);
        return page;
    }
}

```

## File: service\task\TaskService.java

- Extension: .java
- Language: java
- Size: 557 bytes
- Created: 2026-03-05 14:07:51
- Modified: 2026-03-18 06:29:58

### Code

```java
package com.xwd.xwd_uoms.service.task;

import com.xwd.xwd_uoms.entity.SysTaskEntity;
import org.springframework.data.domain.Page;

public interface TaskService {

    void taskUpdate(SysTaskEntity task);

    void taskAdd(SysTaskEntity task);

    void taskDeleted(Long id);

    Page<SysTaskEntity> showRecTask(Long mandatoryId, Integer current, Integer size);

    Page<SysTaskEntity> showPendTask(Long originatorId, Integer current, Integer size);

    void finiTask(SysTaskEntity task);

    SysTaskEntity showTask(Long taskId);
}

```

## File: service\task\impl\TaskServiceImpl.java

- Extension: .java
- Language: java
- Size: 5963 bytes
- Created: 2026-03-12 17:22:40
- Modified: 2026-03-18 06:29:58

### Code

```java
package com.xwd.xwd_uoms.service.task.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysTaskDefaultConfig;
import com.xwd.xwd_uoms.entity.SysTaskEntity;
import com.xwd.xwd_uoms.repository.SysTaskRepository;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import com.xwd.xwd_uoms.service.task.TaskService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Resource
    private SysTaskRepository sysTaskRepository;

    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysTaskDefaultConfig sysTaskDefaultConfig;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void taskUpdate(SysTaskEntity task) {
        Long taskId = task.getId();
        SysTaskEntity oldTask = sysTaskRepository.findSysTaskEntityById(taskId);
        if (!verifyUtil.isExist(oldTask)){
            throw new IllegalArgumentException("任务不存在.");
        }
        if (!Objects.equals(task.getOriginatorId(),oldTask.getOriginatorId()) &&
                !verifyUtil.isExist(sysUserRepository.findSysUserEntityById(task.getOriginatorId()))){
            throw new IllegalArgumentException("任务发起人不存在.");
        }
        if (!Objects.equals(task.getMandatoryId(),oldTask.getMandatoryId()) &&
                !verifyUtil.isExist(sysUserRepository.findSysUserEntityById(task.getMandatoryId()))){
            throw new IllegalArgumentException("任务接收人不存在.");
        }
        if (!verifyUtil.isExist(task.getName())){
            throw new IllegalArgumentException("任务标题不可为空.");
        }
        oldTask.setName(task.getName());
        oldTask.setTaskDesc(task.getTaskDesc());
        oldTask.setOriginatorId(task.getOriginatorId());
        oldTask.setMandatoryId(task.getMandatoryId());
        oldTask.setDeadline(task.getDeadline());

        LocalDate now = LocalDate.now();
        if (!verifyUtil.isExist(oldTask.getCreateDate())){
            oldTask.setCreateDate(now);
        }
        oldTask.setUpdateDate(now);
    }

    @Override
    public void taskAdd(SysTaskEntity task) {
        if (!verifyUtil.isExist(task.getName())){
            throw new IllegalArgumentException("任务标题不可为空.");
        }
        if (!verifyUtil.isExist(sysUserRepository.findSysUserEntityById(task.getOriginatorId()))){
            throw new IllegalArgumentException("任务发起人不存在.");
        }
        if (!verifyUtil.isExist(sysUserRepository.findSysUserEntityById(task.getMandatoryId()))){
            throw new IllegalArgumentException("任务接收人不存在.");
        }
        if (!verifyUtil.isExist(task.getTaskDesc())){
            task.setTaskDesc(sysTaskDefaultConfig.getTaskDesc());
        }
        task.setIsDeleted(sysTaskDefaultConfig.getIsDeleted());
        task.setStatus(sysTaskDefaultConfig.getStatus());

        LocalDate now = LocalDate.now();
        task.setCreateDate(now);
        task.setUpdateDate(now);

        sysTaskRepository.save(task);
    }

    @Override
    public void taskDeleted(Long id) {
        SysTaskEntity task = sysTaskRepository.findSysTaskEntityById(id);
        if (!verifyUtil.isExist(task)){
            throw new IllegalArgumentException("任务不存在.");
        }
        task.setIsDeleted((byte)1);

        LocalDate now = LocalDate.now();
        task.setUpdateDate(now);
        sysTaskRepository.save(task);
    }

    @Override
    public Page<SysTaskEntity> showRecTask(Long mandatoryId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysTaskEntity> page = sysTaskRepository.findAllByMandatoryId(mandatoryId,pageable);
        return page;
    }

    @Override
    public Page<SysTaskEntity> showPendTask(Long originatorId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysTaskEntity> page = sysTaskRepository.findAllByOriginatorId(originatorId,pageable);
        return page;
    }

    @Override
    public void finiTask(SysTaskEntity task){
        LocalDate now = LocalDate.now();
        SysTaskEntity oldTask = sysTaskRepository.findSysTaskEntityById(task.getId());
        if (!verifyUtil.isExist(oldTask)){
            throw new IllegalArgumentException("任务不存在.");
        }
        if (oldTask.getStatus() == (byte)0 &&
                task.getStatus() == (byte)1){
            if (verifyUtil.isExist(oldTask.getDeadline()) && now.isAfter(oldTask.getDeadline())){
                oldTask.setStatus((byte)3);
            }else {
                oldTask.setStatus(task.getStatus());
            }
        }else if (oldTask.getStatus() == (byte)1 &&
                (task.getStatus() == (byte)2 || task.getStatus() == (byte)4)){
            oldTask.setStatus(task.getStatus());
        }else {
            throw new IllegalArgumentException("任务状态异常.");
        }
        if (!verifyUtil.isExist(oldTask.getCreateDate())){
            oldTask.setCreateDate(now);
        }
        oldTask.setUpdateDate(now);
        sysTaskRepository.save(oldTask);
    }

    @Override
    public SysTaskEntity showTask(Long taskId){
        SysTaskEntity task = sysTaskRepository.findSysTaskEntityById(taskId);
        if (!verifyUtil.isExist(task)){
            throw new IllegalArgumentException("任务不存在.");
        }
        return task;
    }
}

```

## File: service\taskfeedback\TaskFeedbackService.java

- Extension: .java
- Language: java
- Size: 698 bytes
- Created: 2026-03-15 16:38:03
- Modified: 2026-03-18 06:29:58

### Code

```java
package com.xwd.xwd_uoms.service.taskfeedback;

import com.xwd.xwd_uoms.entity.SysTaskFeedbackEntity;
import org.springframework.data.domain.Page;

public interface TaskFeedbackService {
    void taskFeedbackUpdate(SysTaskFeedbackEntity taskFeedback);

    void taskFeedbackAdd(SysTaskFeedbackEntity taskFeedback);

    Page<SysTaskFeedbackEntity> showRecTaskFeedback(Long reviewUserId, Integer current, Integer size);

    Page<SysTaskFeedbackEntity> showPendTaskFeedback(Long feedbackUserId, Integer current, Integer size);

    void approveTaskFeedback(Long reviewUserId, SysTaskFeedbackEntity taskFeedback);

    SysTaskFeedbackEntity showTaskFeedback(Long taskFeedbackId);
}

```

## File: service\taskfeedback\impl\TaskFeedbackServiceImpl.java

- Extension: .java
- Language: java
- Size: 7869 bytes
- Created: 2026-03-16 15:34:09
- Modified: 2026-03-18 06:29:58

### Code

```java
package com.xwd.xwd_uoms.service.taskfeedback.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysTaskFeedbackDefaultConfig;
import com.xwd.xwd_uoms.entity.SysTaskEntity;
import com.xwd.xwd_uoms.entity.SysTaskFeedbackEntity;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.repository.SysTaskFeedbackRepository;
import com.xwd.xwd_uoms.repository.SysTaskRepository;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import com.xwd.xwd_uoms.service.task.TaskService;
import com.xwd.xwd_uoms.service.taskfeedback.TaskFeedbackService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional
public class TaskFeedbackServiceImpl implements TaskFeedbackService {
    @Resource
    private SysTaskFeedbackRepository sysTaskFeedbackRepository;

    @Resource
    private SysTaskRepository sysTaskRepository;

    @Resource
    private SysTaskFeedbackDefaultConfig sysTaskFeedbackDefaultConfig;

    @Resource
    private TaskService taskService;

    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void taskFeedbackUpdate(SysTaskFeedbackEntity taskFeedback){
        SysTaskFeedbackEntity oldTaskFeedback = sysTaskFeedbackRepository.findSysTaskFeedbackEntityById(taskFeedback.getId());
        if (!verifyUtil.isExist(oldTaskFeedback)){
            throw new IllegalArgumentException("任务反馈表不存在.");
        }
        SysTaskEntity task = sysTaskRepository.findSysTaskEntityById(taskFeedback.getTaskId());
        if (!verifyUtil.isExist(task)){
            throw new IllegalArgumentException("任务不存在.");
        }
        SysUserEntity feedbackUser = sysUserRepository.findSysUserEntityById(taskFeedback.getFeedbackUserId());
        if (!verifyUtil.isExist(feedbackUser)){
            throw new IllegalArgumentException("提交用户不存在.");
        }
        SysUserEntity reviewUser = sysUserRepository.findSysUserEntityById(taskFeedback.getReviewUserId());
        if (!verifyUtil.isExist(reviewUser)){
            throw new IllegalArgumentException("验收用户不存在.");
        }
        if (!Objects.equals(taskFeedback.getReviewUserId(),task.getOriginatorId())){
            throw new IllegalArgumentException("验收用户与任务发起人不匹配.");
        }
        if (!verifyUtil.isExist(oldTaskFeedback.getReviewStatus())){
            oldTaskFeedback.setReviewStatus(sysTaskFeedbackDefaultConfig.getReviewStatus());
        }

        oldTaskFeedback.setTaskId(taskFeedback.getTaskId());
        oldTaskFeedback.setFeedbackUserId(taskFeedback.getFeedbackUserId());
        oldTaskFeedback.setReviewUserId(taskFeedback.getReviewUserId());
        if (verifyUtil.isExist(taskFeedback.getFeedbackContent())){
            oldTaskFeedback.setFeedbackContent(taskFeedback.getFeedbackContent());
        }

        LocalDate now = LocalDate.now();
        oldTaskFeedback.setFeedbackTime(now);

        if (!verifyUtil.isExist(oldTaskFeedback.getCreateDate())){
            oldTaskFeedback.setCreateDate(now);
        }
        oldTaskFeedback.setUpdateDate(now);
        taskService.finiTask(task);
        sysTaskFeedbackRepository.save(oldTaskFeedback);
    }

    @Override
    public void taskFeedbackAdd(SysTaskFeedbackEntity taskFeedback){
        SysTaskEntity task = sysTaskRepository.findSysTaskEntityById(taskFeedback.getTaskId());
        if (!verifyUtil.isExist(task)){
            throw new IllegalArgumentException("任务不存在.");
        }
        SysUserEntity feedbackUser = sysUserRepository.findSysUserEntityById(taskFeedback.getFeedbackUserId());
        if (!verifyUtil.isExist(feedbackUser)){
            throw new IllegalArgumentException("提交用户不存在.");
        }
        SysUserEntity reviewUser = sysUserRepository.findSysUserEntityById(taskFeedback.getReviewUserId());
        if (!verifyUtil.isExist(reviewUser)){
            throw new IllegalArgumentException("验收用户不存在.");
        }
        if (!Objects.equals(taskFeedback.getReviewUserId(),task.getOriginatorId())){
            throw new IllegalArgumentException("验收用户与任务发起人不匹配.");
        }
        taskFeedback.setReviewStatus(sysTaskFeedbackDefaultConfig.getReviewStatus());

        LocalDate now = LocalDate.now();
        taskFeedback.setFeedbackTime(now);
        taskFeedback.setCreateDate(now);
        taskFeedback.setUpdateDate(now);
        taskService.finiTask(task);

        sysTaskFeedbackRepository.save(taskFeedback);
    }

    @Override
    public Page<SysTaskFeedbackEntity> showRecTaskFeedback(Long reviewUserId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysTaskFeedbackEntity> page = sysTaskFeedbackRepository.findAllByReviewUserId(reviewUserId,pageable);
        return page;
    }

    @Override
    public Page<SysTaskFeedbackEntity> showPendTaskFeedback(Long feedbackUserId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysTaskFeedbackEntity> page = sysTaskFeedbackRepository.findAllByFeedbackUserId(feedbackUserId,pageable);
        return page;
    }

    @Override
    public void approveTaskFeedback(Long reviewUserId, SysTaskFeedbackEntity taskFeedback){
        LocalDate now = LocalDate.now();
        SysUserEntity reviewUser = sysUserRepository.findSysUserEntityById(reviewUserId);
        if (!verifyUtil.isExist(reviewUser) ||
                !Objects.equals(reviewUserId,taskFeedback.getReviewUserId())){
            throw new IllegalArgumentException("验收用户错误.");
        }
        SysTaskFeedbackEntity oldTaskFeedback = sysTaskFeedbackRepository.findSysTaskFeedbackEntityById(taskFeedback.getId());
        if (!verifyUtil.isExist(oldTaskFeedback)){
            throw new IllegalArgumentException("任务反馈不存在.");
        }
        SysTaskEntity task = sysTaskRepository.findSysTaskEntityById(oldTaskFeedback.getTaskId());
        if (!verifyUtil.isExist(task)){
            throw new IllegalArgumentException("任务不存在.");
        }
        if (taskFeedback.getReviewStatus() == (byte)2){
            task.setStatus((byte)4);
            oldTaskFeedback.setReviewStatus(taskFeedback.getReviewStatus());
        }else if (taskFeedback.getReviewStatus() == (byte)1){
            task.setStatus((byte)2);
            oldTaskFeedback.setReviewStatus(taskFeedback.getReviewStatus());
        }else {
            throw new IllegalArgumentException("验收结果异常.");
        }
        oldTaskFeedback.setReviewContent(taskFeedback.getFeedbackContent());

        oldTaskFeedback.setReviewTime(now);
        taskService.finiTask(task);
        if (!verifyUtil.isExist(oldTaskFeedback.getCreateDate())){
            oldTaskFeedback.setCreateDate(now);
        }
        oldTaskFeedback.setUpdateDate(now);
        sysTaskFeedbackRepository.save(oldTaskFeedback);
    }

    @Override
    public SysTaskFeedbackEntity showTaskFeedback(Long taskFeedbackId){
        SysTaskFeedbackEntity taskFeedback = sysTaskFeedbackRepository.findSysTaskFeedbackEntityById(taskFeedbackId);
        if (!verifyUtil.isExist(taskFeedback)){
            throw new IllegalArgumentException("任务反馈表不存在.");
        }
        return taskFeedback;
    }
}

```

## File: service\user\PermService.java

- Extension: .java
- Language: java
- Size: 162 bytes
- Created: 2026-02-04 16:47:42
- Modified: 2026-02-04 17:17:43

### Code

```java
package com.xwd.xwd_uoms.service.user;

import com.xwd.xwd_uoms.entity.dto.AdminDTO;

public interface PermService {
    void update(AdminDTO adminDTO);
}

```

## File: service\user\UserService.java

- Extension: .java
- Language: java
- Size: 843 bytes
- Created: 2026-02-04 11:27:05
- Modified: 2026-03-29 17:58:46

### Code

```java
package com.xwd.xwd_uoms.service.user;

import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.entity.dto.AdminDTO;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import org.springframework.data.domain.Page;

public interface UserService {
    void userUpdate(Long userId, SysUserDTO sysUserDTO) throws Exception;

    void userAdd(SysUserDTO sysUserDTO) throws Exception;

    void permUpdate(AdminDTO adminDTO) throws Exception;

    void userUpdate(SysUserDTO sysUserDTO) throws Exception;

    void userMove(SysUserDTO sysUserDTO) throws Exception;

    void userDelete(Long userId) throws Exception;

    void userDelete(String refreshToken) throws Exception;

    SysUserDTO userView(Long userId) throws Exception;

    Page<SysUserEntity> showAdmin(Long orgId, Integer current, Integer size);
}

```

## File: service\user\impl\PermServiceImpl.java

- Extension: .java
- Language: java
- Size: 1958 bytes
- Created: 2026-02-04 16:48:00
- Modified: 2026-03-03 08:42:33

### Code

```java
package com.xwd.xwd_uoms.service.user.impl;

import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.entity.SysRoleEntity;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.entity.dto.AdminDTO;
import com.xwd.xwd_uoms.repository.SysRoleRepository;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import com.xwd.xwd_uoms.service.user.PermService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class PermServiceImpl implements PermService {
    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysRoleRepository sysRoleRepository;

    @Resource
    private VerifyUtil verifyUtil;

    @Override
    public void update(AdminDTO adminDTO) {
        Long userId = adminDTO.getUserId();
        if (!verifyUtil.isExist(userId)){
            throw new IllegalArgumentException("用户信息为空.");
        }
        Long roleId = adminDTO.getRoleId();
        if (!verifyUtil.isExist(roleId)){
            throw new IllegalArgumentException("权限信息为空.");
        }

        if (roleId == 1L){
            throw new IllegalArgumentException("不允许超级提权.");
        }

        SysUserEntity sysUser = sysUserRepository.findSysUserEntityById(userId);
        if (!verifyUtil.isExist(sysUser)){
            throw new IllegalArgumentException("用户不存在.");
        }

        SysRoleEntity sysRole = sysRoleRepository.findSysRoleEntityById(roleId);
        if (!verifyUtil.isExist(sysRole)){
            throw new IllegalArgumentException("权限角色不存在.");
        }

        sysUser.setRoleId(roleId);
        LocalDate now = LocalDate.now();
        sysUser.setUpdateDate(now);
        sysUserRepository.save(sysUser);
    }
}

```

## File: service\user\impl\UserServiceImpl.java

- Extension: .java
- Language: java
- Size: 12931 bytes
- Created: 2026-02-04 11:32:43
- Modified: 2026-03-29 17:58:46

### Code

```java
package com.xwd.xwd_uoms.service.user.impl;

import com.xwd.xwd_uoms.common.exception.LoginException;
import com.xwd.xwd_uoms.common.util.ConvertUtil;
import com.xwd.xwd_uoms.common.util.JwtUtil;
import com.xwd.xwd_uoms.common.util.VerifyUtil;
import com.xwd.xwd_uoms.config.defaultconfig.SysUserDefaultConfig;
import com.xwd.xwd_uoms.entity.SysUserEntity;
import com.xwd.xwd_uoms.entity.dto.AdminDTO;
import com.xwd.xwd_uoms.entity.dto.SysUserDTO;
import com.xwd.xwd_uoms.repository.SysDepartmentRepository;
import com.xwd.xwd_uoms.repository.SysOrganizationRepository;
import com.xwd.xwd_uoms.repository.SysUserRepository;
import com.xwd.xwd_uoms.service.user.PermService;
import com.xwd.xwd_uoms.service.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private SysUserRepository sysUserRepository;
    
    @Resource
    private PasswordEncoder passwordEncoder;
    
    @Resource
    private SysOrganizationRepository sysOrganizationRepository;
    
    @Resource
    private SysDepartmentRepository sysDepartmentRepository;

    @Resource
    private VerifyUtil verifyUtil;

    @Resource
    private SysUserDefaultConfig sysUserDefaultConfig;

    @Resource
    private PermService permService;

    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private ConvertUtil convertUtil;

    @Override
    public void userUpdate(Long userId, SysUserDTO sysUserDTO) throws Exception {
        try {
            Long userDTOId = sysUserDTO.getId();
            if (!Objects.equals(userDTOId, userId)){
                throw new LoginException("用户不匹配.");
            }
            SysUserEntity sysUser = sysUserRepository.findSysUserEntityById(userId);
            if (!verifyUtil.isExist(sysUser)){
                throw new IllegalArgumentException("用户不存在.");
            }
            if (verifyUtil.isExist(sysUserDTO.getName())){
                sysUser.setName(sysUserDTO.getName());
            }
            if (verifyUtil.isExist(sysUserDTO.getEmail())){
                sysUser.setEmail(sysUserDTO.getEmail());
            }
            if (verifyUtil.isExist(sysUserDTO.getPhone())){
                sysUser.setPhone(sysUserDTO.getPhone());
            }
            if (verifyUtil.isExist(sysUserDTO.getGrade())){
                sysUser.setGrade(sysUserDTO.getGrade());
            }
            if (verifyUtil.isExist(sysUserDTO.getPassword())){
                String password = passwordEncoder.encode(sysUserDTO.getPassword());
                sysUser.setPassword(password);
            }
            if (verifyUtil.isExist(sysUser.getCreateDate())){
                LocalDate now = LocalDate.now();
                sysUser.setCreateDate(now);
            }
            LocalDate now = LocalDate.now();
            sysUser.setUpdateDate(now);
            sysUserRepository.save(sysUser);
        }catch (Exception e){
            throw new Exception("用户信息更新失败:" + e.getMessage());
        }
    }

    @Override
    public void userUpdate(SysUserDTO sysUserDTO) throws Exception {
        try{
            Long userId = sysUserDTO.getId();
            SysUserEntity sysUser = sysUserRepository.findSysUserEntityById(userId);
            if (!verifyUtil.isExist(sysUser)){
                throw new IllegalArgumentException("用户不存在.");
            }
            if (verifyUtil.isExist(sysUserDTO.getName())){
                sysUser.setName(sysUserDTO.getName());
            }
            if (verifyUtil.isExist(sysUserDTO.getEmail())){
                sysUser.setEmail(sysUserDTO.getEmail());
            }
            if (verifyUtil.isExist(sysUserDTO.getPhone())){
                sysUser.setPhone(sysUserDTO.getPhone());
            }
            if (verifyUtil.isExist(sysUserDTO.getGrade())){
                sysUser.setGrade(sysUserDTO.getGrade());
            }
            if (verifyUtil.isExist(sysUserDTO.getPassword())){
                String password = passwordEncoder.encode(sysUserDTO.getPassword());
                sysUser.setPassword(password);
            }
            if (verifyUtil.isExist(sysUser.getCreateDate())){
                LocalDate now = LocalDate.now();
                sysUser.setCreateDate(now);
            }
            LocalDate now = LocalDate.now();
            sysUser.setUpdateDate(now);
            sysUserRepository.save(sysUser);
        }catch (Exception e){
            throw new Exception("用户信息更新失败:" + e.getMessage());
        }
    }

    @Override
    public void userAdd(SysUserDTO sysUserDTO) throws Exception {
        try {
            if (!verifyUtil.isExist(sysUserDTO)){
                throw new IllegalArgumentException("用户信息为空.");
            }
            if (!verifyUtil.isExist(sysUserDTO.getOrgName()) ||!verifyUtil.isExist(sysUserDTO.getOrgType())){
                throw new IllegalArgumentException("用户缺少组织信息.");
            }
            if (!verifyUtil.isExist(sysUserDTO.getPhone())){
                throw new IllegalArgumentException("用户缺少电话信息.");
            }
            if (!verifyUtil.isExist(sysUserDTO.getUsername()) || !verifyUtil.isExist(sysUserDTO.getName())){
                throw new IllegalArgumentException("用户缺少账号信息.");
            }

            SysUserEntity sysUser = new SysUserEntity();
            sysUser.setUsername(sysUserDTO.getUsername());
            sysUser.setName(sysUserDTO.getName());
            String password;
            if (!verifyUtil.isExist(sysUserDTO.getPassword())){
                password = sysUserDefaultConfig.getPassword();
            }else{
                password = sysUserDTO.getPassword();
            }
            sysUser.setPassword(passwordEncoder.encode(password));
            sysUser.setGrade(sysUserDTO.getGrade());
            sysUser.setPhone(sysUserDTO.getPhone());
            sysUser.setEmail(sysUserDTO.getEmail());
            Long orgId = sysOrganizationRepository.findIdByTypeAndName(sysUserDTO.getOrgType(),sysUserDTO.getOrgName());
            if (verifyUtil.isExist(orgId)){
                sysUser.setOrgId(orgId);
            }else{
                throw new IllegalArgumentException("组织不存在.");
            }
            if (verifyUtil.isExist(sysUserDTO.getDeptName())){
                Long deptId = sysDepartmentRepository.findIdByOrgIdAndName(orgId,sysUserDTO.getDeptName());
                if (!verifyUtil.isExist(deptId)){
                    throw new IllegalArgumentException("部门不存在.");
                }else{
                    sysUser.setDeptId(deptId);
                }
            }
            sysUser.setRoleId(sysUserDefaultConfig.getRoleId());

            sysUser.setStatus(sysUserDefaultConfig.getStatus());
            sysUser.setIsDeleted(sysUserDefaultConfig.getIsDeleted());
            LocalDate now = LocalDate.now();
            sysUser.setCreateDate(now);
            sysUser.setUpdateDate(now);
            sysUserRepository.save(sysUser);

        }catch (Exception e){
            throw new Exception("创建用户失败:" + e.getMessage());
        }
    }

    @Override
    public void permUpdate(AdminDTO adminDTO) throws Exception {
        try {
            if (!verifyUtil.isExist(adminDTO)){
                throw new IllegalArgumentException("权限信息为空.");
            }
            permService.update(adminDTO);
        }catch (Exception e){
            throw new Exception("权限更新失败.");
        }
    }

    @Override
    public void userMove(SysUserDTO sysUserDTO) throws Exception {
        try {
            if (!verifyUtil.isExist(sysUserDTO)){
                throw new IllegalArgumentException("迁移信息为空.");
            }
            if (!verifyUtil.isExist(sysUserDTO.getOrgName()) || !verifyUtil.isExist(sysUserDTO.getOrgType())){
                throw new IllegalArgumentException("用户组织信息为空.");
            }
            Long orgId = sysOrganizationRepository.findIdByTypeAndName(sysUserDTO.getOrgType(),sysUserDTO.getOrgName());
            if (!verifyUtil.isExist(orgId)){
                throw new IllegalArgumentException("组织信息不存在.");
            }
            if (verifyUtil.isExist(sysUserDTO.getDeptName())) {
                Long deptId = sysDepartmentRepository.findIdByOrgIdAndName(orgId, sysUserDTO.getDeptName());
                if (!verifyUtil.isExist(deptId)) {
                    throw new IllegalArgumentException("部门信息不存在.");
                }
            }
            Long userId = sysUserDTO.getId();
            if (!verifyUtil.isExist(userId)){
                throw new IllegalArgumentException("缺少用户信息.");
            }
            SysUserEntity sysUser = sysUserRepository.findSysUserEntityById(userId);
            if (!verifyUtil.isExist(sysUser)){
                throw new IllegalArgumentException("用户不存在.");
            }
            if (!Objects.equals(sysUser.getOrgId(), orgId)){
                throw new IllegalArgumentException("用户仅允许在组织内迁移.");
            }
            Long deptId = sysDepartmentRepository.findIdByOrgIdAndName(orgId, sysUserDTO.getDeptName());
            sysUser.setDeptId(deptId);
            LocalDate now = LocalDate.now();
            sysUser.setUpdateDate(now);
            sysUserRepository.save(sysUser);

        }catch (Exception e){
            throw new Exception("用户迁移失败:" + e.getMessage());
        }
    }

    @Override
    public void userDelete(Long userId) throws Exception {
        try {
            SysUserEntity sysUser = sysUserRepository.findSysUserEntityById(userId);
            if (!verifyUtil.isExist(sysUser)){
                throw new IllegalArgumentException("用户不存在.");
            }
            sysUser.setIsDeleted((byte)1);
            LocalDate now = LocalDate.now();
            sysUser.setUpdateDate(now);
            sysUserRepository.save(sysUser);
        }catch (Exception e){
            throw new Exception("删除用户失败:" + e.getMessage());
        }
    }

    @Override
    public void userDelete(String refreshToken) throws Exception {
        try{
            if (!verifyUtil.isExist(refreshToken)){
                throw new IllegalArgumentException("用户信息为空.");
            }
            jwtUtil.validateToken(refreshToken);

            if (!verifyUtil.isExist(jwtUtil.getFromToken(refreshToken,"username"))){
                throw new IllegalArgumentException("用户信息缺失.");
            }
            String username = jwtUtil.getFromToken(refreshToken,"username");

            SysUserEntity sysUser = sysUserRepository.findSysUserEntityByUsername(username);
            if (!verifyUtil.isExist(sysUser)){
                throw new IllegalArgumentException("用户不存在.");
            }
            sysUser.setIsDeleted((byte) 1);
            LocalDate now = LocalDate.now();
            sysUser.setUpdateDate(now);
            sysUserRepository.save(sysUser);

            String redisKey = "refresh_token:" + username;
            redisTemplate.delete(redisKey);

        }catch (Exception e){
            throw new Exception("注销账号失败:" + e.getMessage());
        }
    }

    @Override
    public SysUserDTO userView(Long userId) throws Exception {
        if (!verifyUtil.isExist(userId)){
            throw new IllegalArgumentException("用户不存在.");
        }
        SysUserEntity user = sysUserRepository.findSysUserEntityById(userId);
        if (!verifyUtil.isExist(user)){
            throw new IllegalArgumentException("用户不存在.");
        }

        SysUserDTO self = convertUtil.userToDTO(user);

        return self;
    }

    @Override
    public Page<SysUserEntity> showAdmin(Long orgId, Integer current, Integer size){
        Pageable pageable = PageRequest.of(current-1,size);
        Page<SysUserEntity> page = sysUserRepository.findAllByOrgIdAndRoleIdNot(orgId,2L,pageable);
        return page;
    }
}

```

