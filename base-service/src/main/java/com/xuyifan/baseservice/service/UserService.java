package com.xuyifan.baseservice.service;

import com.xuyifan.basedao.bean.UserBean;

import java.util.List;

/**
 * @author Xu yifan
 * @Ddecription 用户表服务
 * @date 2020-03-28 14:59:27
 * @Version 1.0
 */
public interface UserService {
    /**
     * 功能描述:通过id删除记录
     *
     * @Param: [id]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    public int deleteByPrimaryKey(Integer id);

    /**
     * 功能描述:插入全部数据
     *
     * @Param: [UserBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    public int insert(UserBean record);

    /**
     * 功能描述:插入非空数据
     *
     * @Param: [UserBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    public int insertSelective(UserBean record);

    /**
     * 功能描述:通过id查询记录
     *
     * @Param: [id]
     * @Return: UserBean
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    public UserBean selectByPrimaryKey(Integer id);

    /**
     * 功能描述:通过非空参数搜索list
     *
     * @Param: [UserBean]
     * @Return: List<UserBean>
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    public List<UserBean> selectListBySelective(UserBean record);

    /**
     * 功能描述:通过id更新非空参数
     *
     * @Param: [UserBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    public int updateByPrimaryKeySelective(UserBean record);

    /**
     * 功能描述:通过id更新记录
     *
     * @Param: [UserBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    public int updateByPrimaryKey(UserBean record);

    public UserBean getUserByUserPassword(String userName, String password);

    public UserBean getUserById(Integer userId);
}
