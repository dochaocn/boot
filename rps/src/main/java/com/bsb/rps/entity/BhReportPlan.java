package com.bsb.rps.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 上报计划表
 * </p>
 *
 * @author Dc
 */
@Data
@Accessors(chain = true)
public class BhReportPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 借据号
     */
    @TableId("ORDER_NO")
    private String orderNo;

    /**
     * 账户号
     */
    @TableField("CREDIT_ACCNT_ID")
    private String creditAccntId;

    /**
     * 客户号
     */
    @TableField("CUST_NO")
    private String custNo;

    /**
     * 产品号
     */
    @TableField("PROD_SUB_NO")
    private String prodSubNo;

    /**
     * 期限上报日
     */
    @TableField("REPORT_DATE")
    private String reportDate;

    /**
     * 上报期次
     */
    @TableField("REPORT_TERM")
    private Integer reportTerm;

    /**
     * 借据上报状态
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
