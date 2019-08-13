package com.dc.thread.assembly;


import com.dc.thread.procon.Message;

import java.util.List;

public class MakeResult extends AbstractMakeStep {

    public MakeResult() {
    }

    @Override
    public void run() {
        List<Message> currList = super.getCurrList();
        while (true) {
            if (currList.size() > 0) {
                Message m = currList.get(0);
                System.out.println(m);
                currList.remove(0);
            }
        }
    }
}
