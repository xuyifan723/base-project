package com.xuyifan.commonutils.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xu yifan
 * @Ddecription 缓存类
 * @date 2019/9/6 10:44
 * @Version 1.0
 */
public class CacheDataUtil {
    public static final Map<Integer,Object> CACHEDATA=new  HashMap();

    public static <T> T getValue(Integer key,Class<T> tClass){
        T o = (T)CACHEDATA.get(key);
        return o;
    }
    public static void setValue(Integer key,Object value){
        CACHEDATA.put(key,value);
    }
}
