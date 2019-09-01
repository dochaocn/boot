package com.dc.thread.pipeline.example;

import com.dc.thread.pipeline.tools.PipeException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractPipe<IN, OUT> implements Pipe<IN, OUT> {
    private volatile Pipe<?, ?> nextPipe = null;

    @Override
    public void setNextPipe(Pipe<?, ?> nextPipe) {
        this.nextPipe = nextPipe;
    }

    @Override
    public void process(IN input) {
        try {
            OUT out = doProcess(input);
            if(null != nextPipe){
                if(null != out){
                    ((Pipe<OUT, ?>) nextPipe).process(out);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            log.error("", e);
        }
    }

    /**
     * 留给子类实现，用于子类实现其任务处理逻辑
     */
    public abstract OUT doProcess(IN input) throws PipeException, InterruptedException;

}