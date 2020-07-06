package com.xuyifan.projectinit.mapper;

import com.xuyifan.projectinit.bean.DatabaseInfoBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xuyifan
 * @Date: 2020/7/6
 */
public interface DatabaseInfoMapper {
    void addData(DatabaseInfoBean databaseInfo);

    void updateData(DatabaseInfoBean databaseInfo);

    void deleteData(@Param("id") Integer id);

    DatabaseInfoBean getData(@Param("id") Integer id);

    List<DatabaseInfoBean> getDatasByLike(@Param("name") String name);

}
