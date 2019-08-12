package com.dc.thread.procon.disruptor;

import com.dc.thread.procon.Message;
import com.lmax.disruptor.EventFactory;

public class MessageFactory implements EventFactory<Message> {

    @Override
    public Message newInstance() {
        return new Message();
    }
}
