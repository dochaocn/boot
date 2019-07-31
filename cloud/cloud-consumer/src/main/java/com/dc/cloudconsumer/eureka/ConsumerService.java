package com.dc.cloudconsumer.eureka;

import com.dc.api.support.CloudComponent;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

@Slf4j
@CloudComponent(mapping = "/consumer")
public class ConsumerService {

    @Resource
    private FeignService feignService;

    @RequestMapping(value = "/getString")
    public String getString(){
        log.info("consumerService");
        return "i am a consumer";
    }

    @RequestMapping(value = "/feign")
    @HystrixCommand(fallbackMethod = "errorFallBack")
    public String feign(){
        log.info("feign");
        return feignService.getString();
    }

    @RequestMapping(value = "/fall")
    @HystrixCommand(fallbackMethod = "errorFallBack")
    public String fallBack(){
        log.info("fallBack");
        return feignService.back();
    }

    public String errorFallBack(){
        log.info("errorFallBack");
        return "error";
    }

}
