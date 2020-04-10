package com.xuyifan.basecontroller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.xuyifan.commonutils.common.ResultBean;
import org.springframework.web.bind.annotation.*;
import com.xuyifan.baseservice.service.ResourcePermissionService;
import com.xuyifan.basedao.bean.ResourcePermissionBean;

/**
 * @author Xu yifan
 * @Ddecription
 * @date 2020-03-28 14:59:27
 * @Version 1.0
 */
@RestController
@RequestMapping("/resourcePermission")
public class ResourcePermissionController {
    @Autowired
    private ResourcePermissionService resourcePermissionService;

    /**
     * 功能描述:通过id删除记录
     *
     * @Param: [id]
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    @GetMapping("/delete")
    public Object deleteByPrimaryKey(Integer id) {
        int num = resourcePermissionService.deleteByPrimaryKey(id);
        return new ResultBean();
    }

    /**
     * 功能描述:插入全部数据
     *
     * @Param: [ResourcePermissionBean]
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    @PostMapping("/addAll")
    public Object insert(@RequestBody ResourcePermissionBean record) {
        int num = resourcePermissionService.insert(record);
        return new ResultBean();
    }

    /**
     * 功能描述:插入非空数据
     *
     * @Param: [ResourcePermissionBean]
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    @PostMapping("/add")
    public Object insertSelective(@RequestBody ResourcePermissionBean record) {
        int num = resourcePermissionService.insertSelective(record);
        return new ResultBean();
    }

    /**
     * 功能描述:通过id查询记录
     *
     * @Param: [id]
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    @GetMapping("/get")
    public Object selectByPrimaryKey(Integer id) {
        ResourcePermissionBean bean = resourcePermissionService.selectByPrimaryKey(id);
        return new ResultBean(bean);
    }

    /**
     * 功能描述:通过非空参数搜索list
     *
     * @Param: [ResourcePermissionBean]
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    @PostMapping("/getList")
    public Object selectListBySelective(@RequestBody ResourcePermissionBean record) {
        List<ResourcePermissionBean> list = resourcePermissionService.selectListBySelective(record);
        return new ResultBean(list);
    }

    /**
     * 功能描述:通过id更新非空参数
     *
     * @Param: [ResourcePermissionBean]
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    @PostMapping("/update")
    public Object updateByPrimaryKeySelective(@RequestBody ResourcePermissionBean record) {
        int num = resourcePermissionService.updateByPrimaryKeySelective(record);
        return new ResultBean();
    }

    /**
     * 功能描述:通过id更新记录
     *
     * @Param: [ResourcePermissionBean]
     * @Author: Xu yifan
     * @Date: 2020-03-28 14:59:27
     */
    @PostMapping("/updateAll")
    public Object updateByPrimaryKey(@RequestBody ResourcePermissionBean record) {
        int num = resourcePermissionService.updateByPrimaryKey(record);
        return new ResultBean();
    }
}
