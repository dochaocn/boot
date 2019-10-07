package com.bsb.rps.imports.impl;

import com.bsb.rps.imports.Import;
import com.bsb.rps.mapper.BhTotalCustMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@Component
public class ImportCust implements Import {

    @Resource
    private BhTotalCustMapper totalCustMapper;

    @Override
    public void process(Map<String, String> paramMap) {
        log.info("ImportCust");
        totalCustMapper.deleteCust(paramMap);
        totalCustMapper.insertCust(paramMap);
    }

}