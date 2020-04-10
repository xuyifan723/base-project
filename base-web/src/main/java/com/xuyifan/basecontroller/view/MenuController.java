package com.xuyifan.basecontroller.view;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.xuyifan.commonutils.common.ResultBean;
import org.springframework.web.bind.annotation.*;
import com.xuyifan.baseservice.service.MenuService;
import com.xuyifan.basedao.bean.MenuBean;
/**
 * @author Xu yifan
 * @Ddecription 
 * @date 2020-04-10 16:14:09
 * @Version 1.0
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    /**
     * 功能描述:通过id删除记录
     * @Param: [id]
     * @Author: Xu yifan
     * @Date: 2020-04-10 16:14:09
     */
    @GetMapping("/delete")
    public Object deleteByPrimaryKey(Integer id){
        int num=menuService.deleteByPrimaryKey(id);
       return new ResultBean();
    }
    /**
     * 功能描述:插入全部数据
     * @Param: [MenuBean]
     * @Author: Xu yifan
     * @Date: 2020-04-10 16:14:09
     */
    @PostMapping("/addAll")
    public Object insert(@RequestBody MenuBean record){
       int num=menuService.insert(record);
       return new ResultBean();
    }
    /**
     * 功能描述:插入非空数据
     * @Param: [MenuBean]
     * @Author: Xu yifan
     * @Date: 2020-04-10 16:14:09
     */
    @PostMapping("/add")
    public Object insertSelective(@RequestBody MenuBean record){
       int num=menuService.insertSelective(record);
       return new ResultBean();
     }
    /**
     * 功能描述:通过id查询记录
     * @Param: [id]
     * @Author: Xu yifan
     * @Date: 2020-04-10 16:14:09
     */
    @GetMapping("/get")
    public Object selectByPrimaryKey(Integer id){
       MenuBean bean=menuService.selectByPrimaryKey(id);
       return  new ResultBean(bean);
     }
    /**
     * 功能描述:通过非空参数搜索list
     * @Param: [MenuBean]
     * @Author: Xu yifan
     * @Date: 2020-04-10 16:14:09
     */
    @PostMapping("/getList")
    public Object selectListBySelective(@RequestBody MenuBean record){
            List<MenuBean> list=menuService.selectListBySelective(record);
        return  new ResultBean(list);
     }
     /**
      * 功能描述:通过id更新非空参数
      * @Param: [MenuBean]
      * @Author: Xu yifan
      * @Date: 2020-04-10 16:14:09
      */
    @PostMapping("/update")
    public Object updateByPrimaryKeySelective(@RequestBody MenuBean record){
         int num= menuService.updateByPrimaryKeySelective(record);
      return  new ResultBean();
    }
    /**
     * 功能描述:通过id更新记录
     * @Param: [MenuBean]
     * @Author: Xu yifan
     * @Date: 2020-04-10 16:14:09
     */
    @PostMapping("/updateAll")
    public Object updateByPrimaryKey(@RequestBody MenuBean record){
       int num=menuService.updateByPrimaryKey(record);
      return new ResultBean();
    }
}
