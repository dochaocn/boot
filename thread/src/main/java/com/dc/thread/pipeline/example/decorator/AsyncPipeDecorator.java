package com.dc.thread.pipeline.example.decorator;

import com.dc.thread.pipeline.example.Pipe;

import java.util.concurrent.ExecutorService;

public class AsyncPipeDecorator<IN, OUT> implements Pipe<IN, OUT> {
    private final Pipe<IN, OUT> abstractPipe;
    private final ExecutorService executorService;

    public AsyncPipeDecorator(Pipe<IN, OUT> abstractPipe, ExecutorService executorService) {
        this.abstractPipe = abstractPipe;
        this.executorService = executorService;
    }

    @Override
    public void setNextPipe(Pipe<?, ?> nextDecoratorPipe) {
        abstractPipe.setNextPipe(nextDecoratorPipe);
    }

    @Override
    public void process(IN input) {
        executorService.execute(() -> abstractPipe.process(input));
    }

}