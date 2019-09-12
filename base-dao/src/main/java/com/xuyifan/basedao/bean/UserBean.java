package com.xuyifan.basedao.bean;
import lombok.Data;
import java.util.Date;
/**
 * @author Xu yifan
 * @Ddecription 
 * @date 2019-09-12 16:50:08
 * @Version 1.0
 */
@Data
public class UserBean {
    private String created;   //
    private Date createdTime;   //创建时间
    private Integer id;   //
    private String loginName;   //登陆名
    private String password;   //密码
    private String updated;   //
    private Date updatedTime;   //
    private String userName;   //用户姓名
    private Integer version;   //0以下代表删除，0及0以上代表版本
}
