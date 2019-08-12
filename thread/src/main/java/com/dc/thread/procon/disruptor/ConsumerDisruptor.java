package com.dc.thread.procon.disruptor;

import com.dc.thread.procon.Message;
import com.lmax.disruptor.WorkHandler;

public class ConsumerDisruptor implements WorkHandler<Message> {

    @Override
    public void onEvent(Message m) throws Exception {
        System.out.println("开始消费---" + Thread.currentThread().getName() + " :: " + m.toString());
    }
}
