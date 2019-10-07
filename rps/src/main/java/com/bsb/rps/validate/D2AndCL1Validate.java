package com.bsb.rps.validate;

import com.bsb.rps.dto.ReportRecord;
import com.bsb.rps.enums.ReportType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class D2AndCL1Validate implements Validate {

    @Override
    public boolean judge(String recordType) {
        return ReportType.CL1.getCode().equals(recordType) || ReportType.D2.getCode().equals(recordType);
    }

    @Override
    public void validate(ReportRecord record) {

    }
}
