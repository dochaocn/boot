package com.dc.cloudconsumer.controller;

import com.dc.cloudconsumer.response.ModelFactory;
import com.dc.cloudconsumer.response.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ValidationException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ControllerAdvice(basePackages = {"com.dc.cloudconsumer.controller"}) // 定义异常处理handler,指定包/类/注解
@ResponseBody
public class ExceptionHandle {

    @ExceptionHandler(value = BindException.class) // 只会处理该类型异常
    public ResponseModel handleBindException(BindException exception) {
        log.error("controller异常: ", exception);
        StringBuffer msg = new StringBuffer();
        exception.getAllErrors()
                .forEach(error -> {
                    FieldError e = (FieldError) error;
                    msg.append(e.getField()).append(e.getDefaultMessage()).append("; ");
                });
        return ModelFactory.newErrorResponseModel().setMsg(msg.toString());
    }

    // ArithmeticException.class
    @ExceptionHandler(value = ValidationException.class) // 只会处理该类型异常
    public ResponseModel handleValidationException(ValidationException exception) {
        log.error("controller异常: ", exception);
        return ModelFactory.newErrorResponseModel().setMsg(exception.getMessage());
    }

    @ExceptionHandler(value = ServiceException.class) // 只会处理该类型异常
    public ResponseModel handleServiceException(ServiceException exception) {
        log.error("controller异常: ", exception.getException());
        return ModelFactory.newErrorResponseModel().setMsg("服务调用失败");
    }
}
