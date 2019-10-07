package com.bsb.rps.handler.impl.step;

import com.bsb.rps.dto.BaseFiled;
import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.enums.ReportStatus;
import com.bsb.rps.manager.CountDownManager;
import com.bsb.rps.manager.ProcessDateManager;
import com.bsb.rps.util.EnhanceBeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope("prototype")
public class Common extends AbstractStep {

    @Override
    public MachiningRecord doProcess(MachiningRecord record) {
        try {
            BaseFiled baseFiled = new BaseFiled();
            baseFiled.setReqId("123456789");
            baseFiled.setProcessDate(ProcessDateManager.getProcessDate());
            baseFiled.setReportStatus(ReportStatus.UNREPORTED.getCode());
            baseFiled.setReportType(record.getReportType().getCode());
            baseFiled.setUploadTs("2019-10-01T22:22:22");
            EnhanceBeanUtil.copyProperties(baseFiled, record.getTargetRecord());
        } finally {
            CountDownManager.countDown();
        }
        return record;
    }

}