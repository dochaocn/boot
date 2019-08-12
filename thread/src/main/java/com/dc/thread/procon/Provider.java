package com.dc.thread.procon;

import java.time.LocalDateTime;
import java.util.List;

public class Provider implements Runnable{
    private List<Message> messageList;

    public Provider(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public void run() {
        Message m;
        while (true){
            if (messageList.size() <= 5) {
                m = new Message();
                m.setMessageId(IdSingle.getIntegerId());
                m.setBody("dcc");
                m.setDate(LocalDateTime.now());
                messageList.add(m);
                System.out.println(Thread.currentThread().getName() + "已生产一个--------------当前库存：" + messageList.size());
            }
        }
    }
}
