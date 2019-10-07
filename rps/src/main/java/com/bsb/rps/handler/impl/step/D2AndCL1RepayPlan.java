package com.bsb.rps.handler.impl.step;

import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.entity.BhReportLoan;
import com.bsb.rps.entity.BhReportPlan;
import com.bsb.rps.entity.BhTotalRepayPlan;
import com.bsb.rps.enums.PlanReportStatus;
import com.bsb.rps.service.IBhTotalRepayPlanService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Scope("prototype")
public class D2AndCL1RepayPlan extends AbstractStep {

    @Resource
    private IBhTotalRepayPlanService totalRepayPlanService;

    @Override
    public MachiningRecord doProcess(MachiningRecord record) {
        BhReportLoan reportLoan = (BhReportLoan) record.getSourceRecord();
        List<BhTotalRepayPlan> repayPlanList = totalRepayPlanService.getByOrderNo(reportLoan.getBillingId());

        StringBuffer targetRepayDateList = new StringBuffer();
        repayPlanList.forEach(repayPlan -> targetRepayDateList.append(repayPlan.getTargetRepaymentDate()).append(","));
        targetRepayDateList.delete(targetRepayDateList.length() - 1, targetRepayDateList.length());
        reportLoan.setTargetRepayDateList(targetRepayDateList.toString());
        BhTotalRepayPlan firstRepayPlan = repayPlanList.get(0);
        reportLoan.setFirstRepaymentDate(firstRepayPlan.getTargetRepaymentDate());

        BhReportPlan reportPlan = record.getReportPlan();
        reportPlan.setReportTerm(firstRepayPlan.getTermNo());
        reportPlan.setReportDate(firstRepayPlan.getTargetRepaymentDate());
        reportPlan.setReportStatus(PlanReportStatus.NORMAL.getCode());
        return record;
    }
}
