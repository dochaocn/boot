package com.bsb.rps.validate;

import com.bsb.rps.entity.ReportRecord;

public interface Validate {

    boolean match(String recordType);

    void validate(ReportRecord record);
}
