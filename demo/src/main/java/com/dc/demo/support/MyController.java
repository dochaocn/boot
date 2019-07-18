package com.dc.demo.support;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RestController
@RequestMapping
public @interface MyController {

    //  类访问路径
    @AliasFor(annotation = RequestMapping.class, value = "value")
    String mapping() default "";

    //  controller别名
    @AliasFor(annotation = RestController.class, value = "value")
    String name() default "";

}
