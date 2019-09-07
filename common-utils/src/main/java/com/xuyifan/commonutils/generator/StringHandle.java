package com.xuyifan.commonutils.generator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/7 16:02
 * @Version 1.0
 */
public class StringHandle {
    private String userName;
    private String version;
    private TableName tableName;
    private List<TableColumn> columns;
    private String beanPackage;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public TableName getTableName() {
        return tableName;
    }

    public void setTableName(TableName tableName) {
        this.tableName = tableName;
    }

    public List<TableColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<TableColumn> columns) {
        this.columns = columns;
    }

    public String getBeanPackage() {
        return beanPackage;
    }

    public void setBeanPackage(String beanPackage) {
        this.beanPackage = beanPackage;
    }

    public String handleStr(String str){
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        Map<String,String> regex=new HashMap<>();
        regex.put("\\$\\{USERNAME}",userName);
        regex.put("\\$\\{TABLEComment}",tableName.getComment());
        regex.put("\\$\\{DATE}",format);
        regex.put("\\$\\{VERSION}",version);
        regex.put("%TABLE%",tableName.getTableName());
        regex.put("%beanPackage%",beanPackage);
        for (String key : regex.keySet()) {
            str=str.replaceAll(key,regex.get(key));
        }
        return str;
    }

    public static void main(String[] args) {
        String str="* @author %TABLE%";
        String ske  = str.replaceAll("%TABLE%", "333");
        System.out.println(ske);
    }
}
