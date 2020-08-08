package com.bsb.rps.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bsb.rps.entity.BhReportPlan;

import java.util.List;

/**
 * <p>
 * 上报计划表 服务类
 * </p>
 *
 * @author Dc
 */
public interface IBhReportPlanService extends IService<BhReportPlan> {

    BhReportPlan getByCreditAccntId(String creditAccntId);

    void putCacheWithOrderNoList(List<String> orderNoList);

    BhReportPlan getByOrderNo(String orderNo);
}
