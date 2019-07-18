package com.dc.dubbo;

import com.dc.dubbo.service.DubboUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo01ApplicationTests {

    @Resource
    private DubboUserService dubboUserService;

    @Test
    public void contextLoads() {
        dubboUserService.hello();
    }

}

