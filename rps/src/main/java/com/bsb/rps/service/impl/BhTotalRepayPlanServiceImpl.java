package com.bsb.rps.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bsb.rps.entity.BhTotalRepayPlan;
import com.bsb.rps.mapper.BhTotalRepayPlanMapper;
import com.bsb.rps.service.IBhTotalRepayPlanService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Dc
 */
@Service
public class BhTotalRepayPlanServiceImpl extends ServiceImpl<BhTotalRepayPlanMapper, BhTotalRepayPlan> implements IBhTotalRepayPlanService {

    @Override
    public List<BhTotalRepayPlan> getByOrderNo(String orderNo) {
        QueryWrapper<BhTotalRepayPlan> wrapper = new QueryWrapper<>();
        wrapper.eq("ORDER_NO", orderNo);
        wrapper.orderByAsc("TERM_NO");
        return super.list(wrapper);
    }

}
