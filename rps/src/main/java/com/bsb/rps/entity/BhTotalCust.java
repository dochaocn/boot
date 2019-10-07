package com.bsb.rps.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 个人信息全量表
 * </p>
 *
 * @author Dc
 */
@Data
@Accessors(chain = true)
public class BhTotalCust implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户号
     */
    @TableId("CUST_NO")
    private String custNo;

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
     * 手机号
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 推送日期
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
