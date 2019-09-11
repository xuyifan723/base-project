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
 * @date 2019/9/6 14:08
 * @Version 1.0
 */
public class MapperTemp extends Temp{
    private String fileSuffix="Mapper.java";
    private String tempName="MapperTemp.txt";
    public MapperTemp(TableName tableName, List<TableColumn> columns) {
        super(tableName, columns);
        super.getTemp(this.tempName);
        super.setFileSuffix(this.fileSuffix);
        super.setProjectUrl(ConfigureParams.daoProjectUrl);
        super.setPackageName(ConfigureParams.daoPackage);
    }

    @Override
    public void handle() {
        List<String> importPackage = this.getImportPackage();
        List<String> data = this.getData();
        importPackage.add("import java.util.List;");
        importPackage.add("import "+ConfigureParams.beanPackage+"."+StringHandle.toClassUpStr(this.getTableName().getTableName())+"Bean;");
        Map<String, String> regexMap = this.getRegexMap();
        for (String tempStr : this.getTempData()) {
                String temp = StringHandle.handleStr(tempStr, regexMap);
                data.add(temp);
            }

        }
    }
