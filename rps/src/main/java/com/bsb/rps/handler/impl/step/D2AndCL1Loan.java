package com.bsb.rps.handler.impl.step;

import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.entity.BhReportLoan;
import com.bsb.rps.entity.BhReportPlan;
import com.bsb.rps.entity.BhTotalLoan;
import com.bsb.rps.enums.ChangeFlag;
import com.bsb.rps.enums.GuaranteeType;
import com.bsb.rps.enums.LoanPurpose;
import com.bsb.rps.enums.OpCode;
import com.bsb.rps.service.IBhReportPlanService;
import com.bsb.rps.util.EnhanceBeanUtil;
import com.bsb.rps.util.exc.ServiceException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Scope("prototype")
public class D2AndCL1Loan extends AbstractStep {

    @Resource
    private IBhReportPlanService reportPlanService;

    @Override
    public MachiningRecord doProcess(MachiningRecord record) {
        BhTotalLoan totalLoan = (BhTotalLoan) record.getSourceRecord();
        BhReportLoan reportLoan = record.getSourceRecord() == null ? new BhReportLoan() : (BhReportLoan) record.getSourceRecord();
        EnhanceBeanUtil.copyProperties(totalLoan, reportLoan);
        reportLoan.setBillingId(totalLoan.getOrderNo());
        reportLoan.setBillingAmount(totalLoan.getTransAmount());
        reportLoan.setGuaranteeType(GuaranteeType.XIN_YONG.getCode());
        reportLoan.setTargetRepayDateType(-1);
        reportLoan.setTermPeriod(-1);

        // TODO 贷款用途核心码值与百行码值匹配转换
        LoanPurpose loanPurpose = LoanPurpose.judgeValue(totalLoan.getLoanPurpose());
        if (loanPurpose == null) {
            reportLoan.setLoanPurpose(LoanPurpose.XIAO_FEI.getCode());
        }

        BhReportPlan reportPlan = reportPlanService.getById(totalLoan.getOrderNo());
        if (reportPlan == null) {
            reportPlan = new BhReportPlan();
            reportPlan.setCreditAccntId(totalLoan.getCreditAccntId());
            reportPlan.setCustNo(totalLoan.getCustNo());
            reportPlan.setOrderNo(totalLoan.getOrderNo());
            reportPlan.setCustNo(totalLoan.getCustNo());

            reportLoan.setOpCode(OpCode.NEW_RECORD.getCode());
        } else if (ChangeFlag.Y.getCode().equals(totalLoan.getChangeFlag())){
            reportLoan.setOpCode(OpCode.CHG_RECORD.getCode());
            // TODO 还款计划更变缩期需要记录次数
        } else {
            throw new ServiceException("", "");
        }

        record.setCustNo(totalLoan.getCustNo());
        record.setReportPlan(reportPlan);
        record.setTargetRecord(reportLoan);
        return record;
    }
}
