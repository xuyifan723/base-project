package com.xuyifan.basedao.mapper;


import com.xuyifan.basedao.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByLoginName(String loginName);

    User getUser(String loginName, String password);
}