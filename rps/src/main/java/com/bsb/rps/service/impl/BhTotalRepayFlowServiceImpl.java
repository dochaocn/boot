package com.bsb.rps.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bsb.rps.entity.BhTotalRepayFlow;
import com.bsb.rps.enums.ProcessStatus;
import com.bsb.rps.manager.ProcessDateManager;
import com.bsb.rps.mapper.BhTotalRepayFlowMapper;
import com.bsb.rps.service.IBhReportPlanService;
import com.bsb.rps.service.IBhTotalRepayFlowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 还款流水全量表 服务实现类
 * </p>
 *
 * @author Dc
 */
@Service
public class BhTotalRepayFlowServiceImpl extends ServiceImpl<BhTotalRepayFlowMapper, BhTotalRepayFlow> implements IBhTotalRepayFlowService {

    @Resource
    private IBhReportPlanService reportPlanService;

    @Override
    public List<BhTotalRepayFlow> list() {
        QueryWrapper<BhTotalRepayFlow> wrapper = new QueryWrapper<>();
        wrapper.eq("INPUT_DATE", ProcessDateManager.getProcessDate());
        wrapper.eq("PROCESS_STATUS", ProcessStatus.UNPROCESSED.getCode());
        List<BhTotalRepayFlow> repayFlowList = super.list(wrapper);

        if (repayFlowList != null && repayFlowList.size() > 0) {
            List<String> orderNoList = new ArrayList<>();
            repayFlowList.forEach((repayFlow) -> orderNoList.add(repayFlow.getOrderNo()));
            reportPlanService.putCacheWithOrderNoList(orderNoList);
        }

        return repayFlowList;
    }

    @Override
    public boolean updateBatchById(Collection<BhTotalRepayFlow> repayFlowList) {
        repayFlowList.forEach(repayFlow -> repayFlow.setProcessStatus(ProcessStatus.NOT_NEED.getCode()));
        return super.updateBatchById(repayFlowList, repayFlowList.size());
    }

}
