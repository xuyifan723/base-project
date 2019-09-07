package com.xuyifan.commonutils.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xu yifan
 * @Ddecription 待写
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
