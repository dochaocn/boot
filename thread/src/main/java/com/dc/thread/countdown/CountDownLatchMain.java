package com.dc.thread.countdown;

import java.util.concurrent.*;

public class CountDownLatchMain {

    public static void main(String[] args) throws InterruptedException {
        int size = 5;
        CountDownLatch countDownLatch = new CountDownLatch(size);
        ExecutorService service = Executors.newFixedThreadPool(size);
        for (int i = 0; i < size; i++) {
            // 传统写法，需TaskJob类
            service.execute(new TaskJob(i, countDownLatch));

            int jobId = i;

            // lambda表达式写法，无需TaskJob类
            service.execute(() -> {
                try {
                    if (jobId == 2) {
                        int o = jobId/0;
                    }
                    Thread.sleep(1000L);
                    System.out.println("任务" + jobId + "-已完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });

            /*
             * submit 与 execute
             * 1、接受的参数（任务类型）不一样  Runnable,Callable
             * 2、返回值 Runnable(无返回值) 与 Callable(有返回值)
             * 3、异常  若不对返回值做处理,会吃掉异常,  submit可以通过get方法获取方便处理异常
             */
            Future<String> callable = service.submit(() -> {
                try {
                    if (jobId == 2) {
                        int o = jobId/0;
                    }
                    Thread.sleep(1000L);
                    System.out.println("任务" + jobId + "-已完成");
                    countDownLatch.countDown();
                    return "success";
                } catch (InterruptedException e) {
                    throw e;
                }
            });

            try {
                System.out.println(callable.get());
            } catch (ExecutionException e) {
                service.shutdown(); // 只要有一个线程异常,则不再继续往下执行,所有未执行的线程退出
                e.printStackTrace();
            }

        }
        countDownLatch.await();
        System.out.println("所有任务都已完成");
        service.shutdown();
    }
}
