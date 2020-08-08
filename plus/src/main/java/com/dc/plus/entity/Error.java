package com.dc.plus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Error implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("REQ_ID")
    private String req;

    @ApiModelProperty(value = "错误类型")
    @TableField("ERROR_TYPE")
    private String type;

    @ApiModelProperty(value = "错误信息代码")
//    @TableField("ERROR_CODE")
    private String errorCode;

}
