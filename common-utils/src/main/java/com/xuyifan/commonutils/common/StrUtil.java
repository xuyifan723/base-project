package com.xuyifan.commonutils.common;

import org.apache.commons.lang.StringUtils;

/**
 * @Classname StrUtil
 * @Description TODO
 * @Date 2019/7/8 0008 下午 1:25
 * @Created by XUYIFAN723
 */
public class StrUtil {
   /**
    * 功能描述:替换字符串，将字符串中的固定字符的替换
    * @Param: [regex 匹配正则, msg 第一个是msg,后面就是替换的str]
    * @Return: java.lang.String
    * @Author: Xu yifan
    * @Date: 2019/8/22 9:38
    */
    public static String getMsg(String regex,Object... msg){
        StringBuilder str=new StringBuilder();
        int index=1;
        String msginfo=" "+(String) msg[0]+" ";
        String[] strArray=null;
        if (StringUtils.isNotEmpty(msginfo)){
            strArray = msginfo.split(regex);
        }

        for (String msgStr : strArray) {
           str.append(msgStr);
           if (msg.length-1>index){
               str.append(msg[index]);
           }
            index++;
        }
        String result=str.toString().replaceFirst(" ","");
        return result.substring(0,result.length()-1);
    }
}
