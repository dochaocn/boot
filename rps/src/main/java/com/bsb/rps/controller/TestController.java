package com.bsb.rps.controller;

import com.bsb.rps.handler.disruptor.MainDisruptor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private MainDisruptor mainDisruptor;

    @RequestMapping("/p")
    public Object test1() {
        mainDisruptor.test();
        return "null";
    }
}
