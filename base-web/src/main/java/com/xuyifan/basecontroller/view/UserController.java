package com.xuyifan.basecontroller.view;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.xuyifan.commonutils.common.ResultBean;
import org.springframework.web.bind.annotation.*;
import com.xuyifan.baseservice.service.UserService;
import com.xuyifan.basedao.bean.UserBean;
/**
 * @author Xu yifan
 * @Ddecription 
 * @date 2019-09-19 08:44:48
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 功能描述:通过id删除记录
     * @Param: [id]
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @GetMapping("/delete")
    public Object deleteByPrimaryKey(Integer id){
        int num=userService.deleteByPrimaryKey(id);
       return new ResultBean();
    }
    /**
     * 功能描述:插入全部数据
     * @Param: [UserBean]
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @PostMapping("/addAll")
    public Object insert(@RequestBody UserBean record){
       int num=userService.insert(record);
       return new ResultBean();
    }
    /**
     * 功能描述:插入非空数据
     * @Param: [UserBean]
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @PostMapping("/add")
    public Object insertSelective(@RequestBody UserBean record){
       int num=userService.insertSelective(record);
       return new ResultBean();
     }
    /**
     * 功能描述:通过id查询记录
     * @Param: [id]
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @GetMapping("/get")
    public Object selectByPrimaryKey(Integer id){
       UserBean bean=userService.selectByPrimaryKey(id);
       return  new ResultBean(bean);
     }
    /**
     * 功能描述:通过非空参数搜索list
     * @Param: [UserBean]
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @PostMapping("/getList")
    public Object selectListBySelective(@RequestBody UserBean record){
            List<UserBean> list=userService.selectListBySelective(record);
        return  new ResultBean(list);
     }
     /**
      * 功能描述:通过id更新非空参数
      * @Param: [UserBean]
      * @Author: Xu yifan
      * @Date: 2019-09-19 08:44:48
      */
    @PostMapping("/update")
    public Object updateByPrimaryKeySelective(@RequestBody UserBean record){
         int num= userService.updateByPrimaryKeySelective(record);
      return  new ResultBean();
    }
    /**
     * 功能描述:通过id更新记录
     * @Param: [UserBean]
     * @Author: Xu yifan
     * @Date: 2019-09-19 08:44:48
     */
    @PostMapping("/updateAll")
    public Object updateByPrimaryKey(@RequestBody UserBean record){
       int num=userService.updateByPrimaryKey(record);
      return new ResultBean();
    }
}