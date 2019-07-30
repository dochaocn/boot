package com.dc.cloudconsumer.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class ConsumerService {

    @Resource
    private Registration registration;
    @Resource
    private FeignService feignService;

    @RequestMapping(value = "/getString")
    public String getString(){
        log.info("consumerService");
        return "i am a consumer";
    }

    @RequestMapping(value = "/feign")
    public String feign(){
        log.info("feign,id={}",registration.getInstanceId());
        return feignService.getString();
    }

}
