package com.xuyifan.basedao.mapper;
import com.xuyifan.basedao.bean.MenuBean;

import java.util.List;
/**
 * @author Xu yifan
 * @Ddecription mapper
 * @date 2020-05-06 17:40:22
 * @Version 1.0
 */
public interface MenuMapper {
    //通过id删除记录
    int deleteByPrimaryKey(String id);
    //插入全部数据
    int insert(MenuBean record);
    //插入非空数据
    int insertSelective(MenuBean record);
    //通过id查询记录
    MenuBean selectByPrimaryKey(String id);
    //通过非空参数搜索list
    List<MenuBean> selectListBySelective(MenuBean record);
    //通过id更新非空参数
    int updateByPrimaryKeySelective(MenuBean record);
    //通过id更新记录
    int updateByPrimaryKey(MenuBean record);
}
