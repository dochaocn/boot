package com.bsb.rps.handler.impl.step;

import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.entity.BhReportLoanAfter;
import com.bsb.rps.entity.BhTotalRepayPlan;
import com.bsb.rps.service.IBhTotalRepayPlanService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Scope("prototype")
public class D3AndCL2RepayPlan extends AbstractStep {

    @Resource
    private IBhTotalRepayPlanService totalRepayPlanService;

    @Override
    public MachiningRecord doProcess(MachiningRecord record) {

        BhReportLoanAfter reportLoanAfter = (BhReportLoanAfter) record.getSourceRecord();

        List<BhTotalRepayPlan> repayPlanList = totalRepayPlanService.getByOrderNo(reportLoanAfter.getBillingId());


        return record;
    }
}
