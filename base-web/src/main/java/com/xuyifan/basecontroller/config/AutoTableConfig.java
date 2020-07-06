package com.xuyifan.basecontroller.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Author: xuyifan
 * @Date: 2020/6/2
 */
@Configuration
public class AutoTableConfig implements BeanPostProcessor {
    @PostConstruct
    public void  test(){

        System.out.println("test3");

    }
}
