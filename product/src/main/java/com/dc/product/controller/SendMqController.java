package com.dc.product.controller;

import com.dc.api.domain.User;
import com.dc.product.mq.ProductConfirmCallback;
import com.dc.product.support.IdSingleton;
import com.dc.product.support.MyController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@MyController(mapping = "/mq/", name = "sendMqController")
@Slf4j
public class SendMqController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "send",method = RequestMethod.GET)
    public void send() {
        for (int o = 0; o < 3; o++){
            User user = new User();
            CorrelationData correlationData = new CorrelationData();
            String id = o + "---" + IdSingleton.getIntegerId().toString();
            correlationData.setId(id);
            user.setId(o);
            rabbitTemplate.convertAndSend("delayExchange", "topic", user, correlationData);
            ProductConfirmCallback.addToMap(id, user);
        }
    }
}
