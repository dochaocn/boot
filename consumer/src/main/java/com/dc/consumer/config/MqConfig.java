package com.dc.consumer.config;

import com.dc.consumer.mq.ConsumerChannelListener;
import com.dc.consumer.mq.ConsumerConnectionListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;

@Configuration
public class MqConfig {

    @Resource
    private CachingConnectionFactory connectionFactory;
    @Resource
    @Lazy // 解决与actuator循环依赖问题,延迟此处加载
    private RabbitTemplate rabbitTemplate;

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public void rabbitConfig() {
        connectionFactory.setConnectionNameStrategy(connectionFactory -> "CONSUMER_CONNECTION");
        connectionFactory.addChannelListener(new ConsumerChannelListener());
        connectionFactory.addConnectionListener(new ConsumerConnectionListener());

        rabbitTemplate.setMessageConverter(messageConverter());
    }
}
