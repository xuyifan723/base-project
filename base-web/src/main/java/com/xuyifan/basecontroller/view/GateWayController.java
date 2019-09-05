package com.xuyifan.basecontroller.view;

import com.xuyifan.basecontroller.bean.UserBean;
import com.xuyifan.basedao.bean.User;
import com.xuyifan.baseservice.user.UserService;
import com.xuyifan.commonutils.common.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/login")
    public ResultBean login(@RequestBody UserBean userBean){
        User user = userService.validateUser(userBean.getUsername(),userBean.getPassword());
        if (user!=null){
            return  new ResultBean(user);
        }else {
            return new ResultBean().error("用户名或者密码错误");
        }
    }
}
