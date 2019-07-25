package com.dc.demo.mq;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Slf4j
public class Product {

    public static void main(String[] args) throws IOException, TimeoutException {
        String queueName = "test.queue";
        String exchangeName = "test.exchange";
        String key = "key.01";

        // 创建链接工厂,用来创建链接connection
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("120.79.182.70");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPort(5672);

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(exchangeName,"topic",true);
        channel.queueDeclare(queueName,true,false,false,null);
        channel.queueBind(queueName,exchangeName,key);

        channel.basicPublish(exchangeName,key,null,"123".getBytes());

        // confirm机制
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long l, boolean b) {
                log.info("handleAck");
            }

            @Override
            public void handleNack(long l, boolean b) {
                log.info("handleNack");
            }
        });

        // return机制
        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int i, String s, String s1, String s2, AMQP.BasicProperties basicProperties, byte[] bytes) {
                log.info("handleReturn");
            }
        });
    }
}
