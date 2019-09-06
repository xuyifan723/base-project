package com.xuyifan.baseservice.user.impl;

import com.xuyifan.basedao.bean.User;
import com.xuyifan.basedao.mapper.UserMapper;
import com.xuyifan.baseservice.user.UserService;
import com.xuyifan.commonutils.common.AESUtil;
import com.xuyifan.commonutils.common.CacheDataUtil;
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
        User userInfo = CacheDataUtil.getValue(id, User.class);
        if (userInfo==null){
             userInfo = userMapper.selectByPrimaryKey(id);
            CacheDataUtil.setValue(userInfo.getId(),userInfo);
        }
        return userInfo;
    }

    @Override
    public User getUserByLoginName(String loginName) {
        User userInfo = userMapper.getUserByLoginName(loginName);
        CacheDataUtil.setValue(userInfo.getId(),userInfo);
        return userInfo;
    }

    @Override
    public User validateUser(String loginName, String password) {
        User user = userMapper.getUser(loginName, password);
        if (user!=null){
            CacheDataUtil.setValue(user.getId(),user);
        }
        user.setLoginName(AESUtil.encrypt(user.getLoginName()));
        user.setPassword(AESUtil.encrypt(user.getPassword()));
        return user;

    }
}
