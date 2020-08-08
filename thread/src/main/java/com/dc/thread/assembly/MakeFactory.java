package com.dc.thread.assembly;

/**
 * 流水线工作
 *  每一个线程只专注于做一件事或只加工一步，节约时间
 */

public class MakeFactory {

    public static void main(String[] args) {

        MakeResult result = new MakeResult();
        MakeStep3 make3 = new MakeStep3(result);
        MakeStep2 make2 = new MakeStep2(make3);
        MakeStep1 make1 = new MakeStep1(make2);

        new Thread(make1).start();
        new Thread(make2).start();
        new Thread(make3).start();
        new Thread(result).start();

    }
}
