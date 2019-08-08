package com.dc.thread.cyclicbarrier;

public class BarrierRun implements Runnable {

    private static int time;

    @Override
    public void run() {
        if (time == 0){
            System.out.println("任务开始，跳伞！");
        }else if (time == 1){
            System.out.println();
            System.out.println("所有士兵降落完毕，行动！");
        }else if (time == 2){
            System.out.println();
            System.out.println("任务完成,立即返回集合地点");
        }else if (time == 3){
            System.out.println();
            System.out.println("安全撤退！拜拜！");
        }
        time++;
    }

}
