package com.dc.product.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ShutdownSignalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ChannelListener;

@Slf4j
public class ProductChannelListener implements ChannelListener {

    @Override
    public void onCreate(Channel channel, boolean transactional) {
        log.info("Channel onCreate");
    }
    @Override
    public void onShutDown(ShutdownSignalException signal) {
        log.info("Channel onShutDown");
    }
}
