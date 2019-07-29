package com.dc.consumer.mq;

import com.rabbitmq.client.ShutdownSignalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionListener;

@Slf4j
public class ConsumerConnectionListener implements ConnectionListener {

    @Override
    public void onCreate(Connection connection) {
        log.info("ConnectionListener onCreate");
    }
    @Override
    public void onClose(Connection connection) {
        log.info("ConnectionListener onClose");
    }
    @Override
    public void onShutDown(ShutdownSignalException signal) {
        log.info("ConnectionListener onShutDown");
    }
}
