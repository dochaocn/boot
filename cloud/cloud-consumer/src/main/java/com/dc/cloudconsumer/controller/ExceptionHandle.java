package com.dc.cloudconsumer.controller;

import com.dc.cloudconsumer.response.ModelFactory;
import com.dc.cloudconsumer.response.ResponseStatus;
import com.dc.cloudconsumer.response.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.Default;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice(basePackages = {"com.dc.cloudconsumer.controller"}) // 定义异常处理handler,指定包/类/注解
@ResponseBody
public class ExceptionHandle {

    @ExceptionHandler(value = BindException.class) // 只会处理该类型异常
    public ResponseModel handleBindException(BindException exception) {
        log.error("controller异常: ", exception);
        StringBuffer msg = new StringBuffer();
        exception.getAllErrors()
                .forEach(error -> msg.append(error.getDefaultMessage()).append(";"));
        return ModelFactory.newErrorResponseModel().setMsg(msg.toString());
    }

    @ExceptionHandler(value = ArithmeticException.class) // 只会处理该类型异常
    public ResponseModel handleArithmeticException(ArithmeticException exception) {
        log.error("controller异常: ", exception);
        return ModelFactory.newErrorResponseModel().setMsg(exception.getMessage());
    }


}
