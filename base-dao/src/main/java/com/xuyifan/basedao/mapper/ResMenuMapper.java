package com.xuyifan.basedao.mapper;

import com.xuyifan.basedao.bean.ResMenu;

public interface ResMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResMenu record);

    int insertSelective(ResMenu record);

    ResMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResMenu record);

    int updateByPrimaryKey(ResMenu record);
}