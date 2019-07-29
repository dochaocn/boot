package com.dc.consumer.config;

import com.dc.consumer.mq.ConsumerChannelListener;
import com.dc.consumer.mq.ConsumerConnectionListener;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ShutdownSignalException;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ChannelListener;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class MqConfig {

    @Resource
    private CachingConnectionFactory connectionFactory;
    @Resource
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
