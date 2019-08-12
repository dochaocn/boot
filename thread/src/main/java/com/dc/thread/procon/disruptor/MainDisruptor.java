package com.dc.thread.procon.disruptor;

import com.dc.thread.procon.Message;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MainDisruptor {

    public static void main(String[] args) throws InterruptedException {
        ThreadFactory executor = Executors.defaultThreadFactory();
        int bufferSize = 1024; // 2的幂
//        EventFactory 使用lambda表达式
        Disruptor<Message> disruptor = new Disruptor<Message>(Message::new, bufferSize, executor);
        disruptor.handleEventsWithWorkerPool(new ConsumerDisruptor(), new ConsumerDisruptor());
        disruptor.start();

        for (int i = 0; i < 4; i++) {
            new Thread(new ProviderDisruptor(disruptor.getRingBuffer())).start();
        }
    }
}
