package com.xuyifan.commonutils.generator.bean;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/7 15:29
 * @Version 1.0
 */
public class TableColumn {
    private String tableName;
    private String colName;
    private String colType;
    private String comment;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
