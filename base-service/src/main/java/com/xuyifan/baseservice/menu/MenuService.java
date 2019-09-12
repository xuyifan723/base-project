package com.xuyifan.baseservice.menu;


import com.xuyifan.basedao.bean.ResMenuBean;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/5 16:25
 * @Version 1.0
 */
public interface MenuService {
    int deleteByPrimaryKey(Integer id);

    int insert(ResMenuBean record);

    int insertSelective(ResMenuBean record);

    ResMenuBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResMenuBean record);

    int updateByPrimaryKey(ResMenuBean record);
}
