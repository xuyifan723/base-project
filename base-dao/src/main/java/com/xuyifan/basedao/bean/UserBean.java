package com.xuyifan.basedao.bean;
import lombok.Data;
import java.util.Date;
/**
 * @author Xu yifan
 * @Ddecription 
 * @date 2020-05-06 17:40:22
 * @Version 1.0
 */
@Data
public class UserBean {
    private String id;   //
    private String userName;   //
    private String loginName;   //
    private String password;   //
    private Integer version;   //
    private String createdId;   //
    private Date createdTime;   //
    private String updaterId;   //
    private Date updaterTime;   //
}
