package com.bsb.rps.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bsb.rps.entity.BhTotalCredit;
import com.bsb.rps.enums.ProcessStatus;
import com.bsb.rps.manager.ProcessDateManager;
import com.bsb.rps.mapper.BhTotalCreditMapper;
import com.bsb.rps.service.IBhTotalCreditService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 授信信息全量表 服务实现类
 * </p>
 *
 * @author Dc
 */
@Service
public class BhTotalCreditServiceImpl extends ServiceImpl<BhTotalCreditMapper, BhTotalCredit> implements IBhTotalCreditService {

    @Override
    public List<BhTotalCredit> list() {
        QueryWrapper<BhTotalCredit> wrapper = new QueryWrapper<>();
        wrapper.eq("INPUT_DATE", ProcessDateManager.getProcessDate());
        wrapper.eq("PROCESS_STATUS", ProcessStatus.UNPROCESSED.getCode());
        return super.list(wrapper);
    }

    @Override
    public boolean updateBatchById(Collection<BhTotalCredit> totalCreditList) {
        totalCreditList.forEach(credit -> credit.setProcessStatus(ProcessStatus.NOT_NEED.getCode()));
        return super.updateBatchById(totalCreditList, totalCreditList.size());
    }
}
