package com.xuyifan.baseservice.service;
import java.util.List;

import com.xuyifan.basedao.bean.ResMenuBean;

/**
 * @author Xu yifan
 * @Ddecription 服务
 * @date 2019-09-19 08:44:48
 * @Version 1.0
 */
public interface ResMenuService {
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
     * @Param: [ResMenuBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    public int insert(ResMenuBean record);
    /**
     * 功能描述:插入非空数据
     * @Param: [ResMenuBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    public int insertSelective(ResMenuBean record);
    /**
     * 功能描述:通过id查询记录
     * @Param: [id]
     * @Return: ResMenuBean
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    public ResMenuBean selectByPrimaryKey(Integer id);
    /**
     * 功能描述:通过非空参数搜索list
     * @Param: [ResMenuBean]
     * @Return: List<ResMenuBean>
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    public List<ResMenuBean> selectListBySelective(ResMenuBean record);
     /**
      * 功能描述:通过id更新非空参数
      * @Param: [ResMenuBean]
      * @Return: int
      * @Author: Xu yifan
      * @Date: 2019-09-19 08:44:48
      */
    public int updateByPrimaryKeySelective(ResMenuBean record);
    /**
     * 功能描述:通过id更新记录
     * @Param: [ResMenuBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    public int updateByPrimaryKey(ResMenuBean record);
}
