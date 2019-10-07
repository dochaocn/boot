package com.bsb.rps.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bsb.rps.entity.BhTotalRepayPlan;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Dc
 */
public interface BhTotalRepayPlanMapper extends BaseMapper<BhTotalRepayPlan> {

    void deleteRepayPlan(Map<String, String> param);

    void insertRepayPlan(Map<String, String> param);
}
