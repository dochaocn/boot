package com.dc.thread.procon;

import java.util.List;

public class Consumer implements Runnable{
    private List<Message> messageList;

    public Consumer(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public void run() {
        Message m;
        while (true){
            synchronized (messageList){
                if (messageList.size() > 0) {
                    m = messageList.get(0);
                    System.out.println(Thread.currentThread().getName() + "消费....." + m);
                    messageList.remove(0);
                }
            }
        }
    }
}
