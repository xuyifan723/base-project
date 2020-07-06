package com.xuyifan.projectinit.enums;

/**
 * @Author: xuyifan
 * @Date: 2020/7/2
 */
public enum DriverType {
    MYSQL("mysql","com.mysql.cj.jdbc.Driver"),
    ORACLE("oracle","oracle.jdbc.driver.OracleDriver");

    String name;
    String driverClassName;

    DriverType(String name, String driverClassName) {
        this.name = name;
        this.driverClassName = driverClassName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
