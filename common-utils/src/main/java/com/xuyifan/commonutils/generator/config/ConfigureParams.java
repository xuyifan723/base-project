package com.xuyifan.commonutils.generator.config;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/7 17:15
 * @Version 1.0
 */
public class ConfigureParams {
    public static String conProjectUrl="F:\\myworkspace\\base-project\\base-web";
    public  static String controllerPackage="com.xuyifan.basecontroller.view";
    public  static String serProjectUrl="F:\\myworkspace\\base-project\\base-service";
    public static  String servicePackage="com.xuyifan.baseservice.service";
    public  static String serImplProjectUrl="F:\\myworkspace\\base-project\\base-service";
    public static  String serviceImplPackage="com.xuyifan.baseservice.service.impl";
    public static  String daoProjectUrl="F:\\myworkspace\\base-project\\base-dao";
    public  static String daoPackage="com.xuyifan.basedao.mapper";
    public static  String beanProjectUrl="F:\\myworkspace\\base-project\\base-dao";
    public static  String beanPackage="com.xuyifan.basedao.bean";
    public  static String mapperFile="F:\\myworkspace\\base-project\\base-web\\src\\main\\resources\\mapper";   //mapper的xml地址

    public static  String url = "jdbc:mysql://127.0.0.1:3306/data_manager?serverTimezone=Asia/Shanghai";
    public static  String name = "com.mysql.cj.jdbc.Driver";
    public static  String username = "root";
    public static  String password = "111111";
    public  static String scahme="data_manager";

    public  static String devUserName="Xu yifan";
    public  static String version="1.0";
//,"data_source","res_menu","resource_permission"
    public static String[] tableList={"user"};

}
