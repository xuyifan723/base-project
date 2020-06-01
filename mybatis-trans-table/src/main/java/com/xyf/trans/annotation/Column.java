package com.xyf.trans.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: xuyifan
 * @Date: 2020/6/1
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    //字段名，默认字段名
    String name() default "";
    //字段类型，默认字段类型
    String type() default "";
    //字段类型，一般为字符串类型
    int length() default 255;
    //小数点后几位，默认两位
    int decimalLength() default 2;
    //是否允许为空
    boolean isNull() default true;
    //是否为主键
    boolean isKey() default false;
    //是否自动增长
    boolean isAutoIncrement() default false;
    //默认值
    String defaultValue() default "";
    //字段注释
    String comment() default "";
}
