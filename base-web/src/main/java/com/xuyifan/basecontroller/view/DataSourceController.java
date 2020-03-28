package com.xuyifan.basecontroller.view;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.xuyifan.commonutils.common.ResultBean;
import org.springframework.web.bind.annotation.*;
import com.xuyifan.baseservice.service.DataSourceService;
import com.xuyifan.basedao.bean.DataSourceBean;
/**
 * @author Xu yifan
 * @Ddecription 
 * @date 2020-03-28 14:59:27
 * @Version 1.0
 */
@RestController
@RequestMapping("/dataSource")
public class DataSourceController {
    @Autowired
    private DataSourceService dataSourceService;
    /**
     * 功能描述:通过id删除记录
     * @Param: [id]
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    @GetMapping("/delete")
    public Object deleteByPrimaryKey(Integer id){
        int num=dataSourceService.deleteByPrimaryKey(id);
       return new ResultBean();
    }
    /**
     * 功能描述:插入全部数据
     * @Param: [DataSourceBean]
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    @PostMapping("/addAll")
    public Object insert(@RequestBody DataSourceBean record){
       int num=dataSourceService.insert(record);
       return new ResultBean();
    }
    /**
     * 功能描述:插入非空数据
     * @Param: [DataSourceBean]
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    @PostMapping("/add")
    public Object insertSelective(@RequestBody DataSourceBean record){
       int num=dataSourceService.insertSelective(record);
       return new ResultBean();
     }
    /**
     * 功能描述:通过id查询记录
     * @Param: [id]
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    @GetMapping("/get")
    public Object selectByPrimaryKey(Integer id){
       DataSourceBean bean=dataSourceService.selectByPrimaryKey(id);
       return  new ResultBean(bean);
     }
    /**
     * 功能描述:通过非空参数搜索list
     * @Param: [DataSourceBean]
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    @PostMapping("/getList")
    public Object selectListBySelective(@RequestBody DataSourceBean record){
            List<DataSourceBean> list=dataSourceService.selectListBySelective(record);
        return  new ResultBean(list);
     }
     /**
      * 功能描述:通过id更新非空参数
      * @Param: [DataSourceBean]
      * @Author: Xu yifan
      * @Date: 2020-03-28 14:59:27
      */
    @PostMapping("/update")
    public Object updateByPrimaryKeySelective(@RequestBody DataSourceBean record){
         int num= dataSourceService.updateByPrimaryKeySelective(record);
      return  new ResultBean();
    }
    /**
     * 功能描述:通过id更新记录
     * @Param: [DataSourceBean]
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    @PostMapping("/updateAll")
    public Object updateByPrimaryKey(@RequestBody DataSourceBean record){
       int num=dataSourceService.updateByPrimaryKey(record);
      return new ResultBean();
    }
}
