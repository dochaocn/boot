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
 * 还款流水全量表
 * </p>
 *
 * @author Dc
 */
@Data
@Accessors(chain = true)
public class BhTotalRepayFlow implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 贷款编号
     */
    @TableId("ORDER_NO")
    private String orderNo;

    /**
     * 期次
     */
    @TableField("TERM_NO")
    private Integer termNo;

    /**
     * 实际还款时间
     */
    @TableField("REAL_REPAYMENT_DATE")
    private String realRepaymentDate;

    /**
     * 还款确认时间
     */
    @TableField("STATUS_CONFIRM_AT")
    private String statusConfirmAt;

    /**
     * 实际还款本金
     */
    @TableField("REAL_REPAYMENT_AMT")
    private BigDecimal realRepaymentAmt;

    /**
     * 实际还款利息
     */
    @TableField("REAL_REPAYMENT_INTEREST")
    private BigDecimal realRepaymentInterest;

    /**
     * 实际还款罚息
     */
    @TableField("REAL_REPAYMENT_DUE_INTEREST")
    private BigDecimal realRepaymentDueInterest;

    /**
     * 代偿标识
     */
    @TableField("COMPENSATORY_FLAG")
    private String compensatoryFlag;

    /**
     * 推送时间
     */
    @TableField("INPUT_DATE")
    private String inputDate;

    /**
     * 加工标志
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
