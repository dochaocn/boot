package com.dc.product.support;

import cn.hutool.core.date.DateUtil;

import java.util.Random;

public class IdSingleton {

    private static Random random;

    static {
        random = new Random();
    }

    public static Integer getIntegerId() {
        return Integer.parseInt(DateUtil.thisMillsecond()
                + String.valueOf(random.nextInt()).substring(2, 6));
    }
}
