package com.xuyifan.baseservice.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.xuyifan.baseservice.service.ResourcePermissionService;
import com.xuyifan.basedao.mapper.ResourcePermissionMapper;
import com.xuyifan.basedao.bean.ResourcePermissionBean;

/**
 * @author Xu yifan
 * @Ddecription 服务
 * @date 2019-09-19 08:44:48
 * @Version 1.0
 */
@Service
public class ResourcePermissionServiceImpl implements ResourcePermissionService {
    @Autowired
    private ResourcePermissionMapper resourcePermissionMapper;


    /**
     * 功能描述:通过id删除记录
     * @Param: [id]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public int deleteByPrimaryKey(Integer id){
       return resourcePermissionMapper.deleteByPrimaryKey(id);
    }
    /**
     * 功能描述:插入全部数据
     * @Param: [ResourcePermissionBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public int insert(ResourcePermissionBean record){
       return resourcePermissionMapper.insert(record);
    }
    /**
     * 功能描述:插入非空数据
     * @Param: [ResourcePermissionBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public int insertSelective(ResourcePermissionBean record){
       return resourcePermissionMapper.insertSelective(record);
     }
    /**
     * 功能描述:通过id查询记录
     * @Param: [id]
     * @Return: ResourcePermissionBean
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public ResourcePermissionBean selectByPrimaryKey(Integer id){
       return resourcePermissionMapper.selectByPrimaryKey(id);
     }
    /**
     * 功能描述:通过非空参数搜索list
     * @Param: [ResourcePermissionBean]
     * @Return: List<ResourcePermissionBean>
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public List<ResourcePermissionBean> selectListBySelective(ResourcePermissionBean record){
       return resourcePermissionMapper.selectListBySelective(record);
     }
     /**
      * 功能描述:通过id更新非空参数
      * @Param: [ResourcePermissionBean]
      * @Return: int
      * @Author: Xu yifan
      * @Date: 2019-09-19 08:44:48
      */
    @Override
    public int updateByPrimaryKeySelective(ResourcePermissionBean record){
      return resourcePermissionMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 功能描述:通过id更新记录
     * @Param: [ResourcePermissionBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public int updateByPrimaryKey(ResourcePermissionBean record){
      return resourcePermissionMapper.updateByPrimaryKey(record);
    }
}
