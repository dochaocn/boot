package com.bsb.rps.manager;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CountDownManager {

    private static CountDownLatch countDownLatch;

    public static void resetCountDownLatch(int count) {
        CountDownManager.countDownLatch = new CountDownLatch(count);
    }

    public static boolean await(long timeout, TimeUnit timeUnit) {
        try {
            return countDownLatch.await(timeout, timeUnit);
        } catch (InterruptedException e) {
            log.error("CountDownManager await.", e);
        }
        return false;
    }

    public static void await() {
        try {
            CountDownManager.countDownLatch.await();
        } catch (InterruptedException e) {
            log.error("CountDownManager await.", e);
        }
    }

    public static void countDown() {
        CountDownManager.countDownLatch.countDown();
    }

}
