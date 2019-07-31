package com.dc.cloudconsumer.config;

import com.dc.api.support.CloudComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;

@RefreshScope
@CloudComponent(mapping = "config")
public class CloudConfig {

    @Value("${feign.server.name}")
    private String feignServerName;

    @GetMapping("/from")
    public String returnFormValue(){
        return feignServerName;
    }

}
