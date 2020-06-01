package com.xuyifan.commonutils.annotation;

import java.lang.annotation.*;

/**
 * @Author: xuyifan
 * @Date: 2020/5/15
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreColnum {
}
