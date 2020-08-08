package com.bsb.rps.handler.impl.machining;

import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.entity.BhTotalLoan;
import com.bsb.rps.enums.LoopStatus;
import com.bsb.rps.enums.ReportType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component("D2Machining")
public class D2SingleLoanAccountInfo extends AbstractMachining {

    @Override
    public boolean judge(MachiningRecord record) {
        log.info("flowNo={}, D2Machining 判断", record.getFlowNo());
        return super.judgeForD2AndCL1(((BhTotalLoan) record.getSourceRecord()).getProdSubNo());
    }

    @Override
    protected boolean judgeProdLoop(String loopStatus) {
        return LoopStatus.N.getCode().equals(loopStatus);
    }

    @Override
    public void process(MachiningRecord record) {
        record.setReportType(ReportType.D2);
        super.stepLine.startProcess(record);
    }

    @PostConstruct
    public void buildSteps() {
        super.D2AndCL1BuildSteps();
    }

}