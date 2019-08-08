package com.dc.cloudservice.service;

import com.dc.api.support.CloudComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@CloudComponent(mapping = "/provider")
public class ProviderService {

    @RequestMapping(value = "/getString")
    public String getString() {
        log.info("i am a service");
        return "i am a service";
    }

    @RequestMapping(value = "/back")
    public String back(){
        log.info("back");
        return "i am a service";
    }
}
