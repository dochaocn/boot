package com.dc.demo.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Slf4j
public class MyConfirmCallback implements RabbitTemplate.ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("confirm message,ack={},cause={}",ack,cause);
        if (correlationData != null)
            log.info(correlationData.toString());
    }
}
