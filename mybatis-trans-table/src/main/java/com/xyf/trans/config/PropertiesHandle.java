package com.xyf.trans.config;

import java.io.File;
import java.util.Properties;

/**
 * @Author: xuyifan
 * @Date: 2020/6/11
 */
public class PropertiesHandle {
    private String beanURL;
    private String projectURL;

    public PropertiesHandle(String beanURL) {
        this.beanURL = beanURL;
    }

    public PropertiesHandle(String beanURL, String projectURL) {
        this.beanURL = beanURL;
        this.projectURL = projectURL;
    }

    public void getConfigValue(){
        String path = System.getProperty("user.dir");
        StringBuffer beanPath=new StringBuffer(path);
        if (this.projectURL!=null){
            beanPath.append(File.separator+this.projectURL);
        }

        beanPath.append(File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator);
        String packagePath = this.beanURL.replace(".", File.separator);
        beanPath.append(packagePath);
        System.out.println(beanPath);
        Properties prop = new Properties();
    }
}
