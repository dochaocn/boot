package com.bsb.rps;

import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.entity.BhReportCredit;
import com.bsb.rps.entity.BhReportPlan;
import com.bsb.rps.entity.BhSysProd;
import com.bsb.rps.entity.BhTotalCredit;
import com.bsb.rps.enums.AccountAction;
import com.bsb.rps.enums.GuaranteeType;
import com.bsb.rps.enums.OpCode;
import com.bsb.rps.manager.ProcessDateManager;
import com.bsb.rps.imports.ImportClient;
import com.bsb.rps.imports.impl.ImportCredit;
import com.bsb.rps.imports.impl.ImportLoan;
import com.bsb.rps.service.IBhSysProdService;
import com.bsb.rps.util.EnhanceBeanUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RpsApplicationTests {

    @Resource
    private IBhSysProdService sysProdService;

    @Test
    public void contextLoads() {
        Instant start = Instant.now();
        BhSysProd bhSysProd1 = sysProdService.getByProdSubNo("101001");
        System.out.println("bhSysProd1  " + Duration.between(start, Instant.now()).toMillis());

        BhSysProd bhSysProd2 = sysProdService.getByProdSubNo("101001");
        System.out.println("bhSysProd2  " + Duration.between(start, Instant.now()).toMillis());

        BhSysProd bhSysProd3 = sysProdService.getByProdSubNo("101001");
        System.out.println("bhSysProd3  " + Duration.between(start, Instant.now()).toMillis());

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

    private Map<String, String> getParamMap() {
        String processDate = "2019-10-01";
        Map<String, String> param = new HashMap<>();
        param.put("tableName", processDate.replaceAll("-", ""));
        param.put("inputDate", "'" + processDate + "'");
        return param;
    }


    @Test
    public void format() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String now = format.format(new Date());
//        Instant.now()
        System.out.println(now);
    }

    @Test
    public void countdonw() {
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {

            int finalI = i;
            new Thread(() -> {
                if (finalI == 0) {
                    int a = 1 / 0;
                }
                countDownLatch.countDown();
            }).start();

        }

        int a = 1 / 0;

        try {
            countDownLatch.await();
            System.out.println("await end...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testTime() throws InterruptedException {
        Instant now = Instant.now();

        MachiningRecord record = new MachiningRecord();
        record.setSourceRecord(new BhTotalCredit());

        BhTotalCredit totalCredit = (BhTotalCredit) record.getSourceRecord();
        BhReportCredit reportCredit = new BhReportCredit();
//        BeanUtils.copyProperties(totalCredit, reportCredit);
        reportCredit.setApplyDate(totalCredit.getApplyDate());
        reportCredit.setAccountExpireDate(totalCredit.getAccountExpireDate());
        reportCredit.setAccountInfoUpdate(totalCredit.getAccountInfoUpdateDate());
        reportCredit.setAccountOpenDate(totalCredit.getAccountOpenDate());
        reportCredit.setCreditAccntId(totalCredit.getCreditAccntId());
        reportCredit.setCreditAccntStatus(totalCredit.getCreditAccntStatus());
        reportCredit.setCreditLimit(totalCredit.getCreditLimit());
        reportCredit.setGracePeriod(totalCredit.getGracePeriod());
        reportCredit.setCreateUser(totalCredit.getCreateUser());
        reportCredit.setUpdateUser(totalCredit.getUpdateUser());
        reportCredit.setBdCreateDatetime(totalCredit.getBdCreateDatetime());
        reportCredit.setBdUpdateDatetime(totalCredit.getBdUpdateDatetime());
        reportCredit.setGuaranteeType(GuaranteeType.XIN_YONG.getCode());
        reportCredit.setAccntBillingDate(-1);
        reportCredit.setAccntBillingDueDate(-1);
//        Thread.sleep(20L); // 模拟 查询
        //        BhReportPlan reportPlan = reportPlanService.getByCreditAccntId(totalCredit.getCreditAccntId());

        BhReportPlan reportPlan = null;
        if (reportPlan == null) {
            reportCredit.setAccountAction(AccountAction.OPEN_ACCOUNT.getCode());
            reportCredit.setOpCode(OpCode.NEW_RECORD.getCode());

            reportPlan = new BhReportPlan();
            reportPlan.setCreditAccntId(totalCredit.getCreditAccntId());
            reportPlan.setCustNo(totalCredit.getCustNo());
        } else {
            reportCredit.setAccountAction(AccountAction.CHANGE_ACCOUNT.getCode());
            reportCredit.setOpCode(OpCode.CHG_RECORD.getCode());
        }

        record.setCustNo(totalCredit.getCustNo());
        record.setReportPlan(reportPlan);
        record.setTargetRecord(reportCredit);
        System.out.println(Duration.between(now, Instant.now()).toMillis());

        List<BhReportCredit> list = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            list.add(new BhReportCredit());
        }

        Map<String, BhReportCredit> map = new HashMap<>();
        list.forEach(crdit -> map.put(crdit.getCreditAccntId(), crdit));


        System.out.println(Duration.between(now, Instant.now()).toMillis());
    }


}
