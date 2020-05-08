package com.xuyifan.baseservice.common;

import com.xuyifan.basedao.bean.UserBean;
import com.xuyifan.commonutils.common.ResultBean;
import com.xuyifan.commonutils.exception.BizException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取用户信息
 * @Author: xuyifan
 * @Date: 2020/5/7
 */
public class SysRequest {
    public static final String CURRENT_USER="currentUser";
    public static UserBean getUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object userObj = request.getAttribute(SysRequest.CURRENT_USER);
        if (userObj==null){
            throw new BizException(ResultBean.USER_NO_LOGIN_CODE, "用户没有登录", null);
        }
        UserBean user = (UserBean)request.getAttribute(SysRequest.CURRENT_USER);
      return user;
    }
}
