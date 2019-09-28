package com.bsb.rps;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bsb.rps.entity.BhSysProd;
import com.bsb.rps.entity.ReportRecord;
import com.bsb.rps.handler.disruptor.MainDisruptor;
import com.bsb.rps.handler.validate.Validate;
import com.bsb.rps.service.IBhSysProdService;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.ExecutorService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RpsApplicationTests {

    @Resource
    private IBhSysProdService sysProdService;

    @Resource
    private ExecutorService executorService;

    @Test
    public void contextLoads() {
        List<BhSysProd> list = sysProdService.selectAll();

        log.info("list={}", list);
        log.info("one={}", sysProdService.selectOneByProdSubNo("101001"));

    }

    @Test
    public void test() {
        Page<BhSysProd> iPage = new Page<>();
        QueryWrapper<BhSysProd> wrapper = new QueryWrapper<>();
        wrapper.eq("LOOP_STATUS", "N");

        long current = 1L;
        List<BhSysProd> list;
        while (true) {
            iPage.setCurrent(current++);
            iPage.setSize(1L);
            list = sysProdService.page(iPage, wrapper).getRecords();
            if (list.size() == 0)
                break;
            log.info("page={}", list);
        }
    }

    @Resource
    private Validate x2Validate;

    @Test
    public void test1() {
        List<BhSysProd> recordList;
        for (int i = 0; i < 100; i++) {
            Instant start = Instant.now();
            recordList = sysProdService.selectAll();
            log.error("耗时={}", Duration.between(start, Instant.now()).toMillis());

            for (BhSysProd prod:recordList) {
                executorService.execute(() -> {
                    log.info("record={}", prod);
                    ReportRecord reportRecord = new ReportRecord();
                    reportRecord.setRecordType("X2");
                    reportRecord.setData(prod);
                    if (x2Validate.match(reportRecord.getRecordType()))
                        x2Validate.validate(reportRecord);
                });
            }

        }
    }

}
