package com.bsb.rps.handler.validate;

import com.bsb.rps.entity.ReportRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class D3AndCL2Validate implements Validate {

    @Override
    public boolean match(String recordType) {
        return "CL2".equals(recordType) || "D3".equals(recordType);
    }

    @Override
    public void validate(ReportRecord record) {

    }
}
