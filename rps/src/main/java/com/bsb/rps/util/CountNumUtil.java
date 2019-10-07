package com.bsb.rps.util;

import java.util.concurrent.atomic.AtomicInteger;

public class CountNumUtil {

    private static final AtomicInteger productCount = new AtomicInteger(0);

    private static final AtomicInteger consumeCount = new AtomicInteger(0);

    public static void init() {
        productCount.set(0);
        consumeCount.set(0);
    }

    public static void addProductCount(Integer size) {
        productCount.addAndGet(size);
    }

    public static void incrementConsumeCount() {
        consumeCount.getAndIncrement();
    }

    public static boolean equals() {
        return productCount.get() == consumeCount.get();
    }
}
