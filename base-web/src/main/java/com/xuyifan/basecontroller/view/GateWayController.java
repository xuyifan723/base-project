package com.xuyifan.basecontroller.view;




import com.xuyifan.basedao.bean.UserBean;
import com.xuyifan.baseservice.service.UserService;
import com.xuyifan.commonutils.user.HearUserUtils;
import com.xuyifan.commonutils.common.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    public ResultBean login(HttpServletResponse response, @RequestBody UserBean userBean){

        List<UserBean> users = userService.selectListBySelective(userBean);
        if (users!=null&&users.size()>0){
            UserBean user=users.get(0);
            HearUserUtils.setUser(response,user.getId());
            return  new ResultBean(user);
        }else {
            return new ResultBean().error("用户名或者密码错误");
        }
    }
    @PostMapping("/getUserInfo")
    public ResultBean getUserInfo(@RequestBody UserBean userBean){
        List<UserBean> users = userService.selectListBySelective(userBean);
        if (users!=null&&users.size()>0){
            UserBean user=users.get(0);
            return  new ResultBean(user);
        }else {
            return new ResultBean().error("用户名或者密码错误");
        }
    }
}
