package com.xuyifan.baseservice.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.xuyifan.baseservice.DataSourceService;
import com.xuyifan.basedao.mapper.DataSourceMapper;
import com.xuyifan.basedao.bean.DataSourceBean;

/**
 * @author Xu yifan
 * @Ddecription 数据源服务
 * @date 2019-09-12 16:26:56
 * @Version 1.0
 */
@Service
public class DataSourceServiceImpl implements DataSourceService {
    @Autowired
    private DataSourceMapper dataSourceMapper;


    /**
     * 功能描述:通过id删除记录
     * @Param: [id]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-12 16:26:56
     */
    @Override
    public int deleteByPrimaryKey(Integer id){
       return dataSourceMapper.deleteByPrimaryKey(id);
    }
    /**
     * 功能描述:插入全部数据
     * @Param: [DataSourceBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-12 16:26:56
     */
    @Override
    public int insert(DataSourceBean record){
       return dataSourceMapper.insert(record);
    }
    /**
     * 功能描述:插入非空数据
     * @Param: [DataSourceBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-12 16:26:56
     */
    @Override
    public int insertSelective(DataSourceBean record){
       return dataSourceMapper.insertSelective(record);
     }
    /**
     * 功能描述:通过id查询记录
     * @Param: [id]
     * @Return: DataSourceBean
     * @Author: Xu yifan
     * @Date: 2019-09-12 16:26:56
     */
    @Override
    public DataSourceBean selectByPrimaryKey(Integer id){
       return dataSourceMapper.selectByPrimaryKey(id);
     }
    /**
     * 功能描述:通过非空参数搜索list
     * @Param: [DataSourceBean]
     * @Return: List<DataSourceBean>
     * @Author: Xu yifan
     * @Date: 2019-09-12 16:26:56
     */
    @Override
    public List<DataSourceBean> selectListBySelective(DataSourceBean record){
       return dataSourceMapper.selectListBySelective(record);
     }
     /**
      * 功能描述:通过id更新非空参数
      * @Param: [DataSourceBean]
      * @Return: int
      * @Author: Xu yifan
      * @Date: 2019-09-12 16:26:56
      */
    @Override
    public int updateByPrimaryKeySelective(DataSourceBean record){
      return dataSourceMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 功能描述:通过id更新记录
     * @Param: [DataSourceBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-12 16:26:56
     */
    @Override
    public int updateByPrimaryKey(DataSourceBean record){
      return dataSourceMapper.updateByPrimaryKey(record);
    }
}
