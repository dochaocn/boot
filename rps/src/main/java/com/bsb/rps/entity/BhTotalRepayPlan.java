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
 * 
 * </p>
 *
 * @author Dc
 */
@Data
@Accessors(chain = true)
public class BhTotalRepayPlan implements Serializable {

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
     * 应还款日
     */
    @TableField("TARGET_REPAYMENT_DATE")
    private String targetRepaymentDate;

    /**
     * 宽限期日
     */
    @TableField("PERIOD_DATE")
    private String periodDate;

    /**
     * 应还本金
     */
    @TableField("REPAYMENT_AMT")
    private BigDecimal repaymentAmt;

    /**
     * 应还利息
     */
    @TableField("REPAYMENT_INTEREST")
    private BigDecimal repaymentInterest;

    /**
     * 应还罚息
     */
    @TableField("REPAYMENT_DUE_INTEREST")
    private BigDecimal repaymentDueInterest;

    /**
     * 是否结清
     */
    @TableField("PAY_OFF_FLAG")
    private String payOffFlag;

    /**
     * 推送时间
     */
    @TableField("INPUT_DATE")
    private String inputDate;

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
