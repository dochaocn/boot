package com.dc.cloudconsumer.eureka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("client-2")
public interface FeignService {

    @GetMapping("/getString")
    String getString();
}
