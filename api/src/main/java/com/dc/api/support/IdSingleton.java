package com.dc.api.support;

import java.util.Random;

public class IdSingleton {

    private static Random random;

    static {
        random = new Random();
    }

    public static Integer getIntegerId() {
        return Integer.parseInt(
                String.valueOf(System.currentTimeMillis()).substring(0,5)
                + String.valueOf(random.nextInt()).substring(1, 5));
    }
}
