package com.dc.thread.procon.disruptor;

import com.dc.thread.procon.Message;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MainDisruptor {

    public static void main(String[] args) {
        ThreadFactory executor = Executors.defaultThreadFactory();
        ExecutorService executorService = Executors.newCachedThreadPool();
        int bufferSize = 1024;
        Disruptor<Message> disruptor = new Disruptor<>(Message::new, bufferSize, executor);
        disruptor.handleEventsWithWorkerPool(new ConsumerDisruptor(), new ConsumerDisruptor());
        disruptor.start();

        for (int i = 0; i < 4; i++) {
            executorService.execute(() -> new ProviderDisruptor(disruptor.getRingBuffer()).run());
        }
    }
}
