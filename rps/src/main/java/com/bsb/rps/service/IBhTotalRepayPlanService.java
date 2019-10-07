package com.bsb.rps.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bsb.rps.entity.BhTotalRepayPlan;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Dc
 */
public interface IBhTotalRepayPlanService extends IService<BhTotalRepayPlan> {

    List<BhTotalRepayPlan> getByOrderNo(String orderNo);
}
