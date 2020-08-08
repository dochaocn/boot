package com.bsb.rps.handler.impl.step;

import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.entity.BhTotalCust;
import com.bsb.rps.service.IBhTotalCustService;
import com.bsb.rps.util.EnhanceBeanUtil;
import com.bsb.rps.util.exc.CommonErrorCode;
import com.bsb.rps.util.exc.ServiceException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Scope("prototype")
public class Customer extends AbstractStep {

    @Resource
    private IBhTotalCustService totalCustService;

    @Override
    public MachiningRecord doProcess(MachiningRecord record) {
        BhTotalCust totalCust = totalCustService.getById(record.getCustNo());
        if (totalCust == null)
            throw new ServiceException(CommonErrorCode.ERROR_NULL_RECORD.getCode(), record.getCustNo());
        EnhanceBeanUtil.copyProperties(totalCust, record.getTargetRecord());
        return record;
    }

}
