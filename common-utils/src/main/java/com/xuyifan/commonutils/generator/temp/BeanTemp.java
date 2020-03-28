package com.xuyifan.commonutils.generator.temp;

import com.xuyifan.commonutils.generator.StringHandle;
import com.xuyifan.commonutils.generator.bean.TableColumn;
import com.xuyifan.commonutils.generator.bean.TableName;
import com.xuyifan.commonutils.generator.config.ConfigureParams;
import com.xuyifan.commonutils.generator.config.DataBaseTpyeFactory;
import com.xuyifan.commonutils.generator.config.DataBaseType;

import java.util.List;
import java.util.Map;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/6 16:06
 * @Version 1.0
 */
public class BeanTemp extends Temp {
    private String fileSuffix="Bean.java";
    private String tempName="beanTemp.txt";
    public BeanTemp(TableName tableName, List<TableColumn> columns) {
        super(tableName, columns);
        super.getTemp(this.tempName);
        super.setFileSuffix(this.fileSuffix);
        super.setProjectUrl(ConfigureParams.beanProjectUrl);
        super.setPackageName(ConfigureParams.beanPackage);

    }
    public void handleColumn(){
        boolean flag=true;
        List<String> importPackage = this.getImportPackage();
        List<String> data = this.getData();
        DataBaseType mysql = DataBaseTpyeFactory.getType("mysql");
        for (TableColumn column : this.getColumns()) {
          StringBuffer temp=new StringBuffer();
          temp.append("    private ");
            String type = mysql.getType(column.getColType());
            temp.append(type);
            if ("Date".equals(type)&&flag){
                importPackage.add("import java.util.Date;");
                flag=false;
            }
            temp.append(" ");
            temp.append(StringHandle.toClassLowStr(column.getColName(),ConfigureParams.ingoreStrs));
            temp.append(";");
            temp.append("   //"+column.getComment());
            data.add(temp.toString());
        }
    }


    @Override
    public void handle() {
        List<String> importPackage = this.getImportPackage();
        List<String> data = this.getData();
        importPackage.add("import lombok.Data;");
        Map<String, String> regexMap = this.getRegexMap();
        for (String tempStr : this.getTempData()) {
            if (StringHandle.validateStr(tempStr,"FORCOLUMN")){
                handleColumn();
            }else {
                String temp = StringHandle.handleStr(tempStr, regexMap);
                data.add(temp);

            }

        }

    }


    public static void main(String[] args) {
        String beanPackage = "com.xuyifan.bean.dao";
        String packageUrl = beanPackage.replaceAll("\\.", "/");
        System.out.println(packageUrl);

    }

}
