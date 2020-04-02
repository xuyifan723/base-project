package com.xuyifan.commonutils.common;

import com.xuyifan.commonutils.exception.BizException;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/6 10:25
 * @Version 1.0
 */
public class HearUserUtils {
    public static final String HEARD_NAME="authCode";    //存放用户的请求头名称
    public static final Long EXPIRE_TIME = 1000 * 60 * 30L; //过期时间   30分钟
    public static String splitStr="--";   //设置两个数据的分割附
    public static Integer getUser(HttpServletRequest request){
        String code = request.getHeader(HEARD_NAME);
        if (StringUtils.isEmpty(code)||code.equals("null")){
            return null;
        }
        String decrypt = AESUtil.decrypt(code);
        String[] infos = decrypt.split(splitStr);
        if (infos.length!=2){
            return null;
        }
        Long startTime = Long.valueOf(infos[1]);
        Long nowTime = System.currentTimeMillis();
        Long time=nowTime-startTime;
        if (time>EXPIRE_TIME){
            return null;
        }
        return Integer.valueOf(infos[0]);
    }
    public static void setUser(HttpServletResponse response, Integer userId){
        String userInfo = userId + splitStr + System.currentTimeMillis();
        response.setHeader(HEARD_NAME,AESUtil.encrypt(userInfo));
    }
}
