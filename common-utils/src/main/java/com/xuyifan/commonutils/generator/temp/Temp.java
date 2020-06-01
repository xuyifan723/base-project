package com.xuyifan.commonutils.generator.temp;

import com.xuyifan.commonutils.generator.StringHandle;
import com.xuyifan.commonutils.generator.bean.TableColumn;
import com.xuyifan.commonutils.generator.bean.TableName;
import com.xuyifan.commonutils.generator.config.ConfigureParams;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/10 8:37
 * @Version 1.0
 */
public abstract class Temp {
    private List<String> tempData = new ArrayList<>(); //模板数据
    private List<String> importPackage = new ArrayList<>();  //导入包数据
    private List<String> data = new ArrayList<>(); //正文替换完成数据
    private TableName tableName;     //表名
    private List<TableColumn> columns;  //字段数据
    private String projectUrl;        //项目地址
    private String packageName;       //包名
    private String fileSuffix;       //文件后缀名
    private Map<String, String> regex; //匹配的参数

    public Temp(TableName tableName, List<TableColumn> columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    public List<String> getTempData() {
        return tempData;
    }

    public void setTempData(List<String> tempData) {
        this.tempData = tempData;
    }

    public List<String> getImportPackage() {
        return importPackage;
    }

    public void setImportPackage(List<String> importPackage) {
        this.importPackage = importPackage;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public TableName getTableName() {
        return tableName;
    }

    public void setTableName(TableName tableName) {
        this.tableName = tableName;
    }

    public List<TableColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<TableColumn> columns) {
        this.columns = columns;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }
    public abstract void handle();

    public void getTemp(String tempName) {

        InputStream path = this.getClass().getResourceAsStream("/temp/"+tempName);
        BufferedReader br = new BufferedReader(new InputStreamReader(path));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                this.tempData.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                path.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public Map<String, String> getRegexMap (){
        //将时间进行格式化
        if (this.regex==null){
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = dateFormat.format(date);
            this.regex=new HashMap<>();
            regex.put("USERNAME", ConfigureParams.devUserName);
            regex.put("VERSION", ConfigureParams.version);
            regex.put("DATE", format);
        }
        regex.put("TABLENAMEUP",StringHandle.toClassUpStr(tableName.getTableName(),ConfigureParams.ingoreStrs));
        regex.put("TABLENAME",tableName.getTableName());
        regex.put("PRIMARYKEYTYPE","String");
        regex.put("TABLECOMMENT",tableName.getComment());
        regex.put("TABLENAMELOW",StringHandle.toClassLowStr(tableName.getTableName(),ConfigureParams.ingoreStrs));
        regex.put("PACKAGENAME",packageName);
        return this.regex;
    }
    public File getFile(){
        String url=null;
        if (this.fileSuffix.endsWith("xml")){
             url = this.projectUrl;
        }else {
             url = this.projectUrl + "/src/main/java/" + this.packageName.replaceAll("\\.", "/");
        }
        File file = new File(url);
        if (!file.exists()) {
            file.mkdirs();
        }
        File writeName = new File(url + "/" + StringHandle.toClassUpStr(this.tableName.getTableName(),ConfigureParams.ingoreStrs) + this.fileSuffix); // 相对路径，如果没有则要建立一个新的output.txt文件
        return writeName;
    }
    /**
     * 写入TXT文件
     */
    public void writeFile() throws IOException {
        this.handle();
        FileWriter writer = null;
        BufferedWriter out = null;
        try {
            File writeName = getFile();
            if (writeName.exists()){

            }else {
                writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            }


            writer = new FileWriter(writeName);
            out = new BufferedWriter(writer);
            if (!this.fileSuffix.endsWith("xml")){
                out.write("package " + this.packageName + ";\r\n");
            }
            for (String ip : this.getImportPackage()) {
                out.write(ip + "\r\n");
            }
            for (String tempDatum : this.getData()) {
                out.write(tempDatum + "\r\n");
            }
            out.flush(); // 把缓存区内容压入文件
            System.out.println("------"+StringHandle.toClassUpStr(this.tableName.getTableName(),ConfigureParams.ingoreStrs) + this.fileSuffix);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out!=null){
                out.close();
            }
            if (writer!=null){
                writer.close();
            }
        }
    }
}
