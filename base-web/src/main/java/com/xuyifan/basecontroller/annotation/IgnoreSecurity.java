package com.xuyifan.basecontroller.annotation;

import java.lang.annotation.*;
/**
 * 忽略用户验证
 * @Param:
 * @Return:
 * @Author: Xu yifan
 * @Date: 2019/8/12 16:23
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreSecurity {
}
