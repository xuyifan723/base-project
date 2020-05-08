package com.xuyifan.baseservice.service.impl;
import com.xuyifan.basedao.bean.MenuBean;
import com.xuyifan.basedao.mapper.MenuMapper;
import com.xuyifan.baseservice.common.DataHandle;
import com.xuyifan.baseservice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xu yifan
 * @Ddecription 服务
 * @date 2020-05-06 17:40:22
 * @Version 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;


    /**
     * 功能描述:通过id删除记录
     * @Param: [id]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    @Override
    public int deleteByPrimaryKey(String id){
       return menuMapper.deleteByPrimaryKey(id);
    }
    /**
     * 功能描述:插入全部数据
     * @Param: [MenuBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    @Override
    public int insert(MenuBean record){
       return menuMapper.insert(record);
    }
    /**
     * 功能描述:插入非空数据
     * @Param: [MenuBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    @Override
    public int insertSelective(MenuBean record){
        DataHandle.addData(record);
       return menuMapper.insertSelective(record);
     }
    /**
     * 功能描述:通过id查询记录
     * @Param: [id]
     * @Return: MenuBean
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    @Override
    public MenuBean selectByPrimaryKey(String id){
       return menuMapper.selectByPrimaryKey(id);
     }
    /**
     * 功能描述:通过非空参数搜索list
     * @Param: [MenuBean]
     * @Return: List<MenuBean>
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    @Override
    public List<MenuBean> selectListBySelective(MenuBean record){
       return menuMapper.selectListBySelective(record);
     }
     /**
      * 功能描述:通过id更新非空参数
      * @Param: [MenuBean]
      * @Return: int
      * @Author: Xu yifan
      * @Date: 2020-05-06 17:40:22
      */
    @Override
    public int updateByPrimaryKeySelective(MenuBean record){
      return menuMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 功能描述:通过id更新记录
     * @Param: [MenuBean]
     * @Return: int
     * @Author: Xu yifan
     * @Date: 2020-05-06 17:40:22
     */
    @Override
    public int updateByPrimaryKey(MenuBean record){
      return menuMapper.updateByPrimaryKey(record);
    }
}
