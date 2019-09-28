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
public class BhReportLoan implements Serializable {

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
     * 贷款编号
     */
    @TableField("BILLING_ID")
    private String billingId;

    /**
     * 原贷款编号
     */
    @TableField("ORIGINAL_LOAN_ID")
    private String originalLoanId;

    /**
     * 循环贷款账户编号
     */
    @TableField("CREDIT_ACCNT_ID")
    private String creditAccntId;

    /**
     * 贷款担保类型
     */
    @TableField("GUARANTEE_TYPE")
    private String guaranteeType;

    /**
     * 贷款用途
     */
    @TableField("LOAN_PURPOSE")
    private String loanPurpose;

    /**
     * 贷款申请时间
     */
    @TableField("APPLY_DATE")
    private String applyDate;

    /**
     * 账户开立时间
     */
    @TableField("BILLING_ISSUE_DATE")
    private String billingIssueDate;

    /**
     * 贷款放款时间
     */
    @TableField("ISSUE_DATE")
    private String issueDate;

    /**
     * 贷款到期日期
     */
    @TableField("DUE_DATE")
    private String dueDate;

    /**
     * 贷款金额
     */
    @TableField("BILLING_AMOUNT")
    private BigDecimal billingAmount;

    /**
     * 还款总期数
     */
    @TableField("TOTAL_TERM")
    private String totalTerm;

    /**
     * 账单日类型
     */
    @TableField("TARGET_REPAY_DATE_TYPE")
    private Integer targetRepayDateType;

    /**
     * 每期还款周期
     */
    @TableField("TERM_PERIOD")
    private Integer termPeriod;

    /**
     * 还款日列表
     */
    @TableField("TARGET_REPAY_DATE_LIST")
    private String targetRepayDateList;

    /**
     * 首次还款日
     */
    @TableField("FIRST_REPAYMENT_DATE")
    private String firstRepaymentDate;

    /**
     * 逾期宽限期
     */
    @TableField("GRACE_PERIOD")
    private Integer gracePeriod;

    /**
     * 加工日期
     */
    @TableField("PROCESS_DATE")
    private String processDate;

    /**
     * 上报类型(D2,CL1)
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
