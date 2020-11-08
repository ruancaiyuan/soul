package com.yuan.exception;


import com.yuan.constant.enums.ErrorCode;
import com.yuan.constant.enums.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException {
    private Integer code;

    public BusinessException(String message) {
        super(message);
        this.code = ErrorCode.SYSTEM_ERROR.getCode();
    }

    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }


    public BusinessException(Integer statusCode, String message) {
        super(message);
        this.code = statusCode;
    }

    public BusinessException(Integer statusCode, String message, Throwable t) {
        super(message, t);
        this.code = statusCode;
    }

    public BusinessException(String message, Throwable t) {
        super(message, t);
    }
}
