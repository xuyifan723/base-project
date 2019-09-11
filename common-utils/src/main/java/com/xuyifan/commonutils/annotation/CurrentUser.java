package com.xuyifan.commonutils.annotation;

import java.lang.annotation.*;
/**
 * 用户注解
 * @Param:
 * @Return:
 * @Author: Xu yifan
 * @Date: 2019/8/12 16:23
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
}
