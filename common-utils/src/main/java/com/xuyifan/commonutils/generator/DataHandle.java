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
        //获取表名的sql
        StringBuffer tableName = new StringBuffer(CommonParams.getTableNameSql);
        //获取表字段的sql
        StringBuffer tableColName = new StringBuffer(CommonParams.getTableColumnSql);
        if (ConfigureParams.tableList.length > 0) {
            //sql的条件，查询的表名
            tableName.append(" and table_name in (");
            //sql的条件，查询的表名的字段
            tableColName.append(" and table_name in (");
            boolean flag = true;
            //将添加的表一个个的加入到条件里面去
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
        tableColName.append(" order by TABLE_NAME desc, ORDINAL_POSITION");
        //获取表信息
        this.tableName = generCode.getTableName(tableName.toString());
        //获取表的字段信息
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
