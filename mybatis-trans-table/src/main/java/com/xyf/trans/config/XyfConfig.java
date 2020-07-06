package com.xyf.trans.config;

import com.xyf.trans.common.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * @Author: xuyifan
 * @Date: 2020/6/2
 */
@Service
public class XyfConfig implements ConfigHandle {
    private static ApplicationContext applicationContext;
    private Class clazz;
    @Value(Constants.TABLE_AUTO_TYPE)
    private String tableAuto;

    @Value(Constants.BEAN_PATH)
    private String modelPack;

    @Value(Constants.DATABASE_TYPE)
    private String databaseType;

    public XyfConfig(Class clazz) {
        this.clazz = clazz;
    }

    public static Object getBean(String beanName) {
        try {
            return applicationContext.getBean(beanName);
        } catch (Exception e) {
            return null;
        }
    }
    public String getConfigValue(String key){
        try {
            Resource[] keys = applicationContext.getResources("key");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void handle(){
        Annotation[] annotations = this.clazz.getAnnotations();

        System.out.println(annotations.length+"wobuzd");
    }
}
