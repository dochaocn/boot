package com.dc.thread.countdown;

import java.util.concurrent.CountDownLatch;

public class TaskJob implements Runnable {

    private int jobId;
    private CountDownLatch countDownLatch;

    public TaskJob(int jobId, CountDownLatch countDownLatch) {
        this.jobId = jobId;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
            System.out.println("任务" + jobId + "-已完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}
