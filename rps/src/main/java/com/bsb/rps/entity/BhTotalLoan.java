package com.bsb.rps.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 借据信息全量表
 * </p>
 *
 * @author Dc
 */
@Data
@Accessors(chain = true)
public class BhTotalLoan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 贷款编号
     */
    @TableId("ORDER_NO")
    private String orderNo;

    /**
     * 循环贷款账户编号
     */
    @TableField("CREDIT_ACCNT_ID")
    private String creditAccntId;

    /**
     * 产品号
     */
    @TableField("PROD_SUB_NO")
    private String prodSubNo;

    /**
     * 申请时间
     */
    @TableField("APPLY_DATE")
    private String applyDate;

    /**
     * 开立时间
     */
    @TableField("OPEN_DATE")
    private String openDate;

    /**
     * 贷款用途
     */
    @TableField("LOAN_PURPOSE")
    private String loanPurpose;

    /**
     * 贷款金额
     */
    @TableField("TRANS_AMOUNT")
    private BigDecimal transAmount;

    /**
     * 还款总期数
     */
    @TableField("TOTAL_TERM")
    private Integer totalTerm;

    /**
     * 逾期宽限期
     */
    @TableField("GRACE_PERIOD")
    private Integer gracePeriod;

    /**
     * 还款计划变更标识
     */
    @TableField("CHANGE_FLAG")
    private String changeFlag;

    /**
     * 客户号
     */
    @TableField("CUST_NO")
    private String custNo;

    /**
     * 推送日期
     */
    @TableField("INPUT_DATE")
    private String inputDate;

    /**
     * 处理状态
     */
    @TableField("PROCESS_STATUS")
    private String processStatus;

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
