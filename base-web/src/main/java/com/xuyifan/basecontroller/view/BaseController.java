package com.xuyifan.basecontroller.view;

import com.xuyifan.basedao.bean.User;
import com.xuyifan.baseservice.user.UserService;
import com.xuyifan.commonutils.common.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/8/27 16:01
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class BaseController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public Object get(@RequestParam("id") int id){
        User userById = userService.getUserById(id);
        return new ResultBean(userById);
    }
}
