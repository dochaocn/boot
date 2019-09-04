package com.dc.thread.pipeline.example;

public class SyncPipeDecorator<IN, OUT> implements Pipe<IN, OUT> {
    private final Pipe<IN, OUT> pipe;

    public SyncPipeDecorator(Pipe<IN, OUT> pipe) {
        this.pipe = pipe;
    }

    @Override
    public void setNextPipe(Pipe<?, ?> nextPipe) {
        pipe.setNextPipe(nextPipe);
    }

    @Override
    public void process(IN input) {
        pipe.process(input);
    }

}
