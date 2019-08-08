package com.dc.thread.cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierMain {

    public static void main(String[] args) {
        int size = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(size, new BarrierRun());
        List<Thread> soldier = new ArrayList<>(size);
        for (int s = 0; s < size; s++) {
            soldier.add(new Thread(new Soldier(s, cyclicBarrier)));
        }
        soldier.forEach(Thread::start);
    }
}
