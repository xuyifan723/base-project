package com.xuyifan.projectinit.bean;

import lombok.Data;

/**数据信息
 * @Author: xuyifan
 * @Date: 2020/7/2
 */
@Data
public class DatabaseInfoBean {
    private Integer id ;
    private String name;
    private String url;
    private String userName;
    private String password;
    private String driver;
}
