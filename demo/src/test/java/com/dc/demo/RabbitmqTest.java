package com.dc.demo;

import com.dc.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RabbitmqTest {

    @Resource
    private RabbitTemplate rabbitTemplate;
    @Resource
    private RabbitAdmin rabbitAdmin;

    @Test
    public void test() {

        for (int o = 0; o < 5000; o++){
            rabbitTemplate.convertAndSend("exchange.direct", "key.01", new User());
            rabbitTemplate.convertAndSend("exchange.fanout", "key.02", new User());
//            log.info(o + "");
        }
    }

    @Test
    public void event() {
        Object o =  rabbitTemplate.receiveAndConvert("queues.01");
        log.info(o.toString());
    }

    @Test
    public void sendMessage() {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.getHeaders().put("desc","描述");
        messageProperties.getHeaders().put("type","消息类型");
        Message message = new Message("Hello".getBytes(),messageProperties);

        rabbitTemplate.convertAndSend(message);
    }

    @Test
    public void diff() {
        rabbitAdmin.declareQueue();
    }
}
