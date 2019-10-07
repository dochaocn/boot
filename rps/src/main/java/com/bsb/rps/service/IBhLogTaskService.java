package com.bsb.rps.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bsb.rps.entity.BhLogTask;

/**
 * <p>
 * 任务步骤表 服务类
 * </p>
 *
 * @author Dc
 */
public interface IBhLogTaskService extends IService<BhLogTask> {

    BhLogTask insert(String taskName);

    boolean updateById(String taskId, String taskStatus);

    boolean updateErrorById(String taskId);

    boolean updateSuccessById(String taskId);
}
