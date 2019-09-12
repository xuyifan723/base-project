package com.xuyifan.basedao.mapper;
import java.util.List;
import com.xuyifan.basedao.bean.ResMenuBean;
/**
 * @author Xu yifan
 * @Ddecription mapper
 * @date 2019-09-12 16:26:56
 * @Version 1.0
 */
public interface ResMenuMapper {
    //通过id删除记录
    int deleteByPrimaryKey(Integer id);
    //插入全部数据
    int insert(ResMenuBean record);
    //插入非空数据
    int insertSelective(ResMenuBean record);
    //通过id查询记录
    ResMenuBean selectByPrimaryKey(Integer id);
    //通过非空参数搜索list
    List<ResMenuBean> selectListBySelective(ResMenuBean record);
    //通过id更新非空参数
    int updateByPrimaryKeySelective(ResMenuBean record);
    //通过id更新记录
    int updateByPrimaryKey(ResMenuBean record);
}
