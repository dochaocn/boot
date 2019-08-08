package com.dc.cloudconsumer.eureka;

import com.dc.cloudconsumer.feign.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  Feign 使用接口定义调用
 *  FeignClient 注解指定 服务名
 *  Mapping 注解指定 REST api  GET请求
 *  方法名与具体调用方法无关联

 * FeignClient注解,configuration属性默认使用 FeignClientsConfiguration
 *  FeignClientsConfiguration 包含bean
 *      Decoder     解码器 ResponseEntityDecoder
 *      Encoder     编码器 SpringEncoder
 *      Contract    契约  SpringMvcContract
 *      logger      日志  Slf4jLogger
 * 注解的configuration属性只对当前类生效,对应Configuration类不要放到包扫描下,否则为全局生效
 */
@FeignClient(value = "${feign.server.name}",configuration = FeignConfiguration.class)
public interface FeignService {

    @GetMapping("/provider/getString")
    String getString();

    @GetMapping("/provider/back")
    String back();

}
