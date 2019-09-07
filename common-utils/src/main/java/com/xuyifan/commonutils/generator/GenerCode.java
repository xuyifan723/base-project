package com.xuyifan.commonutils.generator;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/6 14:11
 * @Version 1.0
 */
public class GenerCode {
    public String tempUrl="";
    public String conProjectUrl="";
    public String controllerPackage="";
    public String serProjectUrl="";
    public String servicePackage="";
    public String daoProjectUrl="";
    public String daoPackage="";
    public String beanPackage="";
    public String mapperFile="";

    private static final String url = "jdbc:mysql://127.0.0.1:3306/data_manager?serverTimezone=Asia/Shanghai";
    private static final String name = "com.mysql.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "111111";
    private Connection connection;
    private void DBManager(String sql){
        try{
            Class.forName(name);
             connection = DriverManager.getConnection(url, username, password);
           // preparedStatement = connection.prepareStatement(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
