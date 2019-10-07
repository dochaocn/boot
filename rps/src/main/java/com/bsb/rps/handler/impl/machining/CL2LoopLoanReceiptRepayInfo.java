package com.bsb.rps.handler.impl.machining;

import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.enums.LoopStatus;
import com.bsb.rps.enums.ReportType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 该类判断分为两种
 * 1. 由实际还款引发的报送
 * 2. 由最后还款日引发的报送
 *
 * @author Dc
 */
@Slf4j
@Component("CL2Machining")
public class CL2LoopLoanReceiptRepayInfo extends AbstractMachining {

    @Override
    public boolean judge(MachiningRecord record) {
        log.info("flowNo={}, CL2Machining 判断", record.getFlowNo());
        return super.judgeForD3AndCL2(record);
    }

    @Override
    protected boolean judgeProdLoop(String loopStatus) {
        return LoopStatus.Y.getCode().equals(loopStatus);
    }

    @Override
    public void process(MachiningRecord record) {
        record.setReportType(ReportType.CL2);
        super.stepLine.process(record);
    }

    @PostConstruct
    public void buildSteps() {
        super.D3AndCL2BuildSteps();
    }

}