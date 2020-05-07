package com.xuyifan.basedao.mapper;

import com.xuyifan.basedao.bean.UserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author Xu yifan
 * @Ddecription mapper
 * @date 2020-05-06 17:40:22
 * @Version 1.0
 */
public interface UserMapper {
    //通过id删除记录
    int deleteByPrimaryKey(String id);
    //插入全部数据
    int insert(UserBean record);
    //插入非空数据
    int insertSelective(UserBean record);
    //通过id查询记录
    UserBean selectByPrimaryKey(String id);
    //通过非空参数搜索list
    List<UserBean> selectListBySelective(UserBean record);
    //通过id更新非空参数
    int updateByPrimaryKeySelective(UserBean record);
    //通过id更新记录
    int updateByPrimaryKey(UserBean record);

    UserBean getUserByUserPassword(@Param("loginName") String loginName, @Param("password") String password);
}
