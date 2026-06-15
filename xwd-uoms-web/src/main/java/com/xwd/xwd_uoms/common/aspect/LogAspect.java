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