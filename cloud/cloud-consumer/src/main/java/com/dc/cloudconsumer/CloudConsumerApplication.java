package com.dc.cloudconsumer;

import com.dc.api.support.CloudComponent;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients     // 远程调用
@EnableDiscoveryClient  // 注册
@EnableCircuitBreaker   // 断路器
@EnableHystrixDashboard // 监控
@CloudComponent
@SpringBootApplication(scanBasePackages = {"com.dc.cloudconsumer.config","com.dc.cloudconsumer.eureka","com.dc.cloudconsumer.controller"})
public class CloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerApplication.class, args);
    }

    /**
     * Hystrix dashboard 需配置此Servlet(HystrixMetricsStreamServlet)才可访问
     * 访问地址：http://localhost:9001/hystrix
     * stream地址：http://localhost:9001/actuator/hystrix.stream
     * @return ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet(){
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean =
                new ServletRegistrationBean<>(new HystrixMetricsStreamServlet());
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
