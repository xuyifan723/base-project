package com.xuyifan.baseservice.menu.impl;

import com.xuyifan.basedao.bean.ResMenu;
import com.xuyifan.basedao.mapper.ResMenuMapper;
import com.xuyifan.baseservice.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/5 16:25
 * @Version 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private ResMenuMapper resMenuMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return resMenuMapper.deleteByPrimaryKey( id);
    }

    @Override
    public int insert(ResMenu record) {
        return resMenuMapper.insert( record);
    }

    @Override
    public int insertSelective(ResMenu record) {
        return resMenuMapper.insertSelective( record);
    }

    @Override
    public ResMenu selectByPrimaryKey(Integer id) {
        return resMenuMapper.selectByPrimaryKey( id);
    }

    @Override
    public int updateByPrimaryKeySelective(ResMenu record) {
        return resMenuMapper.updateByPrimaryKeySelective( record);
    }

    @Override
    public int updateByPrimaryKey(ResMenu record) {
        return resMenuMapper.updateByPrimaryKey( record);
    }
}
