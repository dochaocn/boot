package com.bsb.rps.controller;

import com.bsb.rps.validate.ValidateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private ValidateService validateService;

    @RequestMapping("/p")
    public Object test1() {
        validateService.startValidate();
        return "null";
    }
}
