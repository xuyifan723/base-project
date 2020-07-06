package com.xyf.trans.bean;

import com.xyf.trans.enums.SqlType;

/**
 * @Author: xuyifan
 * @Date: 2020/6/1
 */
public class ColnumInfo {
     //字段名称
    private String name;
    //字段排序
    private int ord;
    //字段类型
    private SqlType type;
    //字段是否允许为空
    private boolean isNull;
    //字段是否自增长
    private boolean isAutoIncrement;
    //是否为主键
    private boolean isKey;
    //字段长度
    private int length;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrd() {
        return ord;
    }

    public void setOrd(int ord) {
        this.ord = ord;
    }

    public SqlType getType() {
        return type;
    }

    public void setType(SqlType type) {
        this.type = type;
    }

    public boolean isNull() {
        return isNull;
    }

    public void setNull(boolean aNull) {
        isNull = aNull;
    }

    public boolean isAutoIncrement() {
        return isAutoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        isAutoIncrement = autoIncrement;
    }

    public boolean isKey() {
        return isKey;
    }

    public void setKey(boolean key) {
        isKey = key;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
