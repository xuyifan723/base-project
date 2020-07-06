package com.xuyifan.projectinit.service;

import com.xuyifan.projectinit.bean.DatabaseInfoBean;

import java.util.List;

/**
 * @Author: xuyifan
 * @Date: 2020/7/6
 */
public interface DatabaseInfoService {
    void addData(DatabaseInfoBean databaseInfoBean);

    void deleteData(Integer id);

    void updateData(DatabaseInfoBean databaseInfoBean);

    DatabaseInfoBean getData(Integer id);

    List<DatabaseInfoBean> getDatasLikeName(String name);
}
