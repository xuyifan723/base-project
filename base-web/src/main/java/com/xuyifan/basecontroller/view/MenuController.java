package com.xuyifan.basecontroller.view;

import com.xuyifan.commonutils.annotation.CurrentUser;
import com.xuyifan.basedao.bean.User;
import com.xuyifan.baseservice.menu.MenuService;
import com.xuyifan.commonutils.common.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/5 16:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @GetMapping("/getLists")
    public ResultBean getMenuList(@CurrentUser User user ){
        System.out.println(user.getLoginName());
      menuService.selectByPrimaryKey(1);
      return new ResultBean(user);
    }
}
