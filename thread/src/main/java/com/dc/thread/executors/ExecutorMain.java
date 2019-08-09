package com.dc.thread.executors;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Scheduled 调度
 *
 * 线程池 由 ThreadPoolExecutor类创建
 */
@Slf4j
public class ExecutorMain {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(10);

        for (int i = 0; i < 5; i++) {
            threadPool.scheduleAtFixedRate(new Thread(new ExecutorJob("scheduleAtFixedRate",i)),
                    1,1, TimeUnit.SECONDS);
            threadPool.scheduleWithFixedDelay(new Thread(new ExecutorJob("scheduleWithFixedDelay",i)),
                    1,1,TimeUnit.SECONDS);
        }

        threadPool.schedule(new Thread(new ExecutorJob("schedule")),1,TimeUnit.SECONDS);

        threadPool.schedule(() -> System.out.println("11111111111111111"),1,TimeUnit.SECONDS);

    }
}
