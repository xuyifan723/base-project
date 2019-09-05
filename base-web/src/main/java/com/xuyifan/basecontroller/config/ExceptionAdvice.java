package com.xuyifan.basecontroller.config;

import com.xuyifan.basecontroller.exception.UserException;
import com.xuyifan.commonutils.common.ResultBean;
import com.xuyifan.commonutils.exception.BizException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
/**
 * @author Xu yifan
 * @Ddecription 全局异常处理类
 * @date 2019/8/13 10:06
 * @Version 1.0
 */

//@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResultBean myException(HttpServletRequest request, BizException e) {
        e.printStackTrace();
        Integer code = e.getCode();
        String message = e.getMessage();
        return new ResultBean(code,message,null);

    }

}
