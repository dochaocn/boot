package com.dc.cloudconsumer.controller;

import com.dc.api.support.CloudComponent;
import com.dc.cloudconsumer.domain.Order;
import com.dc.cloudconsumer.response.ModelFactory;
import com.dc.cloudconsumer.response.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@CloudComponent(mapping = "/validate")
@Validated
public class ValidateController {

    @RequestMapping(path = "/order", method = RequestMethod.GET)
    public ResponseModel validate(@Validated Order order){
        order.setId(10000000000L);
        order.setName("dc");
        log.info(order.toString());
        return ModelFactory.newSuccessResponseModel().setMsg("成功").setData(order);
    }

    @RequestMapping(path = "/order1", method = RequestMethod.GET)
    public Long validate1(@NotBlank String name, @Max(value = 9999L) Long id){
        return 10000000000L;
    }

    @RequestMapping(path = "/order2", method = RequestMethod.GET)
    public ResponseModel order2(@NotBlank String name, @Max(value = 9999L) Long id){
        Order order = new Order();
//        int i = 1 / 0;
        order.setId(id);
        order.setName(name);
        order.setLocalDate(LocalDate.now());
        this.execute(id);
        return ModelFactory.newSuccessResponseModel().setMsg("成功").setData(order);
    }

    private void execute(Long id) {
        try {
            if (id > 1000) {
                int i = 1 / 0;
            }
        } catch (Exception e) {
            throw new ServiceException("ERR001", "自定义错误1", e);
        }
    }

}
