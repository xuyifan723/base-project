package com.xuyifan.basedao.mapper;
import com.xuyifan.basedao.bean.DataSourceBean;

import java.util.List;
/**
 * @author Xu yifan
 * @Ddecription mapper
 * @date 2020-05-06 17:40:22
 * @Version 1.0
 */
public interface DataSourceMapper {
    //通过id删除记录
    int deleteByPrimaryKey(String id);
    //插入全部数据
    int insert(DataSourceBean record);
    //插入非空数据
    int insertSelective(DataSourceBean record);
    //通过id查询记录
    DataSourceBean selectByPrimaryKey(String id);
    //通过非空参数搜索list
    List<DataSourceBean> selectListBySelective(DataSourceBean record);
    //通过id更新非空参数
    int updateByPrimaryKeySelective(DataSourceBean record);
    //通过id更新记录
    int updateByPrimaryKey(DataSourceBean record);
}
