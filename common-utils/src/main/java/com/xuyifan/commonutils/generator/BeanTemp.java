package com.xuyifan.commonutils.generator;

import java.io.*;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/6 16:06
 * @Version 1.0
 */
public class BeanTemp {
    private StringHandle handle;

    public BeanTemp(StringHandle handle) {
        this.handle = handle;
    }


    public  void readFile() {
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        InputStream path = this.getClass().getResourceAsStream("/temp/beanTemp.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(path));
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        try {
            String line;
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                String handleStr = handle.handleStr(line);
                System.out.println(handleStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入TXT文件
     */
    public  void writeFile() {
        try {
            File writeName = new File("output.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
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


    }

}
