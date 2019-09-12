package com.xuyifan.commonutils.generator;

import com.xuyifan.commonutils.generator.bean.TableColumn;
import com.xuyifan.commonutils.generator.bean.TableName;
import com.xuyifan.commonutils.generator.config.ConfigureParams;
import com.xuyifan.commonutils.generator.temp.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/6 14:11
 * @Version 1.0
 */
public class GenerCode {
    /**
     * 功能描述:通过sql获取表名，字段名，字段类型和注释
     * @Param: [sql]
     * @Return: java.util.List<com.xuyifan.commonutils.generator.bean.TableColumn>
     * @Author: Xu yifan
     * @Date: 2019/9/9 8:34
     */
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
                column.setComment(rs.getString(3));
                column.setColType(rs.getString(4));

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
    /**
     * 功能描述:通过sql获取表名和注释
     * @Param: [sql]
     * @Return: java.util.List<com.xuyifan.commonutils.generator.bean.TableName>
     * @Author: Xu yifan
     * @Date: 2019/9/9 8:34
     */
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

    public static void main(String[] args) throws IOException {
    DataHandle dataHandle=new DataHandle();
    dataHandle.init();
        for (TableName table : dataHandle.getTableName()) {
            System.out.println("****************************");
            BeanTemp beanTemp =new BeanTemp(table,dataHandle.getColData().get(table.getTableName()));
            beanTemp.writeFile();
            MapperTemp mapperTemp=new MapperTemp(table,dataHandle.getColData().get(table.getTableName()));
            mapperTemp.writeFile();
            ServiceImplTemp serviceImplTemp=new ServiceImplTemp(table,dataHandle.getColData().get(table.getTableName()));
            serviceImplTemp.writeFile();
            ServiceTemp serviceTemp=new ServiceTemp(table,dataHandle.getColData().get(table.getTableName()));
            serviceTemp.writeFile();
            ControllerTemp controllerTemp=new ControllerTemp(table,dataHandle.getColData().get(table.getTableName()));
            controllerTemp.writeFile();
            MapperFileTemp mapperFileTemp=new MapperFileTemp(table,dataHandle.getColData().get(table.getTableName()));
            mapperFileTemp.writeFile();
            System.out.println("****************************");
        }
    }

}
