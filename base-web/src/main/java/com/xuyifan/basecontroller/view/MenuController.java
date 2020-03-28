package com.xuyifan.basecontroller.view;

import com.xuyifan.basedao.bean.ResMenuBean;
import com.xuyifan.basedao.bean.UserBean;
import com.xuyifan.baseservice.service.ResMenuService;
import com.xuyifan.commonutils.annotation.CurrentUser;
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
    private ResMenuService menuService;
    @GetMapping("/getLists")
    public ResultBean getMenuList(@CurrentUser UserBean user ){
        System.out.println(user.getLoginName());

        ResMenuBean resMenuBean = menuService.selectByPrimaryKey(1);
        return new ResultBean(resMenuBean);
    }
}
