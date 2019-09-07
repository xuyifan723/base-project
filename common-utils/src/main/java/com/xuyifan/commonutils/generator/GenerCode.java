package com.xuyifan.commonutils.generator;

import com.xuyifan.commonutils.generator.config.ConfigureParams;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/6 14:11
 * @Version 1.0
 */
public class GenerCode {
    public List<TableColumn> getTableColumn(String sql){
        List<TableColumn> data=new ArrayList<>();
        try{
            Class.forName(ConfigureParams.name);
            Connection connection = DriverManager.getConnection(ConfigureParams.url, ConfigureParams.username, ConfigureParams.password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,ConfigureParams.scahme);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                TableColumn column=new TableColumn();
                column.setTableName(rs.getString(1));
                column.setColName(rs.getString(2));
                column.setColType(rs.getString(3));
                column.setComment(rs.getString(4));
                data.add(column);
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
    public List<TableName> getTableName(String sql){
        List<TableName> data=new ArrayList<>();
        try {
            Class.forName(ConfigureParams.name);
            Connection connection = DriverManager.getConnection(ConfigureParams.url, ConfigureParams.username, ConfigureParams.password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,ConfigureParams.scahme);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                TableName table=new TableName();
                table.setTableName(rs.getString(1));
                table.setComment(rs.getString(2));
                data.add(table);
            }
           rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {
    DataHandle dataHandle=new DataHandle();
    dataHandle.init();
        for (TableName table : dataHandle.getTableName()) {
            StringHandle handle=new StringHandle();
            handle.setUserName("xuyifan");
            handle.setVersion("1.0");
            handle.setTableName(table);
            handle.setBeanPackage(ConfigureParams.beanPackage);
            handle.setColumns(dataHandle.getColData().get(table.getTableName()));
            BeanTemp beanTemp =new BeanTemp(handle);
            beanTemp.readFile();
        }
    }

}
