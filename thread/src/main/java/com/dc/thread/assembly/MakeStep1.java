package com.dc.thread.assembly;

import com.dc.thread.procon.IdSingle;
import com.dc.thread.procon.Message;
import com.dc.thread.procon.disruptor.MessageFactory;

import java.util.List;

public class MakeStep1 extends AbstractMakeStep {

    public MakeStep1(AbstractMakeStep nextMake) {
        super(nextMake);
    }

    @Override
    public void run() {
        List<Message> nextList = super.getNextMakeStep().getCurrList();
        MessageFactory factory = new MessageFactory();
        while (true){
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message m = factory.newInstance();
            m.setMessageId(IdSingle.getIntegerId());
            nextList.add(m);
            System.out.println("make 1 ---" + m.getMessageId());
        }
    }
}
