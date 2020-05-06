package com.xuyifan.baseservice.service;
import com.xuyifan.basedao.bean.DataSourceBean;

import java.util.List;

/**
 * @author Xu yifan
 * @Ddecription 服务
 * @date 2020-05-06 17:40:22
 * @Version 1.0
 */
public interface DataSourceService {
    /**
     * 功能描述:通过id删除记录
     * @Param: [id]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    public int deleteByPrimaryKey(String id);
    /**
     * 功能描述:插入全部数据
     * @Param: [DataSourceBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    public int insert(DataSourceBean record);
    /**
     * 功能描述:插入非空数据
     * @Param: [DataSourceBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    public int insertSelective(DataSourceBean record);
    /**
     * 功能描述:通过id查询记录
     * @Param: [id]
     * @Return: DataSourceBean
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    public DataSourceBean selectByPrimaryKey(String id);
    /**
     * 功能描述:通过非空参数搜索list
     * @Param: [DataSourceBean]
     * @Return: List<DataSourceBean>
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    public List<DataSourceBean> selectListBySelective(DataSourceBean record);
     /**
      * 功能描述:通过id更新非空参数
      * @Param: [DataSourceBean]
      * @Return: int
      * @Author: Xu yifan
      * @Date: 2020-05-06 17:40:22
      */
    public int updateByPrimaryKeySelective(DataSourceBean record);
    /**
     * 功能描述:通过id更新记录
     * @Param: [DataSourceBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    public int updateByPrimaryKey(DataSourceBean record);
}
