package com.xuyifan.basecontroller.config.filter;

import com.xuyifan.commonutils.annotation.IgnoreSecurity;
import com.xuyifan.commonutils.user.HearUserUtils;
import com.xuyifan.commonutils.common.ResultBean;
import com.xuyifan.commonutils.common.ValidateUtils;
import com.xuyifan.commonutils.exception.BizException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author Xu yifan
 * @Ddecription 用户拦截器
 * @date 2019/8/12 15:26
 * @Version 1.0
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
            return true;
        }
        Integer userId = HearUserUtils.getUser(request);
        if (userId == null) {
            throw new BizException(ResultBean.USER_NO_LOGIN_CODE, "用户没有登录", null);
        }
        ValidateUtils.validate(userId, "用户没有登录");
        HearUserUtils.setUser(httpServletResponse, userId);

        request.setAttribute("currentUser", userId);
        return true;

    }
}
