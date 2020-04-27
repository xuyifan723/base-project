package com.xuyifan.basecontroller.view;


import com.xuyifan.basedao.bean.UserBean;
import com.xuyifan.baseservice.service.UserService;
import com.xuyifan.commonutils.common.ResultBean;
import com.xuyifan.commonutils.user.HearUserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/4 15:19
 * @Version 1.0
 */
@RestController
@RequestMapping("/gateway")
public class GateWayController {
    @Autowired
    private UserService userService;

    /**
     * 用户登陆
     * @param response
     * @param userBean
     * @return
     */
    @PostMapping("/login")
    public ResultBean login(HttpServletResponse response, @RequestBody UserBean userBean){
        UserBean user = userService.getUserByUserPassword(userBean.getUserName(),userBean.getPassword());
        if (user!=null){
            HearUserUtils.setUser(response,user.getId());
            user.setPassword(null);
            return  new ResultBean(user);
        }else {
            return new ResultBean().error("用户名或者密码错误");
        }
    }

    /**
     * 用户登陆
     * @param response
     * @param userBean
     * @return
     */
    @PostMapping("/logout")
    public ResultBean logout(HttpServletResponse response, @RequestBody UserBean userBean){
        UserBean user = userService.getUserByUserPassword(userBean.getUserName(),userBean.getPassword());
        if (user!=null){
            HearUserUtils.setUser(response,user.getId());
            user.setPassword(null);
            return  new ResultBean(user);
        }else {
            return new ResultBean().error("用户名或者密码错误");
        }
    }

    /**
     * 通过id查询用户信息
     * @param userid
     * @return
     */
    @GetMapping("/getUserInfo")
    public ResultBean getUserInfo(Integer userid){
        UserBean user = userService.getUserById(userid);
        if (user!=null){
            user.setPassword(null);
            return  new ResultBean(user);
        }else {
            return new ResultBean().error("用户名或者密码错误");
        }
    }
}
