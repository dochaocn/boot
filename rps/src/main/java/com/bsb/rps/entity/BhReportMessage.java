package com.bsb.rps.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 上报信息记录表
 * </p>
 *
 * @author Dc
 */
@Data
@Accessors(chain = true)
public class BhReportMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("REPORT_ID")
    private String reportId;

    /**
     * 报送数据日期
     */
    @TableField("REPORT_DATE")
    private String reportDate;

    /**
     * 报送文件名
     */
    @TableField("REPORT_FILE_NAME")
    private String reportFileName;

    /**
     * 报送条数
     */
    @TableField("REPORT_TOTAL_NUM")
    private Integer reportTotalNum;

    /**
     * 报送正确条数
     */
    @TableField("REPORT_NORMAL_NUM")
    private Integer reportNormalNum;

    /**
     * 报送错误条数
     */
    @TableField("REPORT_ERROR_NUM")
    private Integer reportErrorNum;

    /**
     * 本次报送状态
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
