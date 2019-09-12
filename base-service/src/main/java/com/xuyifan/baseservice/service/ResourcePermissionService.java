package com.xuyifan.baseservice.service;
import java.util.List;
import com.xuyifan.basedao.mapper.ResourcePermissionMapper;
import com.xuyifan.basedao.bean.ResourcePermissionBean;

/**
 * @author Xu yifan
 * @Ddecription 服务
 * @date 2019-09-12 16:50:08
 * @Version 1.0
 */
public interface ResourcePermissionService {
    /**
     * 功能描述:通过id删除记录
     * @Param: [id]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-12 16:50:08
     */
    public int deleteByPrimaryKey(Integer id);
    /**
     * 功能描述:插入全部数据
     * @Param: [ResourcePermissionBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-12 16:50:08
     */
    public int insert(ResourcePermissionBean record);
    /**
     * 功能描述:插入非空数据
     * @Param: [ResourcePermissionBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-12 16:50:08
     */
    public int insertSelective(ResourcePermissionBean record);
    /**
     * 功能描述:通过id查询记录
     * @Param: [id]
     * @Return: ResourcePermissionBean
     * @Author: Xu yifan
     * @Date: 2019-09-12 16:50:08
     */
    public ResourcePermissionBean selectByPrimaryKey(Integer id);
    /**
     * 功能描述:通过非空参数搜索list
     * @Param: [ResourcePermissionBean]
     * @Return: List<ResourcePermissionBean>
     * @Author: Xu yifan
     * @Date: 2019-09-12 16:50:08
     */
    public List<ResourcePermissionBean> selectListBySelective(ResourcePermissionBean record);
     /**
      * 功能描述:通过id更新非空参数
      * @Param: [ResourcePermissionBean]
      * @Return: int
      * @Author: Xu yifan
      * @Date: 2019-09-12 16:50:08
      */
    public int updateByPrimaryKeySelective(ResourcePermissionBean record);
    /**
     * 功能描述:通过id更新记录
     * @Param: [ResourcePermissionBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-12 16:50:08
     */
    public int updateByPrimaryKey(ResourcePermissionBean record);
}
