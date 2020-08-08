package com.dc.cloudconsumer.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.io.Serializable;

@Getter
@ApiModel(value="基础返回类")
public class ResponseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "状态")
    private String code;
    @ApiModelProperty(value = "信息")
    private String msg;
    @ApiModelProperty(value = "数据对象")
    private Object data;

    public ResponseModel setCode(String code) {
        this.code = code;
        return this;
    }
    public ResponseModel setMsg(String msg) {
        this.msg = msg;
        return this;
    }
    public ResponseModel setData(Object data) {
        this.data = data;
        return this;
    }

}
