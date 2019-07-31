package com.dc.cloudproduct.eureka;

import com.dc.api.support.CloudComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Slf4j
@CloudComponent(mapping = "/provider")
public class ProviderService {

    @Resource
    private Registration registration;
    
    @RequestMapping(value = "/getString")
    public String getString() {
        log.info("providerService");
        log.info("getString,port={}",registration.getPort());
        return "i am a provider";
    }

    @RequestMapping(value = "/back")
    public String back(){
        log.info("back");
        int i = 1 / 0;
        return "i am a provider";
    }
}
