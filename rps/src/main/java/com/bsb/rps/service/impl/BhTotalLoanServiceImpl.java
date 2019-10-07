package com.bsb.rps.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bsb.rps.entity.BhTotalLoan;
import com.bsb.rps.enums.ProcessStatus;
import com.bsb.rps.manager.ProcessDateManager;
import com.bsb.rps.mapper.BhTotalLoanMapper;
import com.bsb.rps.service.IBhTotalLoanService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 借据信息全量表 服务实现类
 * </p>
 *
 * @author Dc
 */
@Service
public class BhTotalLoanServiceImpl extends ServiceImpl<BhTotalLoanMapper, BhTotalLoan> implements IBhTotalLoanService {

    @Override
    public List<BhTotalLoan> list() {
        QueryWrapper<BhTotalLoan> wrapper = new QueryWrapper<>();
        wrapper.eq("INPUT_DATE", ProcessDateManager.getProcessDate());
        wrapper.eq("PROCESS_STATUS", ProcessStatus.UNPROCESSED.getCode());
        return super.list(wrapper);
    }

    @Override
    public boolean updateBatchById(Collection<BhTotalLoan> totalLoanList) {
        totalLoanList.forEach(loan -> loan.setProcessStatus(ProcessStatus.NOT_NEED.getCode()));
        return super.updateBatchById(totalLoanList, totalLoanList.size());
    }

}
