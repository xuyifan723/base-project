package com.xuyifan.baseservice.user.impl;

import com.xuyifan.basedao.bean.User;
import com.xuyifan.basedao.mapper.UserMapper;
import com.xuyifan.baseservice.user.UserService;
import com.xuyifan.commonutils.common.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/3 14:25
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public User getUserByLoginName(String loginName) {
        User user = userMapper.getUserByLoginName(loginName);
        return user;
    }

    @Override
    public User validateUser(String loginName, String password) {
        User user = userMapper.getUser(loginName, password);
        user.setLoginName(AESUtil.encrypt(user.getLoginName()));
        user.setPassword(AESUtil.encrypt(user.getPassword()));
        return user;

    }
}
