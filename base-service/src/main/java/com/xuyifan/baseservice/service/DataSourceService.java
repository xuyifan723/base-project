package com.xuyifan.baseservice.service;
import java.util.List;
import com.xuyifan.basedao.mapper.DataSourceMapper;
import com.xuyifan.basedao.bean.DataSourceBean;

/**
 * @author Xu yifan
 * @Ddecription 数据源服务
 * @date 2019-09-19 08:44:48
 * @Version 1.0
 */
public interface DataSourceService {
    /**
     * 功能描述:通过id删除记录
     * @Param: [id]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    public int deleteByPrimaryKey(Integer id);
    /**
     * 功能描述:插入全部数据
     * @Param: [DataSourceBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    public int insert(DataSourceBean record);
    /**
     * 功能描述:插入非空数据
     * @Param: [DataSourceBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    public int insertSelective(DataSourceBean record);
    /**
     * 功能描述:通过id查询记录
     * @Param: [id]
     * @Return: DataSourceBean
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    public DataSourceBean selectByPrimaryKey(Integer id);
    /**
     * 功能描述:通过非空参数搜索list
     * @Param: [DataSourceBean]
     * @Return: List<DataSourceBean>
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    public List<DataSourceBean> selectListBySelective(DataSourceBean record);
     /**
      * 功能描述:通过id更新非空参数
      * @Param: [DataSourceBean]
      * @Return: int
      * @Author: Xu yifan
      * @Date: 2019-09-19 08:44:48
      */
    public int updateByPrimaryKeySelective(DataSourceBean record);
    /**
     * 功能描述:通过id更新记录
     * @Param: [DataSourceBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    public int updateByPrimaryKey(DataSourceBean record);
}
