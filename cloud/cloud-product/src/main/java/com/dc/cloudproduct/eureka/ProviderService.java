package com.dc.cloudproduct.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProviderService {

    @RequestMapping(value = "/getString")
    public String getString() {
        log.info("providerService");
        return "i am a provider";
    }
}
