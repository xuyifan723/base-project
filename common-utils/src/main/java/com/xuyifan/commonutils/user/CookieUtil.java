package com.xuyifan.commonutils.user;


import com.xuyifan.commonutils.cryptogram.AESUtil;
import org.apache.commons.lang.StringUtils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname CookieUtil
 * @Description TODO
 * @Date 2019/7/8 0008 上午 10:31
 * @Created by XUYIFAN723
 */
public class CookieUtil {
    //存用户的cookie名称
    public static final String USER_COOKIE_NAME = "Authorization";
    //用户存的过期时间为30分钟
    public static final Long EXPIRE_TIME = 1000 * 60 * 30L;

    /**
     * 从cookie里面拿出具体cookie的值
     *
     * @param name
     * @param request
     * @return
     */
    public static String getCookie(String name, HttpServletRequest request) {
 /*       String cookie1 = request.getHeader("Cookie");
        String[] cookie = cookie1.split(";");*/

        Cookie[] cookies = request.getCookies();
        String userValue = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                userValue = AESUtil.decrypt(cookie.getValue());
                break;
            }
        }
        return userValue;
    }

    /**
     * 从cookie里面拿出用户信息
     *
     * @param request
     * @return
     */
    public static String getUser(HttpServletRequest request) {
        String userValue = getCookie(USER_COOKIE_NAME, request);
        String userName = "";
        if (!StringUtils.isEmpty(userValue)) {
            String[] userInfo = userValue.split("_");
            userName = userInfo[0];
            Long loginTime = Long.valueOf(userInfo[1]);
            boolean flag = System.currentTimeMillis() - EXPIRE_TIME > loginTime;
            if (!flag) {
                throw new RuntimeException("user is expire,please login");
            }
        }
        return userName;
    }

    /**
     * 验证用户信息是否过期
     *
     * @param request
     * @return
     */
    public static boolean validateUser(HttpServletRequest request) {
        String userValue = getCookie(USER_COOKIE_NAME, request);
        boolean flag = false;
        if (!StringUtils.isEmpty(userValue)) {
            String[] userInfo = userValue.split("__");
            Long loginTime = Long.valueOf(userInfo[1]);
            flag = System.currentTimeMillis() - EXPIRE_TIME > loginTime;
        }
        return flag;
    }

    /**
     * 往cookie里面添加用户信息
     *
     * @param response
     * @param username
     */
    public static void addUser(HttpServletResponse response, String username) {
        String userInfo = username + "__" + System.currentTimeMillis();
        Cookie cookie = new Cookie(USER_COOKIE_NAME, AESUtil.encrypt(userInfo));
        response.addCookie(cookie);
        response.setHeader("userinfo",AESUtil.encrypt(userInfo));
    }

    public static void main(String[] args) {
        String userInfo =  "xuyifan"+ "__" + System.currentTimeMillis();
        String encrypt = AESUtil.encrypt(userInfo);
        System.out.println(encrypt);

    }

}
