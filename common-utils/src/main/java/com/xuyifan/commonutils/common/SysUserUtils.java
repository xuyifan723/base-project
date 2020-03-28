package com.xuyifan.commonutils.common;



import java.util.Set;

/**
 * 从当前线程中取出数据
 */
public class SysUserUtils {
    static ThreadLocal localVar = new ThreadLocal<>();
    public static <T> void setVal(T t){
        localVar.set(t);
    }
    public static <T> T  getVal(Class<T> tClass){
        T t =(T) localVar.get();
        return t;
    }
}
