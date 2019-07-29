package com.dc.product.mq;

import com.rabbitmq.client.Method;
import com.rabbitmq.client.ShutdownSignalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionListener;

@Slf4j
public class ProductConnectionListener implements ConnectionListener {

    @Override
    public void onCreate(Connection connection) {
        com.rabbitmq.client.Connection delegate = connection.getDelegate();
        log.info("onCreate,connection={}",connection.toString());
    }

    @Override
    public void onClose(Connection connection) {
        log.info("onClose");
    }

    @Override
    public void onShutDown(ShutdownSignalException signal) {
        Method reason = signal.getReason();
        String s = reason.protocolMethodName();
        log.info(s);
    }

}
