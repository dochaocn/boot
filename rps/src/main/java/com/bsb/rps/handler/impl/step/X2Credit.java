package com.bsb.rps.handler.impl.step;

import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.entity.BhReportCredit;
import com.bsb.rps.entity.BhReportPlan;
import com.bsb.rps.entity.BhTotalCredit;
import com.bsb.rps.enums.AccountAction;
import com.bsb.rps.enums.GuaranteeType;
import com.bsb.rps.enums.OpCode;
import com.bsb.rps.service.IBhReportPlanService;
import com.bsb.rps.util.EnhanceBeanUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Scope("prototype")
public class X2Credit extends AbstractStep {

    @Resource
    private IBhReportPlanService reportPlanService;

    @Override
    public MachiningRecord doProcess(MachiningRecord record) {
        BhTotalCredit totalCredit = (BhTotalCredit) record.getSourceRecord();
        BhReportCredit reportCredit = new BhReportCredit();
        EnhanceBeanUtil.copyProperties(totalCredit, reportCredit);
        reportCredit.setGuaranteeType(GuaranteeType.XIN_YONG.getCode());
        reportCredit.setAccntBillingDate(-1);
        reportCredit.setAccntBillingDueDate(-1);

        BhReportPlan reportPlan = reportPlanService.getByCreditAccntId(totalCredit.getCreditAccntId());
        if (reportPlan == null) {
            reportCredit.setAccountAction(AccountAction.OPEN_ACCOUNT.getCode());
            reportCredit.setOpCode(OpCode.NEW_RECORD.getCode());

            reportPlan = new BhReportPlan();
            reportPlan.setCreditAccntId(totalCredit.getCreditAccntId());
            reportPlan.setCustNo(totalCredit.getCustNo());
        } else {
            reportCredit.setAccountAction(AccountAction.CHANGE_ACCOUNT.getCode());
            reportCredit.setOpCode(OpCode.CHG_RECORD.getCode());
        }

        record.setCustNo(totalCredit.getCustNo());
        record.setReportPlan(reportPlan);
        record.setTargetRecord(reportCredit);
        return record;
    }

}
