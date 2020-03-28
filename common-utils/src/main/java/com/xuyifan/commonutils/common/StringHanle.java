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
    public static final String NUM_REGEXP="-?[0-9]*.?[0-9]*";
    public static final String LETTER_REGEXP="[a-zA-Z]+";
   public static boolean validateStrFormat(String val, String regex){
       Pattern pattern = Pattern.compile(regex);
       return pattern.matcher(val).matches();
   }

   public static String sortStr(String str){
       if (StringUtils.isEmpty(str)){
           return "";
       }
       String val = str.trim().toUpperCase();

       char[] test = new char[val.length()];
       StringBuilder sb = new StringBuilder();
       while (true) {
           String a = val;//直接读取这行当中的字符串。
           for (int i = 0; i < val.length(); i++) {
               test[i] = a.charAt(i);//字符串处理每次读取一位。
           }
           Arrays.sort(test);
           for (int i = 0; i < test.length; i++) {
               sb.append(test[i]);
           }
           String trim = sb.toString().trim();
           return trim;
       }
   }

    public static boolean isNotEmpty(String item){
        if (item!=null&&!item.trim().equals("")&&!"null".equals(item)){
            return true;
        }
        return false;
    }


    public static String[] strToArray(String str){
        char[] chars = str.toCharArray();
        String[]  strArr=new String[chars.length];
        Integer index=0;
        for (char aChar : chars) {
            strArr[index]= String.valueOf(aChar);
            index++;
        }
        return strArr;
    }
    public static Integer[] strToIntegerArray(String str){
        String[] split = str.split(",");
        Integer[] con=new Integer[split.length];
        Integer index=0;
        for (Integer num : con) {
            num= Integer.valueOf(split[index]);
            con[index]=num;
            index++;
        }

        return con;
    }
    public static String arrayToStr(String[] strs){
        return StringUtils.join(strs);
    }

    public static String getMsg(Object... msg){
        String regex="\\{%s\\}";
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

    public static String genStr(int length , String cha){
//        if(length == 1){
//            return "1";
//        }
//        if(length == 0){
//            return "";
//        }
        StringBuffer sb = new StringBuffer();
        for(int i =0;i<length;i++){
            sb.append(cha);
        }
        return sb.toString();
    }

    public static String handleQuesNumber(String quesNum){
        String[] quesNums = quesNum.split(",");
        if (quesNums.length>1){
            Integer end= Integer.valueOf(quesNums[quesNums.length-1]);
            Integer start= Integer.valueOf(quesNums[0]);
            if (end-start==quesNums.length-1){
                return start+"-"+end;
            }
        }
        return quesNum;
    }



    public static void main(String[] args) {
       String strings = StringHanle.sortStr("bac");
        System.out.println(strings);
    }
}
