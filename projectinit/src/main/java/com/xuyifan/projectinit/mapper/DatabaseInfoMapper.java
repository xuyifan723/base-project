package com.xuyifan.projectinit.mapper;

import com.xuyifan.projectinit.bean.DatabaseInfoBean;

import java.util.List;

/**
 * @Author: xuyifan
 * @Date: 2020/7/6
 */
public interface DatabaseInfoMapper {
    void addData(DatabaseInfoBean databaseInfo);
    void updateData(DatabaseInfoBean databaseInfo);
    void deleteData(DatabaseInfoBean databaseInfo);
    DatabaseInfoBean getData(Integer id);
    List<DatabaseInfoBean> getDatasByLike(String name);

}
