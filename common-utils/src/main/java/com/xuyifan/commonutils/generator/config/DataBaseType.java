package com.xuyifan.commonutils.generator.config;

import java.util.Map;

/**
 * @author Xu yifan
 * @Ddecription 数据库字段类型对应java那个类型
 * @date 2019/9/9 11:30
 * @Version 1.0
 */
public class DataBaseType {

    private Map<String,String> typeData;
    public String getType(String type){
        return typeData.get(type);
    }

    public Map<String, String> getTypeData() {
        return typeData;
    }

    public void setTypeData(Map<String, String> typeData) {
        this.typeData = typeData;
    }
}
