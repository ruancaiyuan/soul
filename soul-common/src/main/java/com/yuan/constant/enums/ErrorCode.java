package com.yuan.constant.enums;

public enum ErrorCode implements ResultEnum {

    SYSTEM_ERROR(10001, "系统异常");


    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code; //状态码
    private String message; //异常信息

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
