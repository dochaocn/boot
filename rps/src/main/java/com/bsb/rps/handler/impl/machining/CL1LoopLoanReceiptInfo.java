package com.bsb.rps.handler.impl.machining;

import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.entity.BhTotalLoan;
import com.bsb.rps.enums.LoopStatus;
import com.bsb.rps.enums.ReportType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component("CL1Machining")
public class CL1LoopLoanReceiptInfo extends AbstractMachining {

    @Override
    public boolean judge(MachiningRecord record) {
        log.info("flowNo={}, CL1Machining 判断", record.getFlowNo());
        return super.judgeForD2AndCL1(((BhTotalLoan) record.getSourceRecord()).getProdSubNo());
    }

    @Override
    protected boolean judgeProdLoop(String loopStatus) {
        // TODO 循环贷也存在单笔单批,如何判断？
        return LoopStatus.Y.getCode().equals(loopStatus);
    }

    @Override
    public void process(MachiningRecord record) {
        record.setReportType(ReportType.CL1);
        super.stepLine.process(record);
    }

    @PostConstruct
    private void buildSteps() {
        super.D2AndCL1BuildSteps();
    }

}