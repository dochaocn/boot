package com.dc.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  @SpringBootApplication
 *  spring boot 主程序类
 *  @SpringBootApplication 包含
 *          @Target(ElementType.TYPE)
 *          @Retention(RetentionPolicy.RUNTIME)
 *          @Documented
 *          @Inherited
 *          @SpringBootConfiguration
 *                  @Configuration
 *          @EnableAutoConfiguration
 *          @ComponentScan
 */

@SpringBootApplication
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}