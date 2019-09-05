package com.xuyifan.commonutils.common;

import org.apache.commons.lang.StringUtils;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/8/12 15:10
 * @Version 1.0
 */
public class TokenUtils {
    public static final String TOKEN_NAME="loginName";
    public static String getToken(String userName){
        String user=userName+"_"+System.currentTimeMillis();
        String token = AESUtil.encrypt(user);
        return token;
    }
    public static String getUserName(String token){
        String val = AESUtil.decrypt(token);
        if (StringUtils.isNotEmpty(val)){

        }else {}
        return null;
    }
}
