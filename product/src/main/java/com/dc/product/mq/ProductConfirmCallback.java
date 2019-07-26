package com.dc.product.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.Hashtable;
import java.util.Map;

@Slf4j
public class ProductConfirmCallback implements RabbitTemplate.ConfirmCallback {

    private static final Map<String,Object> confirmMap;

    static {
        confirmMap = new Hashtable<>();
    }

    public static void addToMap(String id, Object object) {
        log.info("已发送,等待确认,ID={}",id);
        confirmMap.put(id, object);
    }

    public static void removeToMMap(String id) {
        log.info("确认成功,ID={}",id);
        confirmMap.remove(id);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("confirm message,ack={},cause={}",ack,cause);
        if (correlationData != null)
            removeToMMap(correlationData.getId());
    }
}
