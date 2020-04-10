package com.xuyifan.basecontroller.config;


import com.xuyifan.commonutils.common.ResultBean;
import com.xuyifan.commonutils.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Xu yifan
 * @Ddecription 全局异常处理类
 * @date 2019/8/13 10:06
 * @Version 1.0
 */
@Slf4j
@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends RuntimeException  {

    private static final long serialVersionUID = 543886184182203599L;

    /**
     * 内部自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BizException.class)
    @ResponseBody
    public ResultBean exceptionHandler(BizException e) {
        ResultBean result = new ResultBean();
        result.setCode(e.getCode());
        result.setMsg(e.getMsg());
        result.setData(e.getData());
        log.error(e.getMsg());
        return result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean exceptionHandler(Exception e){
        log.error(e.toString());
        e.printStackTrace();
        return ResultBean.getFail(e.getMessage());
    }



}
