package com.xuyifan.projectinit.service.impl;

import com.xuyifan.projectinit.enums.DriverType;
import com.xuyifan.projectinit.interfacebean.DriverInfo;
import com.xuyifan.projectinit.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xuyifan
 * @Date: 2020/7/6
 */
@Service
public class DriverServiceImpl implements DriverService {
    @Override
    public List<DriverInfo> getDriverList() {
        DriverType[] driverTypes = DriverType.values();
        List<DriverInfo> driverInfos=new ArrayList<>();
        for (DriverType driverType : driverTypes) {
            DriverInfo driverInfo=new DriverInfo();
            driverInfo.setTypeName(driverType.getName());
            driverInfo.setDriverName(driverType.getDriverClassName());
            driverInfos.add(driverInfo);
        }
        return driverInfos;
    }
}
