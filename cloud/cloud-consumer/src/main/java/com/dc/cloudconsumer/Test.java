package com.dc.cloudconsumer;

public class Test {

    public static void main(String[] args) {
        int[] a = new int[3];
        a[1] = 3;
        int[] b = a;
        b[1] = 2;
        int c = a[1]+b[1];
        for (;;){
            System.out.println(1);
        }
    }
}
