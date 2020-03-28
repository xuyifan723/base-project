package com.xuyifan.commonutils.generator.config;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/7 17:15
 * @Version 1.0
 */
public class ConfigureParams {
    public static String workspace="E:\\workspase\\base-project\\";
    public static String conProjectUrl=workspace+"base-web";
    public  static String controllerPackage="com.xuyifan.basecontroller.view";
    public  static String serProjectUrl=workspace+"base-service";
    public static  String servicePackage="com.xuyifan.baseservice.service";
    public  static String serImplProjectUrl=workspace+"base-service";
    public static  String serviceImplPackage="com.xuyifan.baseservice.service.impl";
    public static  String daoProjectUrl=workspace+"base-dao";
    public  static String daoPackage="com.xuyifan.basedao.mapper";
    public static  String beanProjectUrl=workspace+"base-dao";

    public static  String beanPackage="com.xuyifan.basedao.bean";
    //mapper的xml文件
    public  static String mapperFile=workspace+"base-web\\src\\main\\resources\\mapper";   //mapper的xml地址
   //数据库配置
    public static  String url = "jdbc:mysql://49.232.166.111:3306/data_manager?serverTimezone=Asia/Shanghai";
    public static  String name = "com.mysql.cj.jdbc.Driver";
    public static  String username = "root";
    public static  String password = "666666";
    //数据库的scahme
    public  static String scahme="data_manager";
   //用户
    public  static String devUserName="Xu yifan";
    //版本
    public  static String version="1.0";
//,"data_source","res_menu","resource_permission"
    //需要初始化那些表
    public static String[] tableList={"bus_user","bus_data_source","bus_resource_permission"};

    public static String [] ingoreStrs={"bus_"};
    //需要初始化那些数据
   public static String[] updateFile={ConfigureParams.BEAN_NAME,ConfigureParams.SERVICE_NAME,ConfigureParams.CONTROLLER_NAME};
   //实体类
    public final static String BEAN_NAME="BEANNAME";
    //服务层
    public final static String SERVICE_NAME="SERVICENAME";
    //视图层
    public final static String CONTROLLER_NAME="CONTROLLERNAME";

}
