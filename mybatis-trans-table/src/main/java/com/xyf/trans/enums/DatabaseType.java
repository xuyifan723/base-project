package com.xyf.trans.enums;

/**
 * @Author: xuyifan
 * @Date: 2020/6/1
 */
public enum DatabaseType {
    MYSQL("mysql"),
    ORACLE("oracle");
    String name;
    DatabaseType(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
