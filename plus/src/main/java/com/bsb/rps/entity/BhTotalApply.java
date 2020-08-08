package com.bsb.rps.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 信贷业务申请全量表
 * </p>
 *
 * @author Dc
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BhTotalApply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 信贷业务申请编号
     */
    @TableId("APPLY_ID")
    private String applyId;

    /**
     * 信贷业务申请时间
     */
    @TableField("APPLY_DATE")
    private LocalDateTime applyDate;

    /**
     * 信贷业务申请类型
     */
    @TableField("APPLY_TYPE")
    private Integer applyType;

    /**
     * 姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 证件类型
     */
    @TableField("ID_TYPE")
    private Integer idType;

    /**
     * 证件号码
     */
    @TableField("PID")
    private String pid;

    /**
     * 手机
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 电子邮箱
     */
    @TableField("EMAIL_ADDRESS")
    private String emailAddress;

    /**
     * 学历
     */
    @TableField("EDU_BACKGROUND")
    private Integer eduBackground;

    /**
     * 学位
     */
    @TableField("DEGREE")
    private Integer degree;

    /**
     * 信贷业务担保类型
     */
    @TableField("GUARANTEE_TYPE")
    private Integer guaranteeType;

    /**
     * 贷款用途
     */
    @TableField("LOAN_PURPOSE")
    private Integer loanPurpose;

    /**
     * 客户类型
     */
    @TableField("CUSTOM_TYPE")
    private Integer customType;

    /**
     * 申请贷款金额
     */
    @TableField("APPLY_AMOUNT")
    private BigDecimal applyAmount;

    /**
     * 居住地地址
     */
    @TableField("HOME_ADDRESS")
    private String homeAddress;

    /**
     * 住宅电话
     */
    @TableField("HOME_PHONE")
    private String homePhone;

    /**
     * 工作单位名称
     */
    @TableField("WORK_NAME")
    private String workName;

    /**
     * 工作单位地址
     */
    @TableField("WORK_ADDRESS")
    private String workAddress;

    /**
     * 工作单位电话
     */
    @TableField("WORK_PHONE")
    private String workPhone;

    /**
     * 户籍地址
     */
    @TableField("ID_ADDRESS")
    private String idAddress;

    /**
     * 通讯地址
     */
    @TableField("MAIL_ADDRESS")
    private String mailAddress;

    /**
     * 居住状况
     */
    @TableField("LIVING_CONDITION")
    private Integer livingCondition;

    /**
     * 婚姻状况
     */
    @TableField("MARRIAGE_STATUS")
    private Integer marriageStatus;

    /**
     * 配偶姓名
     */
    @TableField("SPOUSE_NAME")
    private String spouseName;

    /**
     * 配偶证件类型
     */
    @TableField("SPOUSE_ID_TYPE")
    private Integer spouseIdType;

    /**
     * 配偶证件号码
     */
    @TableField("SPOUSE_PID")
    private String spousePid;

    /**
     * 配偶手机号码
     */
    @TableField("SPOUSE_MOBILE")
    private String spouseMobile;

    /**
     * 配偶工作单位名称
     */
    @TableField("SPOUSE_WORK_NAME")
    private String spouseWorkName;

    /**
     * 第一联系人姓名
     */
    @TableField("FIRST_CONTACTS_NAME")
    private String firstContactsName;

    /**
     * 第一联系人与申请人关系
     */
    @TableField("FIRST_CONTACTS_RELATIONSHIP")
    private Integer firstContactsRelationship;

    /**
     * 第一联系人证件类型
     */
    @TableField("FIRST_CONTACTS_ID_TYPE")
    private Integer firstContactsIdType;

    /**
     * 第一联系人证件号码
     */
    @TableField("FIRST_CONTACTS_PID")
    private String firstContactsPid;

    /**
     * 第一联系人手机号码
     */
    @TableField("FIRST_CONTACTS_MOBILE")
    private String firstContactsMobile;

    /**
     * 第一联系人固定电话
     */
    @TableField("FIRST_CONTACTS_TELEPHONE")
    private String firstContactsTelephone;

    /**
     * 第一联系人工作单位名称
     */
    @TableField("FIRST_CONTACTS_WORK_NAME")
    private String firstContactsWorkName;

    /**
     * 第二联系人姓名
     */
    @TableField("SECOND_CONTACTS_NAME")
    private String secondContactsName;

    /**
     * 第二联系人与申请人关系
     */
    @TableField("SECOND_CONTACTS_RELATIONSHIP")
    private Integer secondContactsRelationship;

    /**
     * 第二联系人证件类型
     */
    @TableField("SECOND_CONTACTS_ID_TYPE")
    private Integer secondContactsIdType;

    /**
     * 第二联系人证件号码
     */
    @TableField("SECOND_CONTACTS_PID")
    private String secondContactsPid;

    /**
     * 第二联系人手机号码
     */
    @TableField("SECOND_CONTACTS_MOBILE")
    private String secondContactsMobile;

    /**
     * 第二联系人固定电话
     */
    @TableField("SECOND_CONTACTS_TELEPHONE")
    private String secondContactsTelephone;

    /**
     * 第二联系人工作单位名称
     */
    @TableField("SECOND_CONTACTS_WORK_NAME")
    private String secondContactsWorkName;

    /**
     * 推送日期
     */
    @TableField("INPUT_DATE")
    private String inputDate;

    /**
     * 创建时间
     */
    @TableField("BD_CREATE_DATETIME")
    private LocalDateTime bdCreateDatetime;

    /**
     * 更新时间
     */
    @TableField("BD_UPDATE_DATETIME")
    private LocalDateTime bdUpdateDatetime;

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
