package com.dc.cloudconsumer.eureka;

import com.dc.api.support.CloudComponent;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api
@Slf4j
@CloudComponent(mapping = "/other")
public class OtherService {

    @ApiOperation(value = "服务调用", httpMethod = "POST")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "msg", value = "消息", dataTypeClass = String.class),
//            @ApiImplicitParam(name = "code", value = "状态码", dataTypeClass = Integer.class)
//    })
    @RequestMapping(value = "/getString",method = RequestMethod.POST)
    public String getString(@ApiParam String msg, @ApiParam Integer code){
        log.info(msg + code);
        return msg + code;
    }
}
