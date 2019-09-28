package com.bsb.rps.handler.validate;

import com.bsb.rps.entity.ReportRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class D2AndCL1Validate implements Validate {

    @Override
    public boolean match(String recordType) {
        return "CL1".equals(recordType) || "D2".equals(recordType);
    }

    @Override
    public void validate(ReportRecord record) {

    }
}
