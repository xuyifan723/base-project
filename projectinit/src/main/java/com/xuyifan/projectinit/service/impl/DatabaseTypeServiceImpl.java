package com.xuyifan.projectinit.service.impl;

import com.xuyifan.commonutils.common.UUIDUtils;
import com.xuyifan.projectinit.bean.DatabaseTypeBean;
import com.xuyifan.projectinit.mapper.DatabaseTypeMapper;
import com.xuyifan.projectinit.searchbean.DataTypeSearchBean;
import com.xuyifan.projectinit.service.DatabaseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xuyifan
 * @Date: 2020/8/5
 */
@Service
public class DatabaseTypeServiceImpl implements DatabaseTypeService {
    @Autowired
    private DatabaseTypeMapper databaseTypeMapper;
    @Override
    public void addData(DatabaseTypeBean databaseTypeBean) {
        databaseTypeBean.setId(UUIDUtils.getUpperString());
        databaseTypeMapper.addData(databaseTypeBean);
    }

    @Override
    public void deleteData(String id) {
        databaseTypeMapper.deleteData(id);
    }

    @Override
    public void updateData(DatabaseTypeBean databaseTypeBean) {
        databaseTypeMapper.updateData(databaseTypeBean);
    }

    @Override
    public DatabaseTypeBean getData(String id) {
        return databaseTypeMapper.getData(id);
    }

    @Override
    public List<DatabaseTypeBean> getDatas(DataTypeSearchBean searchBean) {
        return databaseTypeMapper.getDatasByLike(searchBean.getDataTypeName(),searchBean.getSwitchFlag(),searchBean.getCurNumIndex(),searchBean.getLimit());
    }

    @Override
    public Integer getDatasCount(DataTypeSearchBean searchBean) {
        return databaseTypeMapper.getDatasCount(searchBean.getDataTypeName(),searchBean.getSwitchFlag());
    }
}
