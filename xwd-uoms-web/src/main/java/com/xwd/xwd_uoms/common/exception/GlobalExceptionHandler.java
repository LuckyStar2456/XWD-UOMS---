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