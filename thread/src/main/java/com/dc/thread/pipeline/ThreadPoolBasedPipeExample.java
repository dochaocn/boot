package com.dc.thread.pipeline;

import com.dc.thread.pipeline.tools.PipeContext;
import com.dc.thread.pipeline.tools.PipeException;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试代码
 * @author huzhiqiang
 *
 */
public class ThreadPoolBasedPipeExample {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors()*2);
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                Runtime.getRuntime().availableProcessors()*2,
                60, TimeUnit.MINUTES,
                new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());

        Instant start = Instant.now();

        final SimplePipeline<Object, Object> pipeLine = new SimplePipeline<>();

        Pipe<String, String> pipe1 = new AbstractPipe<String, String>() {
            @Override
            public String doProcess(String input) throws PipeException {
                String result = input + "->[pipe1, " + Thread.currentThread().getName() + "]";
                System.out.println(result);
                return result;
            }
        };


        Pipe<String, String> pipe2 = new AbstractPipe<String, String>() {
            @Override
            public String doProcess(String input) throws PipeException {
                String result = input + "->[pipe2, " + Thread.currentThread().getName() + "]";
                System.out.println(result);
                return result;
            }
        };

        Pipe<String, String> pipe3 = new AbstractPipe<String, String>() {
            @Override
            public String doProcess(String input) throws PipeException {
                String result = input + "->[pipe3, " + Thread.currentThread().getName() + "]";
                System.out.println(result);
                return result;
            }

            @Override
            public void shutdown(long timeout, TimeUnit unit) {
                threadPoolExecutor.shutdown();

                try {
                    threadPoolExecutor.awaitTermination(timeout, unit);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        pipeLine.addAsThreadBasedPipe(pipe1, threadPoolExecutor);
        pipeLine.addAsThreadBasedPipe(pipe2, threadPoolExecutor);
        pipeLine.addAsThreadBasedPipe(pipe3, threadPoolExecutor);

        pipeLine.init(PipeContext.newDefaultPipeContext());

        int N = 100000;

        try {
            for(int i = 0; i < N; i++){
                pipeLine.process("Task-" + i);
            }
        } catch (InterruptedException e) {
            PipeContext.handleError(e);

        }

        System.out.println(Duration.between(start, Instant.now()).toMillis());

        pipeLine.shutdown(3, TimeUnit.SECONDS);
    }
}