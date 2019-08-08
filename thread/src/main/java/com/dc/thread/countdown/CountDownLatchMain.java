package com.dc.thread.countdown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchMain {

    public static void main(String[] args) throws InterruptedException {
        int size = 5;
        CountDownLatch countDownLatch = new CountDownLatch(size);
        ExecutorService service = Executors.newFixedThreadPool(size);
        for (int i = 0; i < size; i++) {
            // 传统写完，需TaskJob类
            new Thread(new TaskJob(i, countDownLatch)).start();
            // lambda表达式写法，无需TaskJob类
//            int jobId = i;
//            service.submit(() ->{
//                try {
//                    Thread.sleep(1000L);
//                    System.out.println("任务" + jobId + "-已完成");
//                    countDownLatch.countDown();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
        }
        countDownLatch.await();
        System.out.println("所有任务都已完成");
        service.shutdown();
    }
}
