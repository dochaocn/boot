package com.bsb.rps.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 反馈错误信息表
 * </p>
 *
 * @author Dc
 */
@Data
@Accessors(chain = true)
public class BhLogError implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 记录唯一标识
     */
    @TableId("REQ_ID")
    private String reqId;

    /**
     * 错误类型
     */
    @TableField("ERROR_TYPE")
    private String errorType;

    /**
     * 错误信息代码
     */
    @TableField("ERROR_CODE")
    private String errorCode;

    /**
     * 错误信息描述
     */
    @TableField("ERROR_DESC")
    private String errorDesc;

    /**
     * 创建时间
     */
    @TableField("BD_CREATE_DATETIME")
    private Date bdCreateDatetime;

    /**
     * 更新时间
     */
    @TableField("BD_UPDATE_DATETIME")
    private Date bdUpdateDatetime;

    /**
     * 创建人
     */
    @TableField("CREATE_USER")
    private String createUser;

    /**
     * 更新人
     */
    @TableField("UPDATE_USER")
    private String updateUser;


}
