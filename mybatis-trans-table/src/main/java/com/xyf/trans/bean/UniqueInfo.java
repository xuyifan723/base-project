package com.xyf.trans.bean;

import com.xyf.trans.enums.UniqueType;

/**
 * @Author: xuyifan
 * @Date: 2020/6/1
 */
public class UniqueInfo {
    private String name;
    private UniqueType type;
    private String [] colnums;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UniqueType getType() {
        return type;
    }

    public void setType(UniqueType type) {
        this.type = type;
    }

    public String[] getColnums() {
        return colnums;
    }

    public void setColnums(String[] colnums) {
        this.colnums = colnums;
    }
}
