package com.feichai.basejar.enums;

public enum  ResultCode {
    SUCCESS(200,"success"),
    ERROR(-1,"error");

    private int code;
    private String msg;
    ResultCode(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
