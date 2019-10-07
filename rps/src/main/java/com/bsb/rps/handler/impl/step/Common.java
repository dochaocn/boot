package com.bsb.rps.handler.impl.step;

import com.bsb.rps.dto.BaseFiled;
import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.enums.ReportStatus;
import com.bsb.rps.manager.ProcessDateManager;
import com.bsb.rps.util.EnhanceBeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
@Scope("prototype")
public class Common extends AbstractStep {

    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public MachiningRecord doProcess(MachiningRecord record) {
        BaseFiled baseFiled = new BaseFiled();
        baseFiled.setReqId(UUID.randomUUID().toString().substring(0,30));  // TODO 记录唯一编号生成规则
        baseFiled.setProcessDate(ProcessDateManager.getProcessDate());
        baseFiled.setReportStatus(ReportStatus.UNREPORTED.getCode());
        baseFiled.setReportType(record.getReportType().getCode());
        baseFiled.setUploadTs(format.format(new Date()));
        EnhanceBeanUtil.copyProperties(baseFiled, record.getTargetRecord());

        return record;
    }

}