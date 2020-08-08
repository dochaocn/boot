package com.dc.cloudconsumer.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("cloud-consumer")
                        .description("api接口-http请求")
                        .version("1.0")
                        .build())       //api标题信息
                .select()
                // 扫描包路径
//                .apis(RequestHandlerSelectors.basePackage("com.dc.cloudconsumer.eureka"))
                // 只扫描类上有API注解的class
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                // 只扫描方法上有ApiOperation注解的方法
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }
}
