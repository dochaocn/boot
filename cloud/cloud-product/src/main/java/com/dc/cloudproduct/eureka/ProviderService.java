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
}
