package com.bsb.rps.imports.impl;

import com.bsb.rps.imports.Import;
import com.bsb.rps.mapper.BhTotalCreditMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@Component
public class ImportCredit implements Import {

    @Resource
    private BhTotalCreditMapper totalCreditMapper;

    @Override
    public void process(Map<String, String> paramMap) {
        log.info("ImportCredit");
        totalCreditMapper.deleteCredit(paramMap);
        totalCreditMapper.insertCredit(paramMap);
    }

}