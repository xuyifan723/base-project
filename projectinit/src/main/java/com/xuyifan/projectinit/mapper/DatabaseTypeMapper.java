package com.xuyifan.projectinit.mapper;

import com.xuyifan.projectinit.bean.DatabaseTypeBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xuyifan
 * @Date: 2020/8/5
 */
public interface DatabaseTypeMapper {
    void addData(DatabaseTypeBean databaseTypeBean);

    void updateData(DatabaseTypeBean databaseTypeBean);

    void deleteData(@Param("id") String id);

    DatabaseTypeBean getData(@Param("id") String id);

    List<DatabaseTypeBean> getDatasByLike(@Param("name") String name, @Param("flag") Boolean flag, @Param("curNumIndex") Integer curNumIndex, @Param("limit")Integer limit);

    Integer getDatasCount(@Param("name") String name, @Param("flag") Boolean flag);
}
