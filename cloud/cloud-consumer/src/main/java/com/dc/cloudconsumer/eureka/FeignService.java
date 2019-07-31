package com.dc.cloudconsumer.eureka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  Feign 使用接口定义调用
 *  FeignClient 注解指定 服务名
 *  Mapping 注解指定 REST api  GET请求
 *  方法名与具体调用方法无关联
 */

@FeignClient(value = "${feign.server.name}")
public interface FeignService {

    @GetMapping("/provider/getString")
    String getString();

    @GetMapping("/provider/back")
    String back();

}
