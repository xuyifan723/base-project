package com.xuyifan.basedao.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/3 14:00
 * @Version 1.0
 */
@Data
public class User {
    private Integer id;

    private String userName;

    private String loginName;

    private String password;

    private Integer version;

    private String created;

    private Date createdTime;

    private String updated;

    private Date updatedTime;
}
