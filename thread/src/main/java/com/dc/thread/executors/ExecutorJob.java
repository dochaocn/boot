package com.dc.thread.executors;

public class ExecutorJob implements Runnable {

    private String type;
    private int num;

    public ExecutorJob() {
    }

    public ExecutorJob(String type) {
        this.type = type;
    }

    public ExecutorJob(String type, int num) {
        this.type = type;
        this.num = num;
    }

    @Override
    public void run() {
        long id = Thread.currentThread().getId();
        System.out.println("当前线程 type = " + type + "------id " + id + "------num" + num);
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
