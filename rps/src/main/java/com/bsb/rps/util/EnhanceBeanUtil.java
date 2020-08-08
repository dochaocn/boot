package com.bsb.rps.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;

import com.bsb.rps.util.MathUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

public abstract class EnhanceBeanUtil extends BeanUtils {

    public static void copyProperties(Object source, Object target) throws BeansException {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        Class<?> actualEditable = target.getClass();
        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        for (PropertyDescriptor targetPd : targetPds) {
            if (targetPd.getWriteMethod() != null) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null && sourcePd.getReadMethod() != null) {
                    try {
                        Method readMethod = sourcePd.getReadMethod();
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        Object srcValue = readMethod.invoke(source);
                        //enum不进行复制
                        if (sourcePd.getPropertyType().isEnum() || targetPd.getPropertyType().isEnum()) {
                            srcValue = null;
                        }
                        if(srcValue == null){
                            continue;
                        }
                        Object value=srcValue;

                        //转换Double 与 BigDecimal
                        if(sourcePd.getPropertyType().isAssignableFrom( Double.class) && targetPd.getPropertyType().isAssignableFrom(BigDecimal.class)){
                            value = new BigDecimal((Double)srcValue);
                        }
                        if(sourcePd.getPropertyType().isAssignableFrom( BigDecimal.class) && targetPd.getPropertyType().isAssignableFrom(Double.class)){
                            value = ((BigDecimal)srcValue).doubleValue();
                        }
                        //转换Long 与 BigDecimal
                        if(sourcePd.getPropertyType().isAssignableFrom( Long.class) && targetPd.getPropertyType().isAssignableFrom(BigDecimal.class)){
                            value = new BigDecimal((Long)srcValue);
                        }
                        if(sourcePd.getPropertyType().isAssignableFrom( BigDecimal.class) && targetPd.getPropertyType().isAssignableFrom(Long.class)){
                            value = ((BigDecimal)srcValue).longValue();
                        }
                        //转换String为数字的 与 BigDecimal
                        if(sourcePd.getPropertyType().isAssignableFrom( String.class) && targetPd.getPropertyType().isAssignableFrom(BigDecimal.class)){
                            String srcValueStr = (String)srcValue;
                            if(srcValueStr.matches("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){2})$")){
                                value = new BigDecimal((String)srcValue);
                            }
                        }
                        if(sourcePd.getPropertyType().isAssignableFrom( BigDecimal.class) && targetPd.getPropertyType().isAssignableFrom(String.class)){
                            value = MathUtil.roundTwoScale((BigDecimal)srcValue).toString();
                        }

                        // 这里判断以下value是否为空 当然这里也能进行一些特殊要求的处理 例如绑定时格式转换等等
                        if (value != null) {
                            Method writeMethod = targetPd.getWriteMethod();
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }
                            writeMethod.invoke(target, value);
                        }
                    } catch (Throwable ex) {
                        throw new FatalBeanException("Could not copy properties from source to target", ex);
                    }
                }
            }
        }
    }
}