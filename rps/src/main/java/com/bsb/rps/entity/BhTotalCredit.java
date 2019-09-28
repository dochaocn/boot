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
 * 授信信息全量表
 * </p>
 *
 * @author Dc
 */
@Data
@Accessors(chain = true)
public class BhTotalCredit implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 循环贷款账户编号
     */
    @TableId("CREDIT_ACCNT_ID")
    private String creditAccntId;

    /**
     * 授信申请日期
     */
    @TableField("APPLY_DATE")
    private String applyDate;

    /**
     * 授信账户开立时间
     */
    @TableField("ACCOUNT_OPEN_DATE")
    private String accountOpenDate;

    /**
     * 授信到期时间
     */
    @TableField("ACCOUNT_EXPIRE_DATE")
    private String accountExpireDate;

    /**
     * 授信额度
     */
    @TableField("CREDIT_LIMIT")
    private BigDecimal creditLimit;

    /**
     * 逾期宽限期
     */
    @TableField("GRACE_PERIOD")
    private Integer gracePeriod;

    /**
     * 信息变动日期
     */
    @TableField("ACCOUNT_INFO_UPDATE_DATE")
    private String accountInfoUpdateDate;

    /**
     * 授信账户状态
     */
    @TableField("CREDIT_ACCNT_STATUS")
    private String creditAccntStatus;

    /**
     * 客户号
     */
    @TableField("CUST_NO")
    private String custNo;

    /**
     * 推送时间
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
