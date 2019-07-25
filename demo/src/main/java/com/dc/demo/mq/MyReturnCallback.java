package com.dc.demo.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Slf4j
public class MyReturnCallback implements RabbitTemplate.ReturnCallback {

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("returnedMessage");
        log.info(replyCode+"");
        log.info(replyText);
        log.info(exchange);
        log.info(routingKey);
        if (message != null)
            log.info(message.toString());
    }
}
