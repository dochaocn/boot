package com.bsb.rps.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

@Configuration
@MapperScan(basePackages = "com.bsb.rps.mapper")
@ComponentScan(basePackages = {"com.bsb.rps.controller","com.bsb.rps.service.impl",
        "com.bsb.rps.imports","com.bsb.rps.handler","com.bsb.rps.validate","com.bsb.rps.report"})
@EnableCaching
public class AllConfig {

    @Value("${thread.maxPoolSize}")
    private Integer maxPoolSize; // 线程池中最大线程数

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    @Bean
    public ExecutorService executorService() {
        return new BsbRpsThreadPoolExecutor(1,
                Runtime.getRuntime().availableProcessors() * 10,
                30,
                TimeUnit.MINUTES,
                new SynchronousQueue<>(),
                threadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Bean
    public ThreadFactory threadFactory() {
        return new BsbRpsThreadFactory();
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public RestTemplate restTemplate() {
        Map<String, String> variables = new HashMap<>();
        RestTemplate restTemplate = new RestTemplate();
        variables.put("Content-Type", "application/json");
//        variables.put("Authorization", "HTTP Basic Authorization based on " + username + " and " + password);
        restTemplate.setDefaultUriVariables(variables);
        return restTemplate;
    }

}
