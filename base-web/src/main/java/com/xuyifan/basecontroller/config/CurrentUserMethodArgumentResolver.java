package com.xuyifan.basecontroller.config;


import com.xuyifan.commonutils.annotation.CurrentUser;
import com.xuyifan.commonutils.common.SysUserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * @author Xu yifan
 * @Ddecription 方法参数解析器
 * @date 2019/8/12 15:33
 * @Version 1.0
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private UserService userService;
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //使用注解为CurrentUser 参数类型为user
        return methodParameter.getParameterType().isAssignableFrom(UserBean.class) && methodParameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Integer userId = (Integer) nativeWebRequest.getAttribute("currentUser", RequestAttributes.SCOPE_REQUEST);
        if (userId != null) {
            UserBean user = userService.selectByPrimaryKey(userId);
            if (user==null){
                throw  new MissingServletRequestPartException("currentUser");
            }
            SysUserUtils.setVal(user);
            return user;
        }
        throw new MissingServletRequestPartException("currentUser");

    }
}
