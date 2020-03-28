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
    //mapper的xml文件
    public  static String mapperFile="F:\\myworkspace\\base-project\\base-web\\src\\main\\resources\\mapper";   //mapper的xml地址
   //数据库配置
    public static  String url = "jdbc:mysql://127.0.0.1:3306/data_manager?serverTimezone=Asia/Shanghai";
    public static  String name = "com.mysql.cj.jdbc.Driver";
    public static  String username = "root";
    public static  String password = "111111";
    //数据库的scahme
    public  static String scahme="data_manager";
   //用户
    public  static String devUserName="Xu yifan";
    //版本
    public  static String version="1.0";
//,"data_source","res_menu","resource_permission"
    //需要初始化那些表
    public static String[] tableList={"user"};
    //需要初始化那些数据
   public static String[] updateFile={ConfigureParams.BEAN_NAME,ConfigureParams.SERVICE_NAME,ConfigureParams.CONTROLLER_NAME};
   //实体类
    public final static String BEAN_NAME="BEANNAME";
    //服务层
    public final static String SERVICE_NAME="SERVICENAME";
    //视图层
    public final static String CONTROLLER_NAME="CONTROLLERNAME";

}
