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

        /*
         * exchange 正确,queue 正确,confirm被回调, ack=true
         * exchange 错误,queue 正确,confirm被回调, ack=false
         * exchange 正确,queue 错误,confirm被回调, ack=true,return被回调
         * exchange 错误,queue 错误,confirm被回调, ack=false
         *
         * 如果消息没有到exchange,则confirm回调,ack=false
         * 如果消息到达exchange,则confirm回调,ack=true
         * exchange到queue成功,则不回调return
         * exchange到queue失败,则回调return(需设置mandatory=true,否则不回回调,消息就丢了)
         */

            rabbitTemplate.convertAndSend("delayExchange", "topic", user, correlationData);
            ProductConfirmCallback.addToMap(id, user);
        }
    }
}
