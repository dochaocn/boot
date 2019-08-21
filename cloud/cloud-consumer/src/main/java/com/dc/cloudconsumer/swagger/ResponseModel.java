package com.dc.cloudconsumer.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value="基础返回类")
public class ResponseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "状态")
    private String code;
    @ApiModelProperty(value = "信息")
    private String msg;
}
