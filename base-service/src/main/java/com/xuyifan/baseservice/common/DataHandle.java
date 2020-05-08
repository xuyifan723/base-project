package com.xuyifan.baseservice.common;

import com.xuyifan.basedao.bean.UserBean;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * @Author: xuyifan
 * @Date: 2020/5/8
 */
public class DataHandle {
    public static  void  addData(  Object data){
        Class dataClass = data.getClass();
        UserBean user = SysRequest.getUser();
        addCreatedId(data,dataClass,user.getId());
        addUpdatedId(data,dataClass,user.getId());
        addCreatedTime(data,dataClass);
        addUpdatedTime(data,dataClass);
    }

    public static void updateData(T data){
        Class<? extends T> dataClass = data.getClass();
        UserBean user = SysRequest.getUser();
        addUpdatedId(data,dataClass,user.getId());
        addUpdatedTime(data,dataClass);
    }

    private static void addCreatedId(Object data,Class<? extends T> dataClass,String userId){
        Field field = null;
        try {
            try {
                field = dataClass.getDeclaredField("createdId");
            } catch (Exception e) {
                Class<?> superclass = dataClass.getSuperclass();
                field = dataClass.getDeclaredField("createdId");
            }
            field.setAccessible(true);
            field.set(data,userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void addUpdatedId(Object data,Class<? extends T> dataClass,String userId){
        Field field = null;
        try {
            try {
                field = dataClass.getDeclaredField("updaterId");
            } catch (Exception e) {
                Class<?> superclass = dataClass.getSuperclass();
                field = dataClass.getDeclaredField("updaterId");
            }
            field.setAccessible(true);
            field.set(data,userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void addCreatedTime(Object data,Class<? extends T> dataClass){
        Field field = null;
        try {
            try {
                field = dataClass.getDeclaredField("createdTime");
            } catch (Exception e) {
                Class<?> superclass = dataClass.getSuperclass();
                field = dataClass.getDeclaredField("createdTime");
            }
            field.setAccessible(true);
            field.set(data,new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addUpdatedTime(Object data,Class<? extends T> dataClass){
        Field field = null;
        try {
            try {
                field = dataClass.getDeclaredField("updaterTime");
            } catch (Exception e) {
                Class<?> superclass = dataClass.getSuperclass();
                field = dataClass.getDeclaredField("updaterTime");
            }
            field.setAccessible(true);
            field.set(data,new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
