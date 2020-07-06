package com.xuyifan.projectinit.controller;

import com.xuyifan.commonutils.common.ResultBean;
import com.xuyifan.projectinit.bean.DatabaseInfoBean;
import com.xuyifan.projectinit.service.DatabaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xuyifan
 * @Date: 2020/7/6
 */

@RestController
@RequestMapping("/databaseInfo")
public class DatabaseInfoController {
    @Autowired
    private DatabaseInfoService databaseInfoService;
    @GetMapping("/getData")
    public ResultBean getData(Integer id){
        DatabaseInfoBean data = databaseInfoService.getData(id);
        return new ResultBean(data);
    }
    @PostMapping("/addData")
    public ResultBean addData(@RequestBody DatabaseInfoBean databaseInfoBean){
        databaseInfoService.addData(databaseInfoBean);
        return new ResultBean();
    }
    @GetMapping("/updateData")
    public ResultBean updateData(@RequestBody DatabaseInfoBean databaseInfoBean){
        databaseInfoService.updateData(databaseInfoBean);
        return new ResultBean();
    }
    @GetMapping("/getDatasForName")
    public ResultBean getDatasForName(String name){
        List<DatabaseInfoBean> datas = databaseInfoService.getDatasLikeName(name);
        return new ResultBean(datas);
    }

}
