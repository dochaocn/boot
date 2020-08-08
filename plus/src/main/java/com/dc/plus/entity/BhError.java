package com.dc.plus.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 反馈错误信息表
 * </p>
 *
 * @author Dc
 * @since 2019-09-26
 */
@Data
@ApiModel(value="BhError对象", description="反馈错误信息表")
public class BhError implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "记录唯一标识")
    @TableId("REQ_ID")
    private String reqId;

    @ApiModelProperty(value = "错误类型")
    @TableField("ERROR_TYPE")
    private String errorType;

    @ApiModelProperty(value = "错误信息代码")
    @TableField("ERROR_CODE")
    private String errorCode;

    @ApiModelProperty(value = "错误信息描述")
    @TableField("ERROR_DESC")
    private String errorDesc;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_DATETIME")
    private LocalDateTime createDatetime;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_DATETIME")
    private LocalDateTime updateDatetime;

    @ApiModelProperty(value = "创建人")
    @TableField("CREATE_USER")
    private String createUser;

    @ApiModelProperty(value = "更新人")
    @TableField("UPDATE_USER")
    private String updateUser;


}
