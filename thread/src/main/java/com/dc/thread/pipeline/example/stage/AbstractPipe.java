package com.dc.thread.pipeline.example.stage;

import com.dc.thread.pipeline.example.Pipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public abstract class AbstractPipe<IN, OUT> implements Pipe<IN, OUT> {
    private Pipe<?, ?> nextDecoratorPipe = null;
    @Value("${thread.sleepTime}")
    protected long sleepTime;

    @Override
    public void setNextPipe(Pipe<?, ?> nextDecoratorPipe) {
        this.nextDecoratorPipe = nextDecoratorPipe;
    }

    @Override
    public void process(IN input) {
        OUT out = doProcess(input);
        if(nextDecoratorPipe != null && out != null){
            ((Pipe<OUT, ?>) nextDecoratorPipe).process(out);
        }
    }

    /**
     * 留给子类实现，用于子类实现其任务处理逻辑
     */
    public abstract OUT doProcess(IN input);

}