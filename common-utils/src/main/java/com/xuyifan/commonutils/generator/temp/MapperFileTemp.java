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
 * @date 2019/9/11 11:43
 * @Version 1.0
 */
public class MapperFileTemp extends Temp {
    private String fileSuffix = "Mapper.xml";
    private String tempName = "MapperFileTemp.txt";

    public MapperFileTemp(TableName tableName, List<TableColumn> columns) {
        super(tableName, columns);
        super.getTemp(this.tempName);
        super.setFileSuffix(this.fileSuffix);
        super.setProjectUrl(ConfigureParams.mapperFile);
        super.setPackageName("");
    }

    @Override
    public void handle() {
        List<String> importPackage = this.getImportPackage();
        List<String> data = this.getData();
        Map<String, String> regexMap = this.getRegexMap();
        regexMap.put("PACKAGENAMEMAPER",ConfigureParams.daoPackage);
        regexMap.put("PACKAGENAMEBEAN",ConfigureParams.beanPackage);
        for (String tempStr : this.getTempData()) {
            if (StringHandle.validateStr(tempStr, "RESULTMAPCOL")) {
                handleResultMap();
            }else if (StringHandle.validateStr(tempStr, "BASECOLUMN")){
                handleBaseColumn();
            }else if (StringHandle.validateStr(tempStr, "SELECTLISTOPTIONS")){
                handleSelectListOption();
            }else if (StringHandle.validateStr(tempStr, "INSERTVALUE")){
                handleInsertValue();
            }else if (StringHandle.validateStr(tempStr, "INSERTCOL")){
                handleInsertCol();
            }else if (StringHandle.validateStr(tempStr, "INSERTVALUEOPTIONS")){
                handleInsertValOption();
            }else if (StringHandle.validateStr(tempStr, "UPDATEOPTIONS")){
                handleUpdateOptions();
            }else if (StringHandle.validateStr(tempStr, "UPDATEVALS")){
                handleUpdate();
            }else {
                String temp = StringHandle.handleStr(tempStr, regexMap);
                data.add(temp);
            }
        }
    }
    public void handleUpdate(){
        List<String> data = this.getData();
        boolean flag=true;
        for (TableColumn column : this.getColumns()) {
            StringBuffer temp = new StringBuffer();
            if (!flag){
                temp.append(",");
            }else {
                flag=false;
            }
            String colName = StringHandle.toClassLowStr(column.getColName(),ConfigureParams.ingoreStrs);
            temp.append( column.getColName()+"= #{"+colName+"}");
            data.add(temp.toString());
        }
    }
    public void handleUpdateOptions(){
        List<String> data = this.getData();
        for (TableColumn column : this.getColumns()) {
            StringBuffer temp = new StringBuffer();
            String colName = StringHandle.toClassLowStr(column.getColName(),ConfigureParams.ingoreStrs);
            temp.append("      <if test=\""+colName+" != null\">\n" +
                    "        "+column.getColName()+" = #{"+colName+"},\n" +
                    "      </if>");
            data.add(temp.toString());
        }
    }
    public void handleInsertValOption(){
        List<String> data = this.getData();
        for (TableColumn column : this.getColumns()) {
            StringBuffer temp = new StringBuffer();
            String colName = StringHandle.toClassLowStr(column.getColName(),ConfigureParams.ingoreStrs);
            temp.append("      <if test=\""+colName+" != null\">\n" +
                    "        #{"+colName+"},\n" +
                    "      </if>");
            data.add(temp.toString());
        }
    }
    public void handleInsertCol(){
        List<String> data = this.getData();
        for (TableColumn column : this.getColumns()) {
            StringBuffer temp = new StringBuffer();
            String colName = StringHandle.toClassLowStr(column.getColName(),ConfigureParams.ingoreStrs);
            temp.append("      <if test=\""+colName+" != null\">\n" +
                    "        "+column.getColName()+",\n" +
                    "      </if>");
            data.add(temp.toString());
        }
    }




    public void handleInsertValue(){
        List<String> data = this.getData();
        StringBuffer temp = new StringBuffer();
        boolean flag=true;
        for (TableColumn column : this.getColumns()) {
            if (!flag){
                temp.append(",");
            }else {
                flag=false;
            }
            temp.append("#{"+StringHandle.toClassLowStr(column.getColName(),ConfigureParams.ingoreStrs)+"}");
        }
        data.add(temp.toString());
    }
    public void handleSelectListOption(){
        List<String> data = this.getData();

        boolean flag=true;
        for (TableColumn column : this.getColumns()) {
            StringBuilder temp = new StringBuilder();
            String colName = StringHandle.toClassLowStr(column.getColName(),ConfigureParams.ingoreStrs);
            temp.append("      <if test=\"");

            temp.append(colName);
            temp.append(" != null\">\n");
            if (!flag){
                temp.append("      and ");
            }else {
                flag=false;
                temp.append("      ");
            }
            temp.append(column.getColName());
            temp.append(" = #{");
            temp.append(colName);
            temp.append("}\n      </if>");

            data.add(temp.toString());
        }
    }

    public void handleBaseColumn(){
        List<String> data = this.getData();
        StringBuffer temp = new StringBuffer();
        for (TableColumn column : this.getColumns()) {
            temp.append(column.getColName()+",");
        }
        String str = temp.toString();
        data.add(str.substring(0,str.length()-1));
    }

    public void handleResultMap() {
        List<String> data = this.getData();
        for (TableColumn column : this.getColumns()) {
            if (!column.getColName().equals("id")) {
                StringBuffer temp = new StringBuffer();
                temp.append("    <result column=\"");
                temp.append(column.getColName());
                temp.append("\" property=\"");
                temp.append(StringHandle.toClassLowStr(column.getColName(),ConfigureParams.ingoreStrs));
                temp.append("\" />");
                data.add(temp.toString());
            }
        }
    }

    public static void main(String[] args) {
        String str="keifeifje2";
        System.out.println(str.substring(0,str.length()-1));
    }
}
