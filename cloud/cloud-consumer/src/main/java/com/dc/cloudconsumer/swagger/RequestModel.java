package com.dc.cloudconsumer.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel
public class RequestModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字符串",name = "str")
    private String strDemo;

    @ApiModelProperty(value="long型值",required = true)
    private Long longNum;

    @ApiModelProperty(value="double值")
    private Double doubleNum;

    @ApiModelProperty(value="2018-12-04T13:46:56.711Z")
    private Date date;

}