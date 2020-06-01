package com.xyf.trans.annotation;

import com.xyf.trans.enums.UniqueType;

import java.lang.annotation.*;

/**索引
 * @Author: xuyifan
 * @Date: 2020/6/1
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Unique {
    //那几个字段
    public String[] columns() default {};
    //索引名称
    public String name() default "";
    //索引类型
    public UniqueType type() default UniqueType.NORMAL;
}
