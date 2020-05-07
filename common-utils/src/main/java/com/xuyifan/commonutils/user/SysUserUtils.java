package com.xuyifan.commonutils.user;



/**
 * 从当前线程中取出数据
 */
public class SysUserUtils {
    static ThreadLocal localVar = new ThreadLocal<>();
    public static <T> void setVal(T t){
        localVar.set(t);
    }
    public static <T> T  getVal(Class<T> tClass){
        Object result = localVar.get();
        if (result==null){
            return null;
        }
        T t =(T) result;
        return t;
    }
}
