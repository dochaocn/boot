package com.bsb.rps.imports.impl;

import com.bsb.rps.enums.TaskName;
import com.bsb.rps.imports.Import;
import com.bsb.rps.mapper.BhTotalLoanMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@Component
public class ImportLoan implements Import {

    @Resource
    private BhTotalLoanMapper totalLoanMapper;

    @Override
    public void process(Map<String, String> paramMap) {
        totalLoanMapper.deleteLoan(paramMap);
        totalLoanMapper.insertLoan(paramMap);
    }

    @Override
    public String getImportTaskName() {
        return TaskName.IMPORT_LOAN.getCode();
    }

}