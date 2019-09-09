package com.xuyifan.commonutils.generator.config;

/**
 * @author Xu yifan
 * @Ddecription 获取不用数据库的数据类型转换
 * @date 2019/9/9 11:29
 * @Version 1.0
 */
public class DataBaseTpyeFactory {
    public static DataBaseType getType(String type){
        if (type.equals("mysql")){
            return new MySqlType();
        }
        return null;
    }
}
