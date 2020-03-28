package com.xuyifan.baseservice.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.xuyifan.baseservice.service.UserService;
import com.xuyifan.basedao.mapper.UserMapper;
import com.xuyifan.basedao.bean.UserBean;

/**
 * @author Xu yifan
 * @Ddecription 服务
 * @date 2019-09-19 08:44:48
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    /**
     * 功能描述:通过id删除记录
     * @Param: [id]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public int deleteByPrimaryKey(Integer id){
       return userMapper.deleteByPrimaryKey(id);
    }
    /**
     * 功能描述:插入全部数据
     * @Param: [UserBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public int insert(UserBean record){
       return userMapper.insert(record);
    }
    /**
     * 功能描述:插入非空数据
     * @Param: [UserBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public int insertSelective(UserBean record){
       return userMapper.insertSelective(record);
     }
    /**
     * 功能描述:通过id查询记录
     * @Param: [id]
     * @Return: UserBean
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public UserBean selectByPrimaryKey(Integer id){
       return userMapper.selectByPrimaryKey(id);
     }
    /**
     * 功能描述:通过非空参数搜索list
     * @Param: [UserBean]
     * @Return: List<UserBean>
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public List<UserBean> selectListBySelective(UserBean record){
       return userMapper.selectListBySelective(record);
     }
     /**
      * 功能描述:通过id更新非空参数
      * @Param: [UserBean]
      * @Return: int
      * @Author: Xu yifan
      * @Date: 2019-09-19 08:44:48
      */
    @Override
    public int updateByPrimaryKeySelective(UserBean record){
      return userMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 功能描述:通过id更新记录
     * @Param: [UserBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public int updateByPrimaryKey(UserBean record){
      return userMapper.updateByPrimaryKey(record);
    }
}