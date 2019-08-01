package com.dc.product.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MoreMqConfig {

    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.port}")
    private String port;
    @Value("${spring.rabbitmq.host}")
    private String host;
    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;
    @Value("${spring.rabbitmq.publisher-confirms}")
    private boolean confirms;
    @Value("${spring.rabbitmq.publisher-returns}")
    private boolean returns;
    @Value("${spring.rabbitmq.template.mandatory}")
    private boolean mandatory;

    // 容器中注入链接工厂，spring
    @Bean(name = "connectionFactory")
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(host + ":" + port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setPublisherConfirms(confirms);
        connectionFactory.setPublisherReturns(returns);
        return connectionFactory;
    }

    // 容器中注入rabbitTemplate
    @Bean(name = "rabbitAdmin")
    public RabbitAdmin rabbitAdmin() {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
        rabbitAdmin.getRabbitTemplate().setMandatory(mandatory);
        return rabbitAdmin;
    }



    @Value("${rabbitmq.username}")
    private String usernameLocal;
    @Value("${rabbitmq.password}")
    private String passwordLocal;
    @Value("${rabbitmq.port}")
    private String portLocal;
    @Value("${rabbitmq.host}")
    private String hostLocal;
    @Value("${rabbitmq.virtual-host.dev}")
    private String virtualHostDev;
    @Value("${rabbitmq.virtual-host.pro}")
    private String virtualHostPro;

    @Bean(name = "connectionFactoryForDev")
    public CachingConnectionFactory connectionFactoryForDev() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(hostLocal + ":" + portLocal);
        connectionFactory.setUsername(usernameLocal);
        connectionFactory.setPassword(passwordLocal);
        connectionFactory.setVirtualHost(virtualHostDev);
        return connectionFactory;
    }

    @Bean(name = "rabbitAdminForDev")
    public RabbitAdmin rabbitAdminForDev() {
        return new RabbitAdmin(connectionFactoryForDev());
    }

    @Bean(name = "connectionFactoryForPro")
    public CachingConnectionFactory connectionFactoryForPro() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(hostLocal + ":" + portLocal);
        connectionFactory.setUsername(usernameLocal);
        connectionFactory.setPassword(passwordLocal);
        connectionFactory.setVirtualHost(virtualHostPro);
        return connectionFactory;
    }

    @Bean(name = "rabbitAdminForPro")
    public RabbitAdmin rabbitAdminForPro() {
        return new RabbitAdmin(connectionFactoryForPro());
    }


}
