package com.xuyifan.basedao.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author Xu yifan
 * @Ddecription
 * @date 2020-03-28 14:59:27
 * @Version 1.0
 */
@Data
public class DataSourceBean {
    private Integer id;   //
    private String name;   //数据源名称
    private Integer username;   //数据源用户名
    private String password;   //密码
    private String url;   //数据url
    private String driverName;   //数据库驱动
    private Integer version;   //0以下代表删除，0及0以上代表版本
    private String created;   //创建人
    private Date createdTime;   //创建时间
    private String updated;   //更新人
    private Date updatedTime;   //更新时间
}
