package com.xuyifan.baseservice.service;
import java.util.List;
import com.xuyifan.basedao.mapper.MenuMapper;
import com.xuyifan.basedao.bean.MenuBean;

/**
 * @author Xu yifan
 * @Ddecription 服务
 * @date 2020-04-10 16:14:09
 * @Version 1.0
 */
public interface MenuService {
    /**
     * 功能描述:通过id删除记录
     * @Param: [id]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-04-10 16:14:09
     */
    public int deleteByPrimaryKey(Integer id);
    /**
     * 功能描述:插入全部数据
     * @Param: [MenuBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-04-10 16:14:09
     */
    public int insert(MenuBean record);
    /**
     * 功能描述:插入非空数据
     * @Param: [MenuBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-04-10 16:14:09
     */
    public int insertSelective(MenuBean record);
    /**
     * 功能描述:通过id查询记录
     * @Param: [id]
     * @Return: MenuBean
     * @Author: Xu yifan
     * @Date: 2020-04-10 16:14:09
     */
    public MenuBean selectByPrimaryKey(Integer id);
    /**
     * 功能描述:通过非空参数搜索list
     * @Param: [MenuBean]
     * @Return: List<MenuBean>
     * @Author: Xu yifan
     * @Date: 2020-04-10 16:14:09
     */
    public List<MenuBean> selectListBySelective(MenuBean record);
     /**
      * 功能描述:通过id更新非空参数
      * @Param: [MenuBean]
      * @Return: int
      * @Author: Xu yifan
      * @Date: 2020-04-10 16:14:09
      */
    public int updateByPrimaryKeySelective(MenuBean record);
    /**
     * 功能描述:通过id更新记录
     * @Param: [MenuBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-04-10 16:14:09
     */
    public int updateByPrimaryKey(MenuBean record);
}
