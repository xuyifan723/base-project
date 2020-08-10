package com.xuyifan.projectinit.service;

import com.xuyifan.projectinit.bean.DatabaseTypeBean;

import java.util.List;

/**
 * @Author: xuyifan
 * @Date: 2020/8/5
 */
public interface DatabaseTypeService {
    void addData(DatabaseTypeBean databaseTypeBean);

    void deleteData(String id);

    void updateData(DatabaseTypeBean databaseTypeBean);

    DatabaseTypeBean getData(String id);

    List<DatabaseTypeBean> getDatas(String databaseTypeName);
}
