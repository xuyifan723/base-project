package com.xuyifan.projectinit.controller;

import com.xuyifan.commonutils.common.ResultBean;
import com.xuyifan.projectinit.bean.DatabaseTypeBean;
import com.xuyifan.projectinit.service.DatabaseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xuyifan
 * @Date: 2020/8/5
 */
@RestController
@RequestMapping("/databaseType")
public class DatabaseTypeController {
    @Autowired
    private DatabaseTypeService databaseTypeService;
    @PostMapping("/addData")
    public ResultBean addData(@RequestBody DatabaseTypeBean databaseTypeBean){
        try {
            databaseTypeService.addData(databaseTypeBean);
            return new ResultBean();
        } catch (Exception e) {
           return new ResultBean().error("添加数据错误");
        }
    }
    @GetMapping ("/deleteData")
    public ResultBean deleteData(String id){
        try {
            databaseTypeService.deleteData(id);
            return new ResultBean();
        } catch (Exception e) {
            return new ResultBean().error("删除数据错误");
        }
    }
    @PostMapping("updateData")
    public ResultBean updateData(@RequestBody DatabaseTypeBean databaseTypeBean){
        try {
            databaseTypeService.updateData(databaseTypeBean);
            return new ResultBean();
        } catch (Exception e) {
            return new ResultBean().error("修改数据错误");
        }
    }
    @GetMapping ("/getData")
    public ResultBean getData(String id){
        try {
            DatabaseTypeBean data = databaseTypeService.getData(id);
            return new ResultBean(data);
        } catch (Exception e) {
            return new ResultBean().error("获取数据错误");
        }
    }
    @GetMapping ("/getDatas")
    public ResultBean getDatas(String databaseTypeName){
        try {
            List<DatabaseTypeBean> datas = databaseTypeService.getDatas(databaseTypeName);
            return new ResultBean(datas);
        } catch (Exception e) {
            return new ResultBean().error("获取数据列表错误");
        }
    }
}
