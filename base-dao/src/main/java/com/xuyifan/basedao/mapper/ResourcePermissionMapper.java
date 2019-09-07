package com.xuyifan.basedao.mapper;

import com.xuyifan.basedao.bean.ResourcePermission;

public interface ResourcePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResourcePermission record);

    int insertSelective(ResourcePermission record);

    ResourcePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResourcePermission record);

    int updateByPrimaryKey(ResourcePermission record);
}