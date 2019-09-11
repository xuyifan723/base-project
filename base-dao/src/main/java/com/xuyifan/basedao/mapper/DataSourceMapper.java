package com.xuyifan.basedao.mapper;

import com.xuyifan.basedao.bean.DataSource;

import java.util.List;

public interface DataSourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataSource record);

    int insertSelective(DataSource record);

    DataSource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataSource record);
    int updateByPrimaryKey(DataSource record);
}