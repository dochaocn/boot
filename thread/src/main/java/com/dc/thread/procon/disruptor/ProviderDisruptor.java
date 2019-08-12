package com.dc.thread.procon.disruptor;

import com.dc.thread.procon.IdSingle;
import com.dc.thread.procon.Message;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;

public class ProviderDisruptor implements Runnable{
    private final RingBuffer<Message> ringBuffer;

    public ProviderDisruptor(RingBuffer<Message> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void pushMessage(ByteBuffer bb) {
        long sequence =  ringBuffer.next();
        Message m = ringBuffer.get(sequence);
        m.setMessageId(IdSingle.getIntegerId());
        m.setBody("dcc" + sequence);
        m.setDate(LocalDateTime.now());
        m.setSequence(sequence);

        ringBuffer.publish(sequence);
        System.out.println("开始投递---" + Thread.currentThread().getName() + " :: " + m.toString());
    }

    @Override
    public void run() {
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long i = 0; true; i++) {
            bb.putLong(0,i);
            this.pushMessage(bb);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
