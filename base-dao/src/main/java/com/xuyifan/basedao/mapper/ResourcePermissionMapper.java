package com.xuyifan.basedao.mapper;
import java.util.List;
import com.xuyifan.basedao.bean.ResourcePermissionBean;
/**
 * @author Xu yifan
 * @Ddecription mapper
 * @date 2019-09-12 16:50:08
 * @Version 1.0
 */
public interface ResourcePermissionMapper {
    //通过id删除记录
    int deleteByPrimaryKey(Integer id);
    //插入全部数据
    int insert(ResourcePermissionBean record);
    //插入非空数据
    int insertSelective(ResourcePermissionBean record);
    //通过id查询记录
    ResourcePermissionBean selectByPrimaryKey(Integer id);
    //通过非空参数搜索list
    List<ResourcePermissionBean> selectListBySelective(ResourcePermissionBean record);
    //通过id更新非空参数
    int updateByPrimaryKeySelective(ResourcePermissionBean record);
    //通过id更新记录
    int updateByPrimaryKey(ResourcePermissionBean record);
}
