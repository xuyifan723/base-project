package com.xuyifan.projectinit.bean;

import lombok.Data;

/**表字段信息
 * @Author: xuyifan
 * @Date: 2020/7/2
 */
@Data
public class ColumnNameBean {
    private Integer id;
    private Integer tableId;
    private String columnName;
    private String columnType;
    private String comment;
}
