package com.dc.dubbo.service;

import com.dc.api.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqService {

    @RabbitListener(queues = "queues.01")
    public void mqListener1(User user) {
        log.info("queues.01"+user.toString());
    }

    @RabbitListener(queues = "queues.02")
    public void mqListener2(Message message) {
        log.info("queues.02"+message.toString());
    }

    @RabbitListener(queues = "queues.03")
    public void mqListener3(Message message) {
        log.info("queues.03"+message.toString());
    }
}
