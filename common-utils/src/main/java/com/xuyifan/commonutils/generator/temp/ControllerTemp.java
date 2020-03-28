package com.xuyifan.commonutils.generator.temp;

import com.xuyifan.commonutils.generator.StringHandle;
import com.xuyifan.commonutils.generator.bean.TableColumn;
import com.xuyifan.commonutils.generator.bean.TableName;
import com.xuyifan.commonutils.generator.config.ConfigureParams;

import java.util.List;
import java.util.Map;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/6 14:10
 * @Version 1.0
 */
public class ControllerTemp extends Temp {
    private String fileSuffix="Controller.java";
    private String tempName="controllerTemp.txt";
    public ControllerTemp(TableName tableName, List<TableColumn> columns) {
        super(tableName, columns);
        super.getTemp(this.tempName);
        super.setFileSuffix(this.fileSuffix);
        super.setProjectUrl(ConfigureParams.conProjectUrl);
        super.setPackageName(ConfigureParams.controllerPackage);
    }

    @Override
    public void handle() {
        List<String> importPackage = this.getImportPackage();
        List<String> data = this.getData();
        String classUpStr = StringHandle.toClassUpStr(this.getTableName().getTableName(),ConfigureParams.ingoreStrs);
        importPackage.add("import java.util.List;");
        importPackage.add("import org.springframework.beans.factory.annotation.Autowired;");
        importPackage.add("import com.xuyifan.commonutils.common.ResultBean;");
        importPackage.add("import org.springframework.web.bind.annotation.*;");
        importPackage.add("import " + ConfigureParams.servicePackage + "." + classUpStr + "Service;");
        importPackage.add("import " + ConfigureParams.beanPackage + "." + classUpStr + "Bean;");
        Map<String, String> regexMap = this.getRegexMap();
        for (String tempStr : this.getTempData()) {
            String temp = StringHandle.handleStr(tempStr, regexMap);
            data.add(temp);
        }
    }
}
