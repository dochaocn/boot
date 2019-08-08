package com.dc.cloudconsumer.eureka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "${feign.server.name1}")
public interface FeignServiceOther {

    @GetMapping("/provider/getString")
    String getString();

    @GetMapping("/provider/back")
    String back();
}
