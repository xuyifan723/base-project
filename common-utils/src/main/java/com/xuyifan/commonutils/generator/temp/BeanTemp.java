package com.xuyifan.commonutils.generator.temp;

import com.xuyifan.commonutils.generator.StringHandle;
import com.xuyifan.commonutils.generator.bean.TableColumn;
import com.xuyifan.commonutils.generator.bean.TableName;
import com.xuyifan.commonutils.generator.config.ConfigureParams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/6 16:06
 * @Version 1.0
 */
public class BeanTemp {
    private StringHandle handle;
    private List<String> tempData = new ArrayList<>(); //模板数据
    private List<String> importPackage = new ArrayList<>();
    private List<String> data = new ArrayList<>();
    private TableName tableName;
    private List<TableColumn> columns;

    public BeanTemp(StringHandle handle) {
        this.handle = handle;
    }

    public void init() {
    }
    public void getTemp() throws IOException {
        InputStream path = this.getClass().getResourceAsStream("/temp/beanTemp.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(path));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                this.tempData.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            br.close();
            path.close();
        }
    }

    /**
     * 写入TXT文件
     */
    public void writeFile() {
        String url = ConfigureParams.beanProjectUrl+"/src/main/java/"+ ConfigureParams.beanPackage.replaceAll("\\.", "/");
        try {
            File file = new File(url);
            if (!file.exists()) {
                file.mkdirs();
            }
            File writeName = new File(url+"/"+StringHandle.toClassUpStr(this.tableName.getTableName())+"Bean.java"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                out.write("我会写入文件啦1\r\n"); // \r\n即为换行
                out.write("我会写入文件啦2\r\n"); // \r\n即为换行
                out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String beanPackage = "com.xuyifan.bean.dao";
        String packageUrl = beanPackage.replaceAll("\\.", "/");
        System.out.println(packageUrl);

    }

}
