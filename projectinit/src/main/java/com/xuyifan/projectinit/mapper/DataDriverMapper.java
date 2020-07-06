package com.xuyifan.projectinit.mapper;

import com.xuyifan.projectinit.bean.DataDriverBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xuyifan
 * @Date: 2020/7/6
 */
public interface DataDriverMapper {
    void addData(DataDriverBean dataDriverBean);

    void updateData(DataDriverBean dataDriverBean);

    void deleteData(@Param("id") Integer id);

    DataDriverBean getData(@Param("id") Integer id);

    List<DataDriverBean> getDatasByType(@Param("databaseType") String databaseType);
}
