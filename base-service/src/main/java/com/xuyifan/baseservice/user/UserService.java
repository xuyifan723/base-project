package com.xuyifan.baseservice.user;

import com.xuyifan.basedao.bean.User;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/3 14:24
 * @Version 1.0
 */
public interface UserService {
    public User getUserById(int id);
    public User getUserByLoginName(String loginName);
    public boolean validateUser(String loginName,String password);
}
