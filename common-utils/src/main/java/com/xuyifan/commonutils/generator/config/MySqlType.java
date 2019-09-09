package com.xuyifan.commonutils.generator.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xu yifan
 * @Ddecription mysql字段类型对应java那个类型
 * @date 2019/9/9 11:28
 * @Version 1.0
 */
public class MySqlType extends DataBaseType {
    public MySqlType() {
        this.init();
    }

    private Map<String,String> typeData;
    public String getType(String type){
         return typeData.get(type);
    }
    private void init (){
       this.typeData =new HashMap<>();
       typeData.put("varchar","String");
        typeData.put("int","Integer");
        typeData.put("datetime","Date");
    }
}
