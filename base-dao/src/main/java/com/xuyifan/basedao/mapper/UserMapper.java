package com.xuyifan.basedao.mapper;


import com.xuyifan.basedao.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByLoginName(@Param("loginName") String loginName);

    User getUser(@Param("loginName") String loginName, @Param("password") String password);
}