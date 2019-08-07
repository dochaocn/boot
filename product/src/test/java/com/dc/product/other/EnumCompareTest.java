package com.dc.product.other;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnumCompareTest {

    public static void main(String[] args) {

        int i = CompareEnum.ONE.compareTo(CompareEnum.TWO);
        int ordinal = CompareEnum.THR.ordinal();
        String name = CompareEnum.THR.name();
        System.out.println(i);
        System.out.println("THR ordinal: " + ordinal + " name: " + name);

    }
}
