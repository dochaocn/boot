package com.bsb.rps.validate;

import com.bsb.rps.entity.ReportRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class X2Validate implements Validate {

    @Override
    public boolean match(String recordType) {
        return "X2".equals(recordType);
    }

    @Override
    public void validate(ReportRecord record)  {
        // 执行校验逻辑
        int sum = 0;
        for (int i = 0; i < 999999; i++) {
            sum = sum + i;
        }
        log.info(sum+"");
        log.info("执行校验={}", record.getData());
    }
}
