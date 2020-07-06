package com.xuyifan.projectinit.controller;

import com.xuyifan.commonutils.common.ResultBean;
import com.xuyifan.projectinit.interfacebean.DriverInfo;
import com.xuyifan.projectinit.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: xuyifan
 * @Date: 2020/7/6
 */
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @GetMapping("/getAllDatas")
    public ResultBean getDrivers(){
        List<DriverInfo> driverList = driverService.getDriverList();
        return new ResultBean(driverList);
    }
}
