package com.dc.thread.pipeline.example.decorator;

import com.dc.thread.pipeline.example.Pipe;

import java.util.concurrent.ExecutorService;

public class AsyncPipeDecorator<IN, OUT> implements Pipe<IN, OUT> {
    private final Pipe<IN, OUT> pipe;
    private final ExecutorService executorService;

    public AsyncPipeDecorator(Pipe<IN, OUT> pipe, ExecutorService executorService) {
        this.pipe = pipe;
        this.executorService = executorService;
    }

    @Override
    public void setNextPipe(Pipe<?, ?> nextPipe) {
        pipe.setNextPipe(nextPipe);
    }

    @Override
    public void process(IN input) {
        executorService.execute(() -> pipe.process(input));
    }

}