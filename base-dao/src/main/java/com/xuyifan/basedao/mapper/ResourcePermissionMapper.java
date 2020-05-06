package com.xuyifan.basedao.mapper;
import com.xuyifan.basedao.bean.ResourcePermissionBean;

import java.util.List;
/**
 * @author Xu yifan
 * @Ddecription mapper
 * @date 2020-05-06 17:40:22
 * @Version 1.0
 */
public interface ResourcePermissionMapper {
    //通过id删除记录
    int deleteByPrimaryKey(String id);
    //插入全部数据
    int insert(ResourcePermissionBean record);
    //插入非空数据
    int insertSelective(ResourcePermissionBean record);
    //通过id查询记录
    ResourcePermissionBean selectByPrimaryKey(String id);
    //通过非空参数搜索list
    List<ResourcePermissionBean> selectListBySelective(ResourcePermissionBean record);
    //通过id更新非空参数
    int updateByPrimaryKeySelective(ResourcePermissionBean record);
    //通过id更新记录
    int updateByPrimaryKey(ResourcePermissionBean record);
}
