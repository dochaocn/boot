package com.dc.cloudproduct.eureka;

import com.dc.api.support.CloudComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@CloudComponent(mapping = "/provider")
public class ProviderService {

    @RequestMapping(value = "/getString")
    public String getString() {
        log.info("providerService");
        return "i am a provider";
    }

    @RequestMapping(value = "/back")
    public String back(){
        log.info("back");
        int i = 1 / 0;
        return "i am a provider";
    }
}
