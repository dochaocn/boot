package com.dc.cloudservice.service;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {

    public void test() {
//        TaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//        taskScheduler.scheduleAtFixedRate(() -> System.out.println("schedule"), 100L);
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
        threadPool.schedule(() -> System.out.println("111"), 1L, TimeUnit.SECONDS);
        Set<Object> set = new HashMap<>().keySet();

        new HashMap<>().entrySet();

        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        List<Map.Entry<Integer, String>> list = new ArrayList<>(entries);


        list.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        list.sort(Comparator.comparing(Map.Entry::getValue));
        list.sort(Map.Entry.comparingByValue());


    }

    static volatile int i = 2;

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                if (i == 1) {
                    i = 2;
                    System.out.println("t1...");
                }
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                if (i == 2) {
                    i = 1;
                    System.out.println("t2...");
                }
            }
        }).start();


//        new Test().test();
        while (true) {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
