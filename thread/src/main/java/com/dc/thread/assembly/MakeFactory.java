package com.dc.thread.assembly;

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
