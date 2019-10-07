package com.bsb.rps.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 产品表
 * </p>
 *
 * @author Dc
 */
@Data
@Accessors(chain = true)
public class BhSysProd implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 产品号
     */
    @TableId("PROD_SUB_NO")
    private String prodSubNo;

    /**
     * 是否循环贷
     */
    @TableField("LOOP_STATUS")
    private String loopStatus;

    /**
     * 是否单笔单批
     */
    @TableField("SINGLE_STATUS")
    private String singleStatus;

    /**
     * 是否报送
     */
    @TableField("REPORT_STATUS")
    private String reportStatus;

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
