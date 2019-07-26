package com.dc.consumer.mq;

import com.dc.api.domain.User;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ConsumerMqListener {

    private static Map<Integer,User> map;

    @RabbitListener(queues = "queues.01")
    public void mqListener1(User user) {
        log.info("queues.01"+user.toString());
    }

    @RabbitListener(queues = "queues.02")
    public void mqListener2(Message message) {
        log.info("queues.02"+message.toString());
    }

    @RabbitListener(queues = "queue")
    public void queue(Message message, Channel channel, User user) {
        log.info("message={}", message.toString());
        log.info("user={}", user.toString());

        map.put(user.getId(),user);

        // 业务处理
        try {
            if (0 == user.getId()) {
                int i = 1/0;
            }

            // 处理成功,从map中移除,且确认已经收到
//            map.remove(user.getId());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            if (map.keySet().size() == 3) this.destroy();
        } catch (Exception e) {
            log.error("处理消息发生错误", e);
            try {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            } catch (IOException ex) {
                log.error("Channel链接错误", ex);
            }
        }
    }


//        //消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//        //ack返回false，并重新回到队列，api里面解释得很清楚
//        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
//        //丢弃这条消息
//        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
//        //拒绝消息
//        channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);

    /**
     *  auto：处理消息时，若出现异常则把该条消息重新投递到队列末尾，每次接收为不同对象
     *  none：处理消息时，若出现异常直接丢弃消息
     *  manual: 处理消息时，手动确认，丢弃或重新投递等
     *
     */


//    构造方法  ——> @Autowired ——> @PostConstruct ——> 静态方法 （按此顺序加载）
    @PostConstruct
    public void construct() {
        map = new HashMap<>();
    }

    @PreDestroy
    public void destroy() {
        log.info(map.toString());
    }
}
