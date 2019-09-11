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
            char[] ch = val.toLowerCase().toCharArray();
            if (ch[0] >= 'a' && ch[0] <= 'z') {
                ch[0] = (char) (ch[0] - 32);
            }
            strBuf.append(new String(ch));
        }
        return strBuf.toString();
    }
    public static String toClassLowStr(String str) {
        String[] vals = str.split("_");
        StringBuffer strBuf = new StringBuffer();
        boolean flag=false;
        for (String val : vals) {
            char[] ch = val.toLowerCase().toCharArray();
            if (ch[0] >= 'a' && ch[0] <= 'z'&&flag) {
                ch[0] = (char) (ch[0] - 32);
            }else {
               flag=true;
            }
            strBuf.append(new String(ch));
        }
        return strBuf.toString();
    }


    /**
     * 功能描述:将字符串中的参数进行替换
     *
     * @Param: [str]
     * @Return: java.lang.String
     * @Author: Xu yifan
     * @Date: 2019/9/9 8:38
     */
    public static String handleStr(String str,Map<String,String> regexMap) {
        Matcher m = Pattern.compile("%\\{(\\w+)\\}%").matcher(str);
        StringBuffer result = new StringBuffer();
        while (m.find()){
            String val=m.group(1);
            String tempVal = regexMap.get(val);
            if (tempVal==null){
                throw new RuntimeException(val+"  没有参数");
            }
            m.appendReplacement(result, tempVal);
        }
        m.appendTail(result);
        return result.toString();
    }
    public static boolean validateStr(String str,String regexp){
        Matcher m = Pattern.compile("%\\{(\\w+)\\}%").matcher(str);
        while (m.find()){
            String val=m.group(1);
            if (regexp.equals(val)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
       String str="OWieFJOIJFOE";
      /*  String s = StringHandle.toClassLowStr(str);
        System.out.println(s);*/
        Map<String,String> data=new HashMap<>();
        data.put("fe","我不知道");
        String s1 = StringHandle.handleStr(str, data);
        System.out.println(s1);

    }
}
