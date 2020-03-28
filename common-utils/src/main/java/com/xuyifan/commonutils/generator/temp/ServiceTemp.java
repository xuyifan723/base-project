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
public class ServiceTemp extends Temp{
    private String fileSuffix = "Service.java";
    private String tempName = "serviceTemp.txt";
    public ServiceTemp(TableName tableName, List<TableColumn> columns) {
        super(tableName, columns);
        super.getTemp(this.tempName);
        super.setFileSuffix(this.fileSuffix);
        super.setProjectUrl(ConfigureParams.serProjectUrl);
        super.setPackageName(ConfigureParams.servicePackage);
    }


    @Override
    public void handle() {
        List<String> importPackage = this.getImportPackage();
        List<String> data = this.getData();
        String classUpStr = StringHandle.toClassUpStr(this.getTableName().getTableName(),ConfigureParams.ingoreStrs);
        importPackage.add("import java.util.List;");
        importPackage.add("import " + ConfigureParams.daoPackage + "." + classUpStr + "Mapper;");
        importPackage.add("import " + ConfigureParams.beanPackage + "." + classUpStr + "Bean;");
        Map<String, String> regexMap = this.getRegexMap();
        for (String tempStr : this.getTempData()) {
            String temp = StringHandle.handleStr(tempStr, regexMap);
            data.add(temp);
        }
    }
}
