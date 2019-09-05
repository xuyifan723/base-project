package com.xuyifan.commonutils.common;



import com.xuyifan.commonutils.exception.BizException;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * @author Xu yifan
 * @Ddecription 验证工具类
 * @date 2019/8/29 16:40
 * @Version 1.0
 */
public class ValidateUtils {

    public static void validate(boolean flag, String... msg) {
        if (flag){
            throw new BizException(getMsg("\\{%s\\}",msg));
        }
    }
    /**
     * 功能描述:验证字符串是否为空，为空抛出异常
     *
     * @Param: [value  字符串, msg 一旦报错抛出的异常]
     * @Return: void
     * @Author: Xu yifan
     * @Date: 2019/8/29 16:45
     */
    public static void validate(String value, String... msg) {
        if (value == null || StringUtils.isEmpty(value)) {
            throw new BizException(getMsg("\\{%s\\}",msg));
        }
    }

    /**
     * 功能描述:验证对象是否为空
     *
     * @Param: [item, msg]
     * @Return: void
     * @Author: Xu yifan
     * @Date: 2019/8/29 17:20
     */
    public static void validate(Object item, String... msg) {
        validate(item==null,msg);
    }

    /**
     * 功能描述:验证集合是否为空，不然抛出异常
     *
     * @Param: [items, msg]
     * @Return: void
     * @Author: Xu yifan
     * @Date: 2019/8/29 16:47
     */
    public static void validate(List items, String... msg) {
        if (items == null || items.size() < 1) {
            throw new BizException(getMsg("\\{%s\\}",msg));
        }
    }

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
            if (msg.length>index){
                str.append(msg[index]);
            }
            index++;
        }
        String result=str.toString().replaceFirst(" ","");
        return result.substring(0,result.length()-1);
    }


    public static void main(String[] args) {
        try {
            validate("","wobushizdao key");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
