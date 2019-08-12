package com.dc.thread.deadlock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeadLock {

    public static void main(String[] args) {

        // 只有一支笔和一张纸
        Object pan = new Object();
        Object paper = new Object();

        // 两个人
        String people1 = "dc";
        String people2 = "xd";

        Thread o = new Thread(new Drawing(pan, paper, people1));
        Thread a = new Thread(new Drawing(pan, paper, people2));

        o.start();
        a.start();
    }
}
