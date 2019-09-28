package com.bsb.rps.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.concurrent.*;

@Configuration
@MapperScan(basePackages = "com.bsb.rps.mapper")
@ComponentScan(basePackages = {"com.bsb.rps.controller","com.bsb.rps.service.impl","com.bsb.rps.handler","com.bsb.rps.validate"})
public class AllConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    @Bean
    public ExecutorService executorService() {
        return new ThreadPoolExecutor(1,
                100,
                100,
                TimeUnit.MINUTES,
                new SynchronousQueue<>(),
                threadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Bean
    public ThreadFactory threadFactory() {
        return new BsbRpsThreadFactory("bsb-rps");
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
