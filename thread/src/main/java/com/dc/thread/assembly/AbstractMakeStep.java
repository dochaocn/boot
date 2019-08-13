package com.dc.thread.assembly;

import com.dc.thread.procon.Message;
import lombok.Getter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractMakeStep implements Runnable{

    @Getter
    protected List<Message> currList;
    @Getter
    protected AbstractMakeStep nextMakeStep;

    public AbstractMakeStep() {
        this.currList = Collections.synchronizedList(new LinkedList<>());
    }

    public AbstractMakeStep(AbstractMakeStep nextMakeStep) {
        this();
        this.nextMakeStep = nextMakeStep;
    }
}
