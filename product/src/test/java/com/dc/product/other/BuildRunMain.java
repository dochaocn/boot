package com.dc.product.other;

public class BuildRunMain {

    public static void main(String[] args) {
        BuildDomain bean = new BuildDomain.Builder()
                .setName("dc")
                .setIdCard("123456")
                .setSex(true)
                .build();

        System.out.println(bean.toString());
    }
}
