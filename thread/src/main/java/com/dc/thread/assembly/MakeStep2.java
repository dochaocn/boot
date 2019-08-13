package com.dc.thread.assembly;

import com.dc.thread.procon.Message;

import java.util.List;

public class MakeStep2 extends AbstractMakeStep {

    public MakeStep2(AbstractMakeStep nextMake) {
        super(nextMake);
    }

    @Override
    public void run() {
        List<Message> currList = super.getCurrList();
        List<Message> nextList = super.getNextMakeStep().getCurrList();
        int i = 0;
        while (true){
            if (currList.size() > 0) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message m = currList.get(0);
                m.setBody("dc" + i++);
                nextList.add(m);
                currList.remove(0);
                System.out.println("make 2 ---" + m.getBody());
            }
        }
    }
}
