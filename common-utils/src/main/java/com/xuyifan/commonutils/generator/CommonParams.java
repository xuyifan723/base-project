package com.xuyifan.commonutils.generator;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/7 15:13
 * @Version 1.0
 */
public class CommonParams {
    public static final String getTableNameSql="select table_name,TABLE_COMMENT from information_schema.tables where table_schema= ? ";
    public static final String getTableColumnSql="select table_name, COLUMN_NAME, COLUMN_COMMENT, DATA_TYPE from INFORMATION_SCHEMA.Columns where table_schema= ?";
}
