package com.dc.cloudconsumer.eureka;

import com.dc.api.support.CloudComponent;
import com.dc.cloudconsumer.response.RequestModel;
import com.dc.cloudconsumer.response.ResponseDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Api
@Slf4j
@CloudComponent(mapping = "/consumer")
public class ConsumerService {

    @Resource
    private FeignService feignService;

    /**
     * swagger 注解
     * @return String
     */
    @ApiOperation(value = "服务调用", httpMethod = "POST")
    @RequestMapping(value = "/getString",method = POST)
    public ResponseDto getString(RequestModel requestModel){
        log.info("swagger");
        ResponseDto responseDto = new ResponseDto();
        responseDto.setDate(new Date());
        responseDto.setStrDemo(requestModel.getStrDemo());
        responseDto.setLongNum(requestModel.getLongNum());
        responseDto.setDoubleNum(requestModel.getDoubleNum());
        responseDto.setCode("200");
        responseDto.setMsg("success");
        log.info(responseDto.toString());
        return responseDto;
    }

    @RequestMapping(value = "/feign",method = POST)
    @HystrixCommand(fallbackMethod = "errorFallBack")
    public String feign(){
        log.info("feign");
        return feignService.getString();
    }

    @RequestMapping(value = "/fall",method = POST)
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

    @RequestMapping(value = "/feign1",method = POST)
    @HystrixCommand(fallbackMethod = "errorFallBack")
    public String feign1(){
        log.info("feign1");
        return feignServiceOther.getString();
    }
}
