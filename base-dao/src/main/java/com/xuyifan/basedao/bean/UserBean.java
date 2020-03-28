package com.xuyifan.basedao.bean;
import lombok.Data;
import java.util.Date;
/**
 * @author Xu yifan
 * @Ddecription 用户表
 * @date 2020-03-28 14:59:27
 * @Version 1.0
 */
@Data
public class UserBean {
    private Integer id;   //
    private String userName;   //用户姓名
    private String loginName;   //登陆名
    private String password;   //密码
    private String version;   //0以下代表删除，0及0以上代表版本
    private Integer createdId;   //创建者
    private Date createdTime;   //创建时间
    private Integer updaterId;   //更新者
    private Date updaterTime;   //更新时间
}
