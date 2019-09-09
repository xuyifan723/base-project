package com.xuyifan.commonutils.generator;

import com.xuyifan.commonutils.generator.bean.TableColumn;
import com.xuyifan.commonutils.generator.bean.TableName;
import com.xuyifan.commonutils.generator.config.ConfigureParams;

import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/7 16:02
 * @Version 1.0
 */
public class StringHandle {
    private String beanPackage;
    private  Map<String, String> regex;
    public String getBeanPackage() {
        return beanPackage;
    }

    public void setBeanPackage(String beanPackage) {
        this.beanPackage = beanPackage;
    }

    /**
     * 功能描述:将表名转为文件类名
     * @Param: [str]
     * @Return: java.lang.String
     * @Author: Xu yifan
     * @Date: 2019/9/9 15:02
     */
    public static String toClassUpStr(String str) {
        String[] vals = str.split("_");
        StringBuffer strBuf = new StringBuffer();
        for (String val : vals) {
            char[] ch = val.toCharArray();
            if (ch[0] >= 'a' && ch[0] <= 'z') {
                ch[0] = (char) (ch[0] - 32);
            }
            strBuf.append(new String(ch));
        }
        return strBuf.toString();
    }
    public Map<String, String> getRegexMap (){
        //将时间进行格式化
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        if (this.regex==null){
            this.regex=new HashMap<>();
            regex.put("USERNAME", ConfigureParams.devUserName);
            regex.put("VERSION", ConfigureParams.version);
        }
        regex.put("DATE", format);
        return this.regex;
    }

    /**
     * 功能描述:将字符串中的参数进行替换
     *
     * @Param: [str]
     * @Return: java.lang.String
     * @Author: Xu yifan
     * @Date: 2019/9/9 8:38
     */
    public String handleStr(String str,Map<String,String> regexMap) {
        Matcher m = Pattern.compile("%\\{(\\w+)\\}%").matcher(str);
        StringBuffer result = new StringBuffer();
        while (m.find()){
            String val=m.group(1);
            m.appendReplacement(result, regexMap.get(val));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put("myTable", "aaa");
        params.put("username", "zhangsan");
        params.put("Title", "hehe");
        StringBuffer result = new StringBuffer();
        String str = "${myTable} fiejifefwo${username}fefe";
        Matcher m = Pattern.compile("\\$\\{(\\w+)\\}").matcher(str);
        while (m.find()){
            System.out.print(m.group(0)+"\n");
            String val=m.group(1);
            m.appendReplacement(result, params.get(val));
        }
        System.out.println(result);
    }
}
