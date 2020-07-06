package com.xuyifan.projectinit.service;

import com.xuyifan.projectinit.bean.DataDriverBean;

import java.util.List;

/**
 * @Author: xuyifan
 * @Date: 2020/7/6
 */
public interface DataDriverService {
    void addData(DataDriverBean dataDriverBean);

    void deleteData(Integer id);

    void updateData(DataDriverBean dataDriverBean);

    DataDriverBean getData(Integer id);

    List<DataDriverBean> getDatas(String databaseType);
}
