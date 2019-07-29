package com.dc.consumer.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ShutdownSignalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ChannelListener;

@Slf4j
public class ConsumerChannelListener implements ChannelListener {

    @Override
    public void onCreate(Channel channel, boolean transactional) {
        log.info("ChannelListener onCreate,{}",channel.getChannelNumber());
    }

    @Override
    public void onShutDown(ShutdownSignalException signal) {
        log.info("ChannelListener onShutDown,signal={}",signal.toString());
    }
}
