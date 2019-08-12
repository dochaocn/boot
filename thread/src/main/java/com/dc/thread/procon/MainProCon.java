package com.dc.thread.procon;

import java.util.*;

public class MainProCon {

    private static List<Message> list = Collections.synchronizedList(new LinkedList<>());
    private static List<Message> list1 = new Vector<>();
    private static List<Message> list2 = new ArrayList<>();
    private static List<Message> list3 = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t;
        for (int i = 0; i < 5; i++) {
            t = new Thread(new Provider(list));
            t.setName("Thread: provider " + i);
            t.start();
        }
        for (int i = 0; i < 2; i++) {
            t = new Thread(new Consumer(list));
            t.setName("Thread: consumer " + i);
            t.start();
        }
    }
}
