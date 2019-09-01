package com.dc.thread.pipeline.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

@Slf4j
public class SimplePipeline<IN, OUT> {
    private final Queue<Pipe<IN, OUT>> pipes = new LinkedList<>();

    public void init() {
        //设置处理任务的先后顺序
        Iterator<Pipe<IN, OUT>> iterator = pipes.iterator();
        Pipe<IN, OUT> prePipe = iterator.next();
        while (iterator.hasNext()) {
            Pipe<IN, OUT> nextPipe = iterator.next();
            prePipe.setNextPipe(nextPipe);
            prePipe = nextPipe;
        }
    }

    public SimplePipeline<IN, OUT> addPipe(Pipe<IN, OUT> delegate, ExecutorService executorService){
        pipes.add(new ThreadPoolPipeDecorator<>(delegate, executorService));
        return this;
    }

    public void process(IN input) throws InterruptedException {
        Pipe<IN, OUT> firstPipe = pipes.peek();
        if (firstPipe != null) {
            firstPipe.process(input);
        }
    }

}
