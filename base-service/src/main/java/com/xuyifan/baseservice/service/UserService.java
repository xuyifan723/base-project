package com.xuyifan.baseservice.service;
import com.xuyifan.basedao.bean.UserBean;

import java.util.List;

/**
 * @author Xu yifan
 * @Ddecription 服务
 * @date 2020-05-06 17:40:22
 * @Version 1.0
 */
public interface UserService {
    /**
     * 功能描述:通过id删除记录
     * @Param: [id]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    public int deleteByPrimaryKey(String id);
    /**
     * 功能描述:插入全部数据
     * @Param: [UserBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    public int insert(UserBean record);
    /**
     * 功能描述:插入非空数据
     * @Param: [UserBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    public int insertSelective(UserBean record);
    /**
     * 功能描述:通过id查询记录
     * @Param: [id]
     * @Return: UserBean
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    public UserBean selectByPrimaryKey(String id);
    /**
     * 功能描述:通过非空参数搜索list
     * @Param: [UserBean]
     * @Return: List<UserBean>
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    public List<UserBean> selectListBySelective(UserBean record);
     /**
      * 功能描述:通过id更新非空参数
      * @Param: [UserBean]
      * @Return: int
      * @Author: Xu yifan
      * @Date: 2020-05-06 17:40:22
      */
    public int updateByPrimaryKeySelective(UserBean record);
    /**
     * 功能描述:通过id更新记录
     * @Param: [UserBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    public int updateByPrimaryKey(UserBean record);

    UserBean getUserByUserPassword(String userName, String password);
}
