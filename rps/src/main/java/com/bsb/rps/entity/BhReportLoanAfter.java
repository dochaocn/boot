package com.bsb.rps.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 借据信息上报报文
 * </p>
 *
 * @author Dc
 */
@Data
@Accessors(chain = true)
public class BhReportLoanAfter implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 记录唯一标识
     */
    @TableId("REQ_ID")
    private String reqId;

    /**
     * 操作代码
     */
    @TableField("OP_CODE")
    private String opCode;

    /**
     * 记录生成时间
     */
    @TableField("UPLOAD_TS")
    private String uploadTs;

    /**
     * 循环贷款账户编号
     */
    @TableField("CREDIT_ACCNT_ID")
    private String creditAccntId;

    /**
     * 贷款编号
     */
    @TableField("BILLING_ID")
    private String billingId;

    /**
     * 姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 身份证
     */
    @TableField("PID")
    private String pid;

    /**
     * 手机
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 当前还款期数
     */
    @TableField("TERM_NO")
    private String termNo;

    /**
     * 本期还款状态
     */
    @TableField("TERM_STATUS")
    private String termStatus;

    /**
     * 本期应还款日
     */
    @TableField("TARGET_REPAYMENT_DATE")
    private String targetRepaymentDate;

    /**
     * 实际还款时间
     */
    @TableField("REAL_REPAYMENT_DATE")
    private String realRepaymentDate;

    /**
     * 计划应还款金额
     */
    @TableField("PLANNED_PAYMENT")
    private BigDecimal plannedPayment;

    /**
     * 剩余应还款金额
     */
    @TableField("TARGET_REPAYMENT")
    private BigDecimal targetRepayment;

    /**
     * 本次还款金额
     */
    @TableField("REAL_REPAYMENT")
    private BigDecimal realRepayment;

    /**
     * 当前逾期天数
     */
    @TableField("OVER_DUE_STATUS")
    private String overDueStatus;

    /**
     * 本期还款状态确认时间
     */
    @TableField("STATUS_CONFIRM_AT")
    private String statusConfirmAt;

    /**
     * 当前逾期总额
     */
    @TableField("OVER_DUE_AMOUNT")
    private BigDecimal overDueAmount;

    /**
     * 当前用信总额
     */
    @TableField("CREDIT_USAGE")
    private BigDecimal creditUsage;

    /**
     * 本笔订单状态
     */
    @TableField("BILLING_STATUS")
    private String billingStatus;

    /**
     * 加工日期
     */
    @TableField("PROCESS_DATE")
    private String processDate;

    /**
     * 上报类型(D3,CL2)
     */
    @TableField("REPORT_TYPE")
    private String reportType;

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
