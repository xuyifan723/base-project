package com.xuyifan.projectinit.service.impl;

import com.xuyifan.projectinit.bean.DataDriverBean;
import com.xuyifan.projectinit.mapper.DataDriverMapper;
import com.xuyifan.projectinit.service.DataDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xuyifan
 * @Date: 2020/7/6
 */
@Service
public class DataDriverServiceImpl implements DataDriverService {
    @Autowired
    private DataDriverMapper dataDriverMapper;
    @Override
    public void addData(DataDriverBean dataDriverBean) {
        dataDriverMapper.addData(dataDriverBean);
    }

    @Override
    public void deleteData(Integer id) {
        dataDriverMapper.deleteData(id);
    }

    @Override
    public void updateData(DataDriverBean dataDriverBean) {
        dataDriverMapper.updateData(dataDriverBean);
    }

    @Override
    public DataDriverBean getData(Integer id) {
        return dataDriverMapper.getData(id);
    }

    @Override
    public List<DataDriverBean> getDatas(String databaseType) {
        return dataDriverMapper.getDatasByType(databaseType);
    }
}
