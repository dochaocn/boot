package com.bsb.rps.imports.impl;

import com.bsb.rps.enums.TaskName;
import com.bsb.rps.imports.Import;
import com.bsb.rps.mapper.BhTotalRepayFlowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@Component
public class ImportRepayFlow implements Import {

    @Resource
    private BhTotalRepayFlowMapper totalRepayFlowMapper;

    @Override
    public void process(Map<String, String> paramMap) {
        totalRepayFlowMapper.insertRepayFlow(paramMap);
    }

    @Override
    public String getImportTaskName() {
        return TaskName.IMPORT_REPAY_FLOW.getCode();
    }

}