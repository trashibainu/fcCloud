package com.feichai.basejar.commons;

import com.feichai.basejar.enums.ResultCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommonResult<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public CommonResult(){}

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

    public static <T> CommonResult success(T data,String msg){
        return new CommonResult(ResultCode.SUCCESS.getCode(),msg,data);
    }

    public static <T> CommonResult success(T ... data){
        List<T> list=new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            list.add(data[i]);
        }
        return new CommonResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),list);
    }

    public static <T> CommonResult failed(){
        return new CommonResult(ResultCode.ERROR.getCode(),ResultCode.ERROR.getMsg(),null);
    }

    public static <T> CommonResult failed(T data){
        return new CommonResult(ResultCode.ERROR.getCode(),ResultCode.ERROR.getMsg(),data);
    }

}
