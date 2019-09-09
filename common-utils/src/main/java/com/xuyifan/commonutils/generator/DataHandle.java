package com.xuyifan.commonutils.generator;

import com.xuyifan.commonutils.generator.bean.TableColumn;
import com.xuyifan.commonutils.generator.bean.TableName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xu yifan
 * @Ddecription 数据处理类
 * @date 2019/9/7 17:03
 * @Version 1.0
 */
public class DataHandle {
    private List<TableName> tableName;
    private Map<String,List<TableColumn>> colData=new HashMap<>();


    public List<TableName> getTableName() {
        return tableName;
    }

    public void setTableName(List<TableName> tableName) {
        this.tableName = tableName;
    }

    public Map<String, List<TableColumn>> getColData() {
        return colData;
    }

    public void setColData(Map<String, List<TableColumn>> colData) {
        this.colData = colData;
    }
    /**
     * 功能描述:初始化，将字段名按照表名分配在一起
     * @Param: []
     * @Return: void
     * @Author: Xu yifan
     * @Date: 2019/9/9 8:35
     */
    public void init (){
        GenerCode generCode=new GenerCode();
       this.tableName = generCode.getTableName(CommonParams.getTableNameSql);
        List<TableColumn> tableColumn = generCode.getTableColumn(CommonParams.getTableColumnSql);
        for (TableColumn column : tableColumn) {
            List<TableColumn> tableColumns = colData.get(column.getTableName());
            if (tableColumns==null){
                tableColumns=new ArrayList<>();
                tableColumns.add(column);
            }else {
                tableColumns.add(column);
            }
            colData.put(column.getTableName(),tableColumns);
        }
    }








}
