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
