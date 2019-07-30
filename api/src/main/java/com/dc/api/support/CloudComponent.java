package com.dc.api.support;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
@ResponseBody
@RequestMapping
public @interface CloudComponent {

    @AliasFor(annotation = Component.class, value = "value")
    String value() default "";

    @AliasFor(annotation = RequestMapping.class, value = "value")
    String mapping() default "";

}
