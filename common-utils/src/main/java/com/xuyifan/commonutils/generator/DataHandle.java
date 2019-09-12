package com.xuyifan.commonutils.generator;

import com.xuyifan.commonutils.generator.bean.TableColumn;
import com.xuyifan.commonutils.generator.bean.TableName;
import com.xuyifan.commonutils.generator.config.ConfigureParams;

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
    private Map<String, List<TableColumn>> colData = new HashMap<>();


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
     *
     * @Param: []
     * @Return: void
     * @Author: Xu yifan
     * @Date: 2019/9/9 8:35
     */
    public void init() {
        GenerCode generCode = new GenerCode();
        StringBuffer tableName = new StringBuffer(CommonParams.getTableNameSql);
        StringBuffer tableColName = new StringBuffer(CommonParams.getTableColumnSql);
        if (ConfigureParams.tableList.length > 0) {
            tableName.append(" and table_name in (");
            tableColName.append(" and table_name in (");
            boolean flag = true;
            for (String table : ConfigureParams.tableList) {
                if (flag){
                   flag=false;
                }else {
                    tableName.append(",");
                    tableColName.append(",");
                }
                tableName.append("\""+table+"\"");
                tableColName.append("\""+table+"\"");
            }
            tableName.append(")");
            tableColName.append(")");
        }

        this.tableName = generCode.getTableName(tableName.toString());
        List<TableColumn> tableColumn = generCode.getTableColumn(tableColName.toString());
        for (TableColumn column : tableColumn) {
            List<TableColumn> tableColumns = colData.get(column.getTableName());
            if (tableColumns == null) {
                tableColumns = new ArrayList<>();
                tableColumns.add(column);
            } else {
                tableColumns.add(column);
            }
            colData.put(column.getTableName(), tableColumns);
        }
    }


}
