package com.xuyifan.baseservice.user;

import com.xuyifan.basedao.bean.UserBean;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/3 14:24
 * @Version 1.0
 */
public interface UserService {
    public UserBean getUserById(int id);
    public UserBean getUserByLoginName(String loginName);
    public UserBean validateUser(String loginName,String password);
}
