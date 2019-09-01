package com.dc.thread.pipeline.example;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;

@Slf4j
public class ThreadPoolPipeDecorator<IN, OUT> implements Pipe<IN, OUT> {
    private final Pipe<IN, OUT> delegate;
    private final ExecutorService executorService;

    public ThreadPoolPipeDecorator(Pipe<IN, OUT> delegate, ExecutorService executorService) {
        this.delegate = delegate;
        this.executorService = executorService;
    }

    @Override
    public void setNextPipe(Pipe<?, ?> nextPipe) {
        delegate.setNextPipe(nextPipe);
    }

    @Override
    public void process(IN input) {
        Runnable task = () -> {
            try {
                delegate.process(input);
            } catch (Exception e) {
                log.error("", e);
            }
        };

        executorService.execute(task);
    }

}