package com.bsb.rps;

import com.bsb.rps.entity.BhSysProd;
import com.bsb.rps.manager.ProcessDateManager;
import com.bsb.rps.imports.ImportClient;
import com.bsb.rps.imports.impl.ImportCredit;
import com.bsb.rps.imports.impl.ImportLoan;
import com.bsb.rps.service.IBhSysProdService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RpsApplicationTests {

    @Resource
    private IBhSysProdService sysProdService;

    @Test
    public void contextLoads() {
        Instant start = Instant.now();
        BhSysProd bhSysProd1 = sysProdService.getByProdSubNo("101001");
        System.out.println("bhSysProd1  " +Duration.between(start, Instant.now()).toMillis());

        BhSysProd bhSysProd2 = sysProdService.getByProdSubNo("101001");
        System.out.println("bhSysProd2  " +Duration.between(start, Instant.now()).toMillis());

        BhSysProd bhSysProd3 = sysProdService.getByProdSubNo("101001");
        System.out.println("bhSysProd3  " +Duration.between(start, Instant.now()).toMillis());

    }

    @Resource
    private ImportClient importClient;

    @Test
    public void imports() {
        ProcessDateManager.setProcessDate("2019-10-01");
        importClient.startImport();
    }

    @Resource
    private ImportCredit importCredit;
    @Resource
    private ImportLoan importLoan;

    @Test
    public void importsCredit() {
        Map<String, String> param = getParamMap();

        importCredit.process(param);
        importLoan.process(param);
    }

    private  Map<String, String> getParamMap() {
        String processDate = "2019-10-01";
        Map<String, String> param = new HashMap<>();
        param.put("tableName", processDate.replaceAll("-", ""));
        param.put("inputDate", "'" + processDate + "'");
        return param;
    }

}
