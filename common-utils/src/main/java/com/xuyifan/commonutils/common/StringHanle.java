package com.xuyifan.commonutils.common;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @author: Xu yifan
 * @date: 2019/11/5 0005 15:11
 */
public class StringHanle {
    public static final String NUM_REGEXP = "-?[0-9]*.?[0-9]*";
    public static final String LETTER_REGEXP = "[a-zA-Z]+";

    /**
     * 验证字符串是否为数字类型NUM_REGEXP或者字母LETTER_REGEXP
     *
     * @param val   字符串
     * @param regex 校验规则
     * @return
     */
    public static boolean validateStrFormat(String val, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(val).matches();
    }

    /**
     * 功能描述:替换字符串，将字符串中的固定字符的替换
     *
     * @Param: [regex 匹配正则, msg 第一个是msg,后面就是替换的str]
     * @Return: java.lang.String
     * @Author: Xu yifan
     * @Date: 2019/8/22 9:38
     */
    public static String getMsg(String regex, Object... msg) {
        StringBuilder str = new StringBuilder();
        int index = 1;
        String msginfo = " " + (String) msg[0] + " ";
        String[] strArray = null;
        if (StringUtils.isNotEmpty(msginfo)) {
            strArray = msginfo.split(regex);
        }

        for (String msgStr : strArray) {
            str.append(msgStr);
            if (msg.length - 1 > index) {
                str.append(msg[index]);
            }
            index++;
        }
        String result = str.toString().replaceFirst(" ", "");
        return result.substring(0, result.length() - 1);
    }

    /**
     * 字母字符串变大写排序
     * @param str
     * @return
     */
    public static String sortStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        String val = str.trim().toUpperCase();
        char[] valArray = val.toCharArray();
        StringBuilder sb = new StringBuilder();
        Arrays.sort(valArray);
        for (int i = 0; i < valArray.length; i++) {
            sb.append(valArray[i]);
        }
        String trim = sb.toString().trim();
        return trim;

    }

    /**
     * 验证字符串是否为空
     * @param item
     * @return
     */
    public static boolean isNotEmpty(String item) {
        if (item != null && !item.trim().equals("") && !"null".equals(item)) {
            return true;
        }
        return false;
    }

    /**
     * 将字符串转为字符串数组
     * @param str
     * @return
     */
    public static String[] strToArray(String str) {
        char[] chars = str.toCharArray();
        String[] strArr = new String[chars.length];
        Integer index = 0;
        for (char aChar : chars) {
            strArr[index] = String.valueOf(aChar);
            index++;
        }
        return strArr;
    }

    /**
     * 字符串转为整型数组
     * @param str
     * @return
     */
    public static Integer[] strToIntegerArray(String str) {
        String[] split = str.split(",");
        Integer[] con = new Integer[split.length];
        Integer index = 0;
        for (Integer num : con) {
            num = Integer.valueOf(split[index]);
            con[index] = num;
            index++;
        }

        return con;
    }

    /**
     * 字符串数组转为字符串
     * @param strs
     * @return
     */
    public static String arrayToStr(String[] strs) {
        return StringUtils.join(strs);
    }

    /**
     * 替换字符串的数据
     * @param msg
     * @return
     */
    public static String getMsg(Object... msg) {
        String regex = "\\{%s\\}";
        StringBuilder str = new StringBuilder();
        int index = 1;
        String msginfo = " " + (String) msg[0] + " ";
        String[] strArray = null;
        if (StringUtils.isNotEmpty(msginfo)) {
            strArray = msginfo.split(regex);
        }
        for (String msgStr : strArray) {
            str.append(msgStr);
            if (msg.length > index) {
                str.append(msg[index]);
            }
            index++;
        }
        String result = str.toString().replaceFirst(" ", "");
        return result.substring(0, result.length() - 1);
    }

    /**
     * 复制几个字符串
     * @param length
     * @param cha
     * @return
     */
    public static String genStr(int length, String cha) {
//        if(length == 1){
//            return "1";
//        }
//        if(length == 0){
//            return "";
//        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(cha);
        }
        return sb.toString();
    }

    public static String handleQuesNumber(String quesNum) {
        String[] quesNums = quesNum.split(",");
        if (quesNums.length > 1) {
            Integer end = Integer.valueOf(quesNums[quesNums.length - 1]);
            Integer start = Integer.valueOf(quesNums[0]);
            if (end - start == quesNums.length - 1) {
                return start + "-" + end;
            }
        }
        return quesNum;
    }


    public static void main(String[] args) {
        String strings = StringHanle.sortStr("bac");
        System.out.println(strings);
    }
}
