package com.xuyifan.projectinit.bean;

import lombok.Data;

/**
 * @Author: xuyifan
 * @Date: 2020/8/5
 */
@Data
public class DatabaseTypeBean {
    private String id;
    private String name;
    private String driverClassName;
    private Boolean switchFlag;
}
