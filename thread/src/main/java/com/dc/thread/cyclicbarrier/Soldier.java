package com.dc.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Soldier implements Runnable {

    private int name;
    private CyclicBarrier cyclicBarrier;

    public Soldier(int name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
            this.dropDown();
            cyclicBarrier.await();
            this.job();
            cyclicBarrier.await();
            this.gather();
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void dropDown() throws InterruptedException {
        Thread.sleep(1000L);
        System.out.println("士兵"+name+"-已成功降落");
    }

    private void job() throws InterruptedException {
        Thread.sleep(2000L);
        System.out.println("士兵"+name+"-已完成任务");
    }

    private void gather() throws InterruptedException {
        Thread.sleep(1000L);
        System.out.println("士兵"+name+"-已到达集合地点");
    }

}
