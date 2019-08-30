package com.dc.thread.pipeline;

import com.dc.thread.pipeline.terminatable.AbstractTerminationThread;
import com.dc.thread.pipeline.terminatable.TerminationToken;
import com.dc.thread.pipeline.tools.PipeContext;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 基于工作者线程的Pipe实现类
 * 提交到该Pipe的任务由指定个数的工作者线程共同处理
 * @author huzhiqiang
 *
 * @param <IN>
 * @param <OUT>
 */
public class WorkThreadPipeDecorator<IN, OUT> implements Pipe<IN, OUT> {
    protected final BlockingQueue<IN> workQueue;
    protected final Set<AbstractTerminationThread> workerThreads = new HashSet<>();
    protected final TerminationToken terminationToken = new TerminationToken();

    private final Pipe<IN, OUT> delegate;

    public WorkThreadPipeDecorator(Pipe<IN, OUT> delegate, int workerCount){
        this(new SynchronousQueue<IN>(), delegate, workerCount);
    }

    public WorkThreadPipeDecorator(BlockingQueue<IN> workQueue, Pipe<IN, OUT> delegate, int workerCount) {
        if(workerCount <= 0){
            throw new IllegalArgumentException("workerCount should be positive!");
        }

        this.workQueue = workQueue;
        this.delegate = delegate;
        for(int i=0; i<workerCount; i++){
            workerThreads.add(new AbstractTerminationThread() {

                @Override
                protected void doRun() throws Exception {
                    try {
                        dispatch();
                    }finally {
                        terminationToken.reservations.decrementAndGet();
                    }
                }
            });
        }
    }

    private void dispatch() throws InterruptedException {
        IN input = workQueue.take();
        delegate.process(input);
    }

    @Override
    public void setNextPipe(Pipe<?, ?> nextPipe) {
        delegate.setNextPipe(nextPipe);
    }

    @Override
    public void process(IN input) throws InterruptedException {
        workQueue.put(input);
        terminationToken.reservations.incrementAndGet();
    }

    @Override
    public void init(PipeContext pipeCtx) {
        delegate.init(pipeCtx);
        for(AbstractTerminationThread thread : workerThreads){
            thread.start();
        }
    }

    @Override
    public void shutdown(long timeout, TimeUnit unit) {
        for(AbstractTerminationThread thread : workerThreads){
            thread.terminate();
            try {
                thread.join(TimeUnit.MILLISECONDS.convert(timeout, unit));
            } catch (InterruptedException e) {
            }
        }
        delegate.shutdown(timeout, unit);
    }

}