package com.dc.thread.assembly;

import com.dc.thread.procon.Message;

import java.time.LocalDateTime;
import java.util.List;

public class MakeStep3 extends AbstractMakeStep {

    public MakeStep3(AbstractMakeStep nextMake) {
        super(nextMake);
    }

    @Override
    public void run() {
        List<Message> currList = super.getCurrList();
        List<Message> nextList = super.getNextMakeStep().getCurrList();
        while (true){
            if (currList.size() > 0) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message m = currList.get(0);
                m.setDate(LocalDateTime.now());
                m.setSequence(1L);
                nextList.add(m);
                currList.remove(0);
                System.out.println("make 3 ---" + m.getDate());
            }
        }
    }
}
