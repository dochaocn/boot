package com.dc.cloudconsumer.controller;

import com.dc.api.support.CloudComponent;
import com.dc.cloudconsumer.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@CloudComponent(mapping = "/validate")
public class ValidateController {

    @RequestMapping(path = "/order", method = RequestMethod.GET)
    public Order validate(@Validated Order order){
//        int i = 1 / 0;
        order.setId(10000000000L);
        order.setName("dc");
        log.info(order.toString());
        return order;
    }

}
