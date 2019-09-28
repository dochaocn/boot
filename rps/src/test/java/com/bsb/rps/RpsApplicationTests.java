package com.bsb.rps;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bsb.rps.entity.BhSysProd;
import com.bsb.rps.handler.disruptor.MainDisruptor;
import com.bsb.rps.service.IBhSysProdService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RpsApplicationTests {

    @Resource
    private IBhSysProdService sysProdService;

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



}
