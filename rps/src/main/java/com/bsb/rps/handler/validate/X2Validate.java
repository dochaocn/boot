package com.bsb.rps.handler.validate;

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
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("执行校验={}", record.getData());
    }
}
