package com.xuyifan.projectinit.bean;

import lombok.Data;

/**表信息
 * @Author: xuyifan
 * @Date: 2020/7/2
 */
@Data
public class TableNameBean {
    private Integer id;
    private Integer dataBaseId;
    private String name;
    private String schema;
    private String comment;
}
