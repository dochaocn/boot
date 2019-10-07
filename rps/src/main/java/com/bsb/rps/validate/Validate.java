package com.bsb.rps.validate;

import com.bsb.rps.dto.ReportRecord;

public interface Validate {

    boolean judge(String recordType);

    void validate(ReportRecord record);
}
