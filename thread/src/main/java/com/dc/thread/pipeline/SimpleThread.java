package com.dc.thread.pipeline;

import java.time.Duration;
import java.time.Instant;

public class SimpleThread {

    public static void main(String[] args) {
        Instant start = Instant.now();
        for (int i = 0; i < 100000; i++) {
            System.out.println("ttttt"+"aaaaaa"+"sssss"+i);
        }
        System.out.println(Duration.between(start, Instant.now()).toMillis());
    }
}
