package com.dc.demo;

import com.dc.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {

    @Resource
    private RedisTemplate<Object,Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1() {
        stringRedisTemplate.opsForList().leftPush("dc","1");
        stringRedisTemplate.opsForList().leftPush("dc","2");
        stringRedisTemplate.opsForList().leftPush("dc","3");
    }

    @Test
    public void test2() {
        User user = new User();
        user.setId(1111);
        redisTemplate.opsForList().leftPush("dcc111",user);
    }
}
