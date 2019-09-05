package com.xuyifan.baseservice.menu;

import com.xuyifan.basedao.bean.ResMenu;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/5 16:25
 * @Version 1.0
 */
public interface MenuService {
    int deleteByPrimaryKey(Integer id);

    int insert(ResMenu record);

    int insertSelective(ResMenu record);

    ResMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResMenu record);

    int updateByPrimaryKey(ResMenu record);
}
