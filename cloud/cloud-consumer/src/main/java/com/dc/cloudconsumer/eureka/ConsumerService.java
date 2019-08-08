package com.dc.cloudconsumer.eureka;

import com.dc.api.support.CloudComponent;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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

    /**
     * 服务降级，熔断，回调方法
     */
    public String errorFallBack(){
        log.info("errorFallBack");
        return "error";
    }

    /**
     * 为测试@FeignClient中configuration属性
     */
    @Resource
    private FeignServiceOther feignServiceOther;

    @RequestMapping(value = "/feign1")
    @HystrixCommand(fallbackMethod = "errorFallBack")
    public String feign1(){
        log.info("feign1");
        return feignServiceOther.getString();
    }
}
