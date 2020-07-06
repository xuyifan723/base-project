package com.xuyifan.projectinit.service.impl;

import com.xuyifan.projectinit.bean.DatabaseInfoBean;
import com.xuyifan.projectinit.mapper.DatabaseInfoMapper;
import com.xuyifan.projectinit.service.DatabaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xuyifan
 * @Date: 2020/7/6
 */
@Service
public class DatabaseInfoServiceImpl implements DatabaseInfoService {
    @Autowired
    private DatabaseInfoMapper databaseInfoMapper;
    @Override
    public void addData(DatabaseInfoBean databaseInfoBean) {
        databaseInfoMapper.addData(databaseInfoBean);
    }

    @Override
    public void deleteData(Integer id) {
        databaseInfoMapper.deleteData(id);
    }

    @Override
    public void updateData(DatabaseInfoBean databaseInfoBean) {
        databaseInfoMapper.updateData(databaseInfoBean);
    }

    @Override
    public DatabaseInfoBean getData(Integer id) {
        return databaseInfoMapper.getData(id);
    }

    @Override
    public List<DatabaseInfoBean> getDatasLikeName(String name) {
        return databaseInfoMapper.getDatasByLike(name);
    }
}
