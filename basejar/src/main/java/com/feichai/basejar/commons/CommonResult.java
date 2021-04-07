package com.feichai.basejar.commons;

import com.alibaba.fastjson.JSONObject;
import com.feichai.basejar.enums.ResultCode;

public class CommonResult<T> {
    private int code;
    private String msg;
    private T data;

    public CommonResult(int code, String msg, T data) {
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    public static <T> CommonResult success(){
        return new CommonResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),null);
    }

    public static <T> CommonResult success(T data){
        return new CommonResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),data);
    }

    public static <T> CommonResult failed(){
        return new CommonResult(ResultCode.ERROR.getCode(),ResultCode.ERROR.getMsg(),null);
    }

    public static <T> CommonResult failed(T data){
        return new CommonResult(ResultCode.ERROR.getCode(),ResultCode.ERROR.getMsg(),data);
    }

    private String toJson(){
        return JSONObject.toJSONString(this);
    }

    public String toString(){
        return "{\"code\":"+code+",\"msg\":\""+msg+"\",\"data\":"+toJson()+"}";
    }
}
