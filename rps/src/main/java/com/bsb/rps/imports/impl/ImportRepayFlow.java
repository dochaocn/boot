package com.bsb.rps.imports.impl;

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
        log.info("ImportRepayFlow");
        totalRepayFlowMapper.insertRepayFlow(paramMap);
    }

}