package com.bsb.rps.imports.impl;

import com.bsb.rps.enums.TaskName;
import com.bsb.rps.imports.Import;
import com.bsb.rps.mapper.BhTotalRepayPlanMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@Component
public class ImportRepayPlan implements Import {

    @Resource
    private BhTotalRepayPlanMapper totalRepayPlanMapper;

    @Override
    public void process(Map<String, String> paramMap) {
        log.info("ImportRepayPlan");
        totalRepayPlanMapper.deleteRepayPlan(paramMap);
        totalRepayPlanMapper.insertRepayPlan(paramMap);
    }

    @Override
    public String getImportTaskName() {
        return TaskName.IMPORT_REPAY_PLAN.getCode();
    }

}