package com.dc.dubbo.mq;

import com.dc.api.domain.User;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RabbitMqListener {

    private static Map<Integer,User> map;

    static {
        map = new HashMap<>();
    }

    @RabbitListener(queues = "queues.01")
    public void mqListener1(User user) {
        log.info("queues.01"+user.toString());
    }

    @RabbitListener(queues = "queues.02")
    public void mqListener2(Message message) {
        log.info("queues.02"+message.toString());
    }

    @RabbitListener(queues = "queue")
    public void queue(Message message, Channel channel, User user) throws IOException {
        log.info("message={}", message.toString());
        log.info("user={}", user.toString());

        map.put(user.getId(),user);

//        try {
            if (0 == user.getId()) {
                int i = 1/0;
            }
//        } catch (Exception e) {
//            log.error("处理消息发生错误,丢弃该条消息");
//            try {
//                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);


//        //消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//        //ack返回false，并重新回到队列，api里面解释得很清楚
//        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
//        //丢弃这条消息
//        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
//        //拒绝消息
//        channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
//            } catch (IOException ignored) {
//
//            }
//
//        }
    }

    /**
     *  auto：处理消息时，若出现异常则把该条消息重新投递到队列末尾，每次接收为不同对象
     *  none：处理消息时，若出现异常直接丢弃消息
     *  manual: 处理消息时，手动确认，丢弃或重新投递等
     *
     */



    @PostConstruct
    public void construct() {
        log.info(map.toString());
    }
}
