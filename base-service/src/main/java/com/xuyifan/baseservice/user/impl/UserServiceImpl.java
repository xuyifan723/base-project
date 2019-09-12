package com.xuyifan.baseservice.user.impl;


import com.xuyifan.basedao.bean.UserBean;
import com.xuyifan.basedao.mapper.UserMapper;
import com.xuyifan.baseservice.user.UserService;
import com.xuyifan.commonutils.common.AESUtil;
import com.xuyifan.commonutils.common.CacheDataUtil;
import com.xuyifan.commonutils.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
/**
 * 功能描述:
 * @Param: [id]
 * @Return: com.xuyifan.basedao.bean.User
 * @Author: Xu yifan
 * @Date: 2019/9/11 14:07
 */
    @Override
    public UserBean getUserById(int id) {
        UserBean userInfo = CacheDataUtil.getValue(id, UserBean.class);
        if (userInfo==null){
             userInfo = userMapper.selectByPrimaryKey(id);
            CacheDataUtil.setValue(userInfo.getId(),userInfo);
        }
        return userInfo;
    }

    @Override
    public UserBean getUserByLoginName(String loginName) {
        UserBean userBean=new UserBean();
        userBean.setLoginName(loginName);
        List<UserBean> userInfos = userMapper.selectListBySelective(userBean);
        if (userInfos.size()>0){
            userBean=userInfos.get(0);
        }else {
            throw new BizException();
        }
        CacheDataUtil.setValue(userBean.getId(),userBean);
        return userBean;
    }

    @Override
    public UserBean validateUser(String loginName, String password) {
        UserBean userBean=new UserBean();
        userBean.setLoginName(loginName);
        userBean.setPassword(password);
        List<UserBean> users = userMapper.selectListBySelective(userBean);
        if (users.size()>0){
            userBean=users.get(0);
        }else {
            throw new BizException();
        }
        if (userBean!=null){
            CacheDataUtil.setValue(userBean.getId(),userBean);
        }
        userBean.setLoginName(AESUtil.encrypt(userBean.getLoginName()));
        userBean.setPassword(AESUtil.encrypt(userBean.getPassword()));
        return userBean;

    }
}
