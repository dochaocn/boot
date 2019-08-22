package com.dc.cloudconsumer.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value="响应对象")
public class ResponseDto extends ResponseModel {

    @ApiModelProperty(value = "字符串", dataType = "String")
    private String strDemo;

    @ApiModelProperty(value="long型值", dataType = "Long")
    private Long longNum;

    @ApiModelProperty(value="double值", dataType = "Double")
    private Double doubleNum;

    @ApiModelProperty(value="2018-12-04T13:46:56.711Z")
    private Date date;
}
