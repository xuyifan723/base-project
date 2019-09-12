package com.xuyifan.basedao.mapper;
import java.util.List;
import com.xuyifan.basedao.bean.DataSourceBean;
/**
 * @author Xu yifan
 * @Ddecription 数据源mapper
 * @date 2019-09-12 16:26:56
 * @Version 1.0
 */
public interface DataSourceMapper {
    //通过id删除记录
    int deleteByPrimaryKey(Integer id);
    //插入全部数据
    int insert(DataSourceBean record);
    //插入非空数据
    int insertSelective(DataSourceBean record);
    //通过id查询记录
    DataSourceBean selectByPrimaryKey(Integer id);
    //通过非空参数搜索list
    List<DataSourceBean> selectListBySelective(DataSourceBean record);
    //通过id更新非空参数
    int updateByPrimaryKeySelective(DataSourceBean record);
    //通过id更新记录
    int updateByPrimaryKey(DataSourceBean record);
}
