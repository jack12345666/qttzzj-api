package com.vpn.website.exception;

import com.vpn.website.common.core.HttpStatus;

/**
 * @author wangzhihong
 * @Date 2020/3/20 10:43
 * @Desc 自定义异常
 */
public class BaseException extends RuntimeException {
    private Integer code = HttpStatus.BASE;
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BaseException() {
    }

    public BaseException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
