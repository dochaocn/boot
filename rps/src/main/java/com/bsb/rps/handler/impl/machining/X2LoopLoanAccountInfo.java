package com.bsb.rps.handler.impl.machining;

import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.enums.ReportType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component("X2Machining")
public class X2LoopLoanAccountInfo extends AbstractMachining {

    @Override
    public boolean judge(MachiningRecord record) {
        return true;
    }

    @Override
    public void process(MachiningRecord record) {
        record.setReportType(ReportType.X2);
        super.stepLine.startProcess(record);
    }

    @PostConstruct
    public void buildSteps() {
        super.stepNameList.add("x2Credit");
        super.stepNameList.add("customer");
        super.stepNameList.add("common");
        super.createStepObj(super.stepNameList);
        super.useAsyncOrSync();
    }

    @Override
    protected boolean judgeProdLoop(String loopStatus) {
        return true;
    }
}