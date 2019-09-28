package com.bsb.rps.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 任务步骤表
 * </p>
 *
 * @author Dc
 */
@Data
@Accessors(chain = true)
public class BhLogTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("TASK_ID")
    private String taskId;

    /**
     * 任务日期
     */
    @TableField("TASK_DATE")
    private String taskDate;

    /**
     * 任务步骤名
     */
    @TableField("TASK_NAME")
    private String taskName;

    /**
     * 任务状态
     */
    @TableField("TASK_STATUS")
    private String taskStatus;

    /**
     * 任务耗时
     */
    @TableField("TASK_TIME")
    private String taskTime;

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
