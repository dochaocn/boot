package com.bsb.rps.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bsb.rps.entity.BhLogTask;
import com.bsb.rps.enums.TaskStatus;
import com.bsb.rps.manager.ProcessDateManager;
import com.bsb.rps.mapper.BhLogTaskMapper;
import com.bsb.rps.service.IBhLogTaskService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 任务步骤表 服务实现类
 * </p>
 *
 * @author Dc
 */
@Service
public class BhLogTaskServiceImpl extends ServiceImpl<BhLogTaskMapper, BhLogTask> implements IBhLogTaskService {

    private final AtomicInteger integer = new AtomicInteger(1);

    @Override
    public BhLogTask insert(String taskName) {
        BhLogTask logTask = new BhLogTask();
        logTask.setTaskId(integer.getAndIncrement() + "");  //TODO 主键生成
        logTask.setTaskStatus(TaskStatus.RUNNING.getCode());
        logTask.setTaskDate(ProcessDateManager.getProcessDate());
        logTask.setTaskName(taskName);
        logTask.setTaskTime("0ms");
        boolean flag = super.save(logTask);
        return flag ? logTask : null;
    }

    @Override
    public boolean updateById(String taskId, String taskStatus, String taskTime) {
        UpdateWrapper<BhLogTask> wrapper = new UpdateWrapper<>();
        wrapper.set("TASK_STATUS", taskStatus)
                .set("TASK_TIME", taskTime)
                .set("BD_UPDATE_DATETIME", Instant.now())
                .eq("TASK_ID", taskId);
        return super.update(wrapper);
    }

    @Override
    public boolean updateErrorById(String taskId, String taskTime) {
        return this.updateById(taskId, TaskStatus.ERROR.getCode(), taskTime);
    }

    @Override
    public boolean updateSuccessById(String taskId, String taskTime) {
        return this.updateById(taskId, TaskStatus.SUCCESS.getCode(), taskTime);
    }

}
