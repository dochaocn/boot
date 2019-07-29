package com.dc.product;

import com.dc.api.domain.User;
import com.dc.product.mq.ProductConfirmCallback;
import com.dc.product.support.IdSingleton;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RabbitmqTest {

    // RabbitTemplate持有ConnectionFactory的引用(CachingConnectionFactory),用来创建Connection
    // 定义mq各种信息,如exchange,queue等。也可以发送消息convertAndSend。
    @Resource
    private RabbitTemplate rabbitTemplate;

    // 从RabbitAdmin的构造中可知,内部使用RabbitTemplate实现,可以认为是对RabbitTemplate的进一步封装。
    // 定义mq各种信息,无实际发送小米方法。
    @Resource
    private RabbitAdmin rabbitAdmin;

    @Test
    public void test() throws InterruptedException {

        for (int o = 0; o < 3; o++){
            User user = new User();
            CorrelationData correlationData = new CorrelationData();
            String id = o + "---" + IdSingleton.getIntegerId().toString();
            correlationData.setId(id);
            user.setId(o);
//            rabbitTemplate.convertAndSend("exchange.direct", "key.01", new User(), correlationData);
            rabbitTemplate.convertAndSend("exchange.fanout", "key.02", new User());
            rabbitTemplate.convertAndSend("delayExchange", "topic", user, correlationData);
            ProductConfirmCallback.addToMap(id, user);
        }

        Thread.sleep(3000);
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


    /**
     * 定义交换机队列绑定,可以@Bean创建
     */
    @Test
    public void delayDeclare() {

        // 定义交换机
        Exchange exchange = new TopicExchange("delayExchange",true,false);
        rabbitAdmin.declareExchange(exchange);
        log.info(exchange.toString());

        // 定义队列 (延迟队列)
        Map<String,Object> argMap = new HashMap<>();
        argMap.put("x-message-ttl",6000);
        argMap.put("x-dead-letter-exchange", "exchange");
        Queue queue = new Queue("delayQueues",true,false,false, argMap);
        rabbitAdmin.declareQueue(queue);
        log.info(queue.toString());

        // 定义绑定
        Binding binding = BindingBuilder.bind(queue).to(exchange).with("topic").noargs();
        rabbitAdmin.declareBinding(binding);
        log.info(binding.toString());
    }

    @Test
    public void declare() {

        // 定义交换机
        Exchange exchange = new TopicExchange("exchange");
        rabbitAdmin.declareExchange(exchange);
        log.info(exchange.toString());

        // 定义队列
        Queue queue = new Queue("queues");
        rabbitAdmin.declareQueue(queue);
        log.info(queue.toString());

        // 定义绑定
        Binding binding = BindingBuilder.bind(queue).to(exchange).with("topic").noargs();
        rabbitAdmin.declareBinding(binding);
        log.info(binding.toString());
    }
}
