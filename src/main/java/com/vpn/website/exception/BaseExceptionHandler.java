package com.vpn.website.exception;

import com.vpn.website.common.base.BaseResult;
import com.vpn.website.common.configure.AppConstants;
import com.vpn.website.common.core.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理拦截器
 * @author hll
 * @date 2018年5月25日
 */
@CrossOrigin
@ControllerAdvice
@ResponseBody
public class BaseExceptionHandler {
    @Autowired
    AppConstants appConstants;

    private static final String logExceptionFormat = "Capture Exception By GlobalExceptionHandler: Code: %s Detail: %s";

    private static Logger log = LoggerFactory.getLogger(BaseExceptionHandler.class);

    //后面常规自定义异常
    @ExceptionHandler(BaseException.class)
    public BaseResult baseException(BaseException ex) {
        return exceptionFmtMessage(ex.getCode(), ex);
    }

    //其他错误
    @ExceptionHandler({Exception.class})
    public BaseResult exception(Exception ex) {
        return exceptionFmtString(HttpStatus.OTHER, ex);
    }

    //参数验证异常处理
    @ExceptionHandler(BindException.class)
    public BaseResult validExceptionHandler(BindException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        assert fieldError != null;
        log.error(fieldError.getField() + ":" + fieldError.getDefaultMessage());
        return BaseResult.initResult(99, fieldError.getDefaultMessage());
    }
    //参数验证异常处理
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult validExceptionHandler(MethodArgumentNotValidException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        assert fieldError != null;
        log.error(fieldError.getField() + ":" + fieldError.getDefaultMessage());
        return BaseResult.initResult(99, fieldError.getDefaultMessage());
    }

    /**
     * 将异常结果以含关键报错信息出去
     * 如：java.lang.ArithmeticException: / by zero
     * @return
     */
    private <T extends Throwable> BaseResult exceptionFmtString(Integer code, T ex) {
        ex.printStackTrace();
        log.error(String.format(logExceptionFormat, code, ex.toString()));
        if(appConstants.isFortest()){
            return BaseResult.initResult(code, ex.toString());
        }else{
            return BaseResult.initResult(code,"操作失败:"+ex.getLocalizedMessage());
        }
    }

    /**
     * 将异常结果反馈异常消息
     * 如：/ by zero
     * @return
     */
    private <T extends Throwable> BaseResult exceptionFmtMessage(Integer code, T ex) {
        ex.printStackTrace();
        log.error(String.format(logExceptionFormat, code, ex.getMessage()));
        return BaseResult.initResult(code, ex.getMessage());
    }
}
