package com.dc.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RequestController {

    @GetMapping("/get")
    public String getString() {
        log.info("----------");
        return "hello word";
    }

}
