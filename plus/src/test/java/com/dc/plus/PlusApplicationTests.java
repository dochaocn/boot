package com.dc.plus;

import com.dc.plus.entity.Error;
import com.dc.plus.mapper.BhErrorMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PlusApplicationTests {

    @Resource
    private BhErrorMapper bhErrorMapper;

    @Test
    public void contextLoads() {
        Error error = bhErrorMapper.selectReport("1");
        log.info(error.toString());
    }

}
