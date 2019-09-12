package com.xuyifan.baseservice.menu.impl;


import com.xuyifan.basedao.bean.ResMenuBean;
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
    public int insert(ResMenuBean record) {
        return resMenuMapper.insert( record);
    }

    @Override
    public int insertSelective(ResMenuBean record) {
        return resMenuMapper.insertSelective( record);
    }

    @Override
    public ResMenuBean selectByPrimaryKey(Integer id) {
        return resMenuMapper.selectByPrimaryKey( id);
    }

    @Override
    public int updateByPrimaryKeySelective(ResMenuBean record) {
        return resMenuMapper.updateByPrimaryKeySelective( record);
    }

    @Override
    public int updateByPrimaryKey(ResMenuBean record) {
        return resMenuMapper.updateByPrimaryKey( record);
    }
}
