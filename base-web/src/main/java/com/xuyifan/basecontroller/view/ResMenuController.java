package com.xuyifan.basecontroller.view;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.xuyifan.commonutils.common.ResultBean;
import org.springframework.web.bind.annotation.*;
import com.xuyifan.baseservice.service.ResMenuService;
import com.xuyifan.basedao.bean.ResMenuBean;
/**
 * @author Xu yifan
 * @Ddecription 
 * @date 2019-09-17 14:01:13
 * @Version 1.0
 */
@RestController
@RequestMapping("/resMenu")
public class ResMenuController {
    @Autowired
    private ResMenuService resMenuService;
    /**
     * 功能描述:通过id删除记录
     * @Param: [id]
     * @Author: Xu yifan
     * @Date: 2019-09-17 14:01:13
     */
    @GetMapping("/delete")
    public Object deleteByPrimaryKey(Integer id){
        int num=resMenuService.deleteByPrimaryKey(id);
       return new ResultBean();
    }
    /**
     * 功能描述:插入全部数据
     * @Param: [ResMenuBean]
     * @Author: Xu yifan
     * @Date: 2019-09-17 14:01:13
     */
    @PostMapping("/addAll")
    public Object insert(@RequestBody ResMenuBean record){
       int num=resMenuService.insert(record);
       return new ResultBean();
    }
    /**
     * 功能描述:插入非空数据
     * @Param: [ResMenuBean]
     * @Author: Xu yifan
     * @Date: 2019-09-17 14:01:13
     */
    @PostMapping("/add")
    public Object insertSelective(@RequestBody ResMenuBean record){
       int num=resMenuService.insertSelective(record);
       return new ResultBean();
     }
    /**
     * 功能描述:通过id查询记录
     * @Param: [id]
     * @Author: Xu yifan
     * @Date: 2019-09-17 14:01:13
     */
    @GetMapping("/get")
    public Object selectByPrimaryKey(Integer id){
       ResMenuBean bean=resMenuService.selectByPrimaryKey(id);
       return  new ResultBean(bean);
     }
    /**
     * 功能描述:通过非空参数搜索list
     * @Param: [ResMenuBean]
     * @Author: Xu yifan
     * @Date: 2019-09-17 14:01:13
     */
    @PostMapping("/getList")
    public Object selectListBySelective(@RequestBody ResMenuBean record){
            List<ResMenuBean> list=resMenuService.selectListBySelective(record);
        return  new ResultBean(list);
     }
     /**
      * 功能描述:通过id更新非空参数
      * @Param: [ResMenuBean]
      * @Author: Xu yifan
      * @Date: 2019-09-17 14:01:13
      */
    @PostMapping("/update")
    public Object updateByPrimaryKeySelective(@RequestBody ResMenuBean record){
         int num= resMenuService.updateByPrimaryKeySelective(record);
      return  new ResultBean();
    }
    /**
     * 功能描述:通过id更新记录
     * @Param: [ResMenuBean]
     * @Author: Xu yifan
     * @Date: 2019-09-17 14:01:13
     */
    @PostMapping("/updateAll")
    public Object updateByPrimaryKey(@RequestBody ResMenuBean record){
       int num=resMenuService.updateByPrimaryKey(record);
      return new ResultBean();
    }
}
