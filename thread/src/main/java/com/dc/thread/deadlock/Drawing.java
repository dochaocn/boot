package com.dc.thread.deadlock;

import lombok.Data;

@Data
public class Drawing implements Runnable{

    private Object pan;
    private Object paper;
    private String people;

    public Drawing(Object pan, Object paper, String people) {
        this.pan = pan;
        this.paper = paper;
        this.people = people;
    }

    @Override
    public void run() {

        if (people.equals("dc")) {
            try {
                // 先拿笔，后拿纸
                synchronized (pan){
                    System.out.println(this.people + "已获得笔");
                    Thread.sleep(1000L);
                    synchronized (paper){
                        System.out.println(this.people + "已获得纸");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (people.equals("xd")) {
            try {
                // 先拿纸，后拿笔
                synchronized (paper){
                    System.out.println(this.people + "已获得纸");
                    Thread.sleep(1000L);
                    synchronized (pan){
                        System.out.println(this.people + "已获得笔");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 都获取不到想要的资源，死锁.
        draw();
    }

    private void draw() {
        System.out.println(this.people + "开始画画......");
    }
}
