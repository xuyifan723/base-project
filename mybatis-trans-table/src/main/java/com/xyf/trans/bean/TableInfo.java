package com.xyf.trans.bean;

import java.util.List;

/**
 * @Author: xuyifan
 * @Date: 2020/6/1
 */
public class TableInfo {
    //表名
    private String tableName;
    //表空间
    private String schema;
   //索引
    private List<UniqueInfo> uniqueInfos;
    //字段
    private List<ColnumInfo> colnumInfos;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public List<UniqueInfo> getUniqueInfos() {
        return uniqueInfos;
    }

    public void setUniqueInfos(List<UniqueInfo> uniqueInfos) {
        this.uniqueInfos = uniqueInfos;
    }

    public List<ColnumInfo> getColnumInfos() {
        return colnumInfos;
    }

    public void setColnumInfos(List<ColnumInfo> colnumInfos) {
        this.colnumInfos = colnumInfos;
    }
}
