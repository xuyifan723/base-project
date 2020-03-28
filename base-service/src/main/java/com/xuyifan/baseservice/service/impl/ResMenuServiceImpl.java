package com.xuyifan.baseservice.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.xuyifan.baseservice.service.ResMenuService;
import com.xuyifan.basedao.bean.ResMenuBean;

/**
 * @author Xu yifan
 * @Ddecription 服务
 * @date 2019-09-19 08:44:48
 * @Version 1.0
 */
@Service
public class ResMenuServiceImpl implements ResMenuService {
    @Autowired
    private ResMenuMapper resMenuMapper;


    /**
     * 功能描述:通过id删除记录
     * @Param: [id]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public int deleteByPrimaryKey(Integer id){
       return resMenuMapper.deleteByPrimaryKey(id);
    }
    /**
     * 功能描述:插入全部数据
     * @Param: [ResMenuBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public int insert(ResMenuBean record){
       return resMenuMapper.insert(record);
    }
    /**
     * 功能描述:插入非空数据
     * @Param: [ResMenuBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public int insertSelective(ResMenuBean record){
       return resMenuMapper.insertSelective(record);
     }
    /**
     * 功能描述:通过id查询记录
     * @Param: [id]
     * @Return: ResMenuBean
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public ResMenuBean selectByPrimaryKey(Integer id){
       return resMenuMapper.selectByPrimaryKey(id);
     }
    /**
     * 功能描述:通过非空参数搜索list
     * @Param: [ResMenuBean]
     * @Return: List<ResMenuBean>
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public List<ResMenuBean> selectListBySelective(ResMenuBean record){
       return resMenuMapper.selectListBySelective(record);
     }
     /**
      * 功能描述:通过id更新非空参数
      * @Param: [ResMenuBean]
      * @Return: int
      * @Author: Xu yifan
      * @Date: 2019-09-19 08:44:48
      */
    @Override
    public int updateByPrimaryKeySelective(ResMenuBean record){
      return resMenuMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 功能描述:通过id更新记录
     * @Param: [ResMenuBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @Override
    public int updateByPrimaryKey(ResMenuBean record){
      return resMenuMapper.updateByPrimaryKey(record);
    }
}
