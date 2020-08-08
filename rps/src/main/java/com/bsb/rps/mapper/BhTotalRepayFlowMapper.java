package com.bsb.rps.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bsb.rps.entity.BhTotalRepayFlow;

import java.util.Map;

/**
 * <p>
 * 还款流水全量表 Mapper 接口
 * </p>
 *
 * @author Dc
 */
public interface BhTotalRepayFlowMapper extends BaseMapper<BhTotalRepayFlow> {

    void insertRepayFlow(Map<String, String> param);
}
