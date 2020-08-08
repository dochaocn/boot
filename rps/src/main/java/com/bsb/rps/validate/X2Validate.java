package com.bsb.rps.validate;

import com.bsb.rps.dto.ReportRecord;
import com.bsb.rps.enums.ReportType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class X2Validate implements Validate {

    @Override
    public boolean judge(String recordType) {
        return ReportType.X2.getCode().equals(recordType);
    }

    @Override
    public void validate(ReportRecord record)  {
        // TODO 执行校验逻辑
        int sum = 0;
        for (int i = 0; i < 999999; i++) {
            sum = sum + i;
        }
        log.info(sum+"");
        log.info("执行校验={}", record.getData());
    }
}
