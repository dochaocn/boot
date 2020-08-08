package com.bsb.rps.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bsb.rps.entity.BhReportPlan;
import com.bsb.rps.manager.ProcessDateManager;
import com.bsb.rps.mapper.BhReportPlanMapper;
import com.bsb.rps.service.IBhReportPlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 上报计划表 服务实现类
 * </p>
 *
 * @author Dc
 */
@Slf4j
@Service
public class BhReportPlanServiceImpl extends ServiceImpl<BhReportPlanMapper, BhReportPlan> implements IBhReportPlanService {

    @Override
    public BhReportPlan getByCreditAccntId(String creditAccntId) {
        QueryWrapper<BhReportPlan> wrapper = new QueryWrapper<>();
        wrapper.eq("CREDIT_ACCNT_ID", creditAccntId);
        return super.getOne(wrapper);
    }

    @Override
    public List<BhReportPlan> list() {
        QueryWrapper<BhReportPlan> wrapper = new QueryWrapper<>();
        wrapper.eq("REPORT_DATE", ProcessDateManager.getProcessDate());
        return super.list(wrapper);
    }

    @Override
    public void putCacheWithOrderNoList(List<String> orderNoList) {
        this.reserved();
        QueryWrapper<BhReportPlan> wrapper = new QueryWrapper<>();
        wrapper.in("ORDER_NO", orderNoList);
        super.list(wrapper).forEach(this::putCache);
    }

    @Override
    @Cacheable(value = "plan", key = "#orderNo")
    public BhReportPlan getByOrderNo(String orderNo) {
        return super.getById(orderNo);
    }

    @Cacheable(value = "plan", key = "#reportPlan.orderNo")
    public void putCache(BhReportPlan reportPlan) {
        log.info("上报计划放入ehcache缓存中,reportPlan={}", reportPlan);
    }

    @CacheEvict(value = "plan", allEntries = true)
    public void reserved() {
        log.info("清空ehcache.plan缓存");
    }

}
