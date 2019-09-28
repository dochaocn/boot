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
 * 授信信息上报报文
 * </p>
 *
 * @author Dc
 */
@Data
@Accessors(chain = true)
public class BhReportCredit implements Serializable {

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
     * 授信账户操作代码
     */
    @TableField("ACCOUNT_ACTION")
    private String accountAction;

    /**
     * 循环贷款账户编号
     */
    @TableField("CREDIT_ACCNT_ID")
    private String creditAccntId;

    /**
     * 授信担保类型
     */
    @TableField("GUARANTEE_TYPE")
    private String guaranteeType;

    /**
     * 授信申请时间
     */
    @TableField("APPLY_DATE")
    private String applyDate;

    /**
     * 授信账户开立时间
     */
    @TableField("ACCOUNT_OPEN_DATE")
    private String accountOpenDate;

    /**
     * 授信到期日
     */
    @TableField("ACCOUNT_EXPIRE_DATE")
    private String accountExpireDate;

    /**
     * 授信额度
     */
    @TableField("CREDIT_LIMIT")
    private BigDecimal creditLimit;

    /**
     * 授信账户状态
     */
    @TableField("CREDIT_ACCNT_STATUS")
    private String creditAccntStatus;

    /**
     * 固定账单日
     */
    @TableField("ACCNT_BILLING_DATE")
    private Integer accntBillingDate;

    /**
     * 固定还款日
     */
    @TableField("ACCNT_BILLING_DUE_DATE")
    private Integer accntBillingDueDate;

    /**
     * 逾期宽限期
     */
    @TableField("GRACE_PERIOD")
    private Integer gracePeriod;

    /**
     * 账户信息变动时间
     */
    @TableField("ACCOUNT_INFO_UPDATE")
    private String accountInfoUpdate;

    /**
     * 加工日期
     */
    @TableField("PROCESS_DATE")
    private String processDate;

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
