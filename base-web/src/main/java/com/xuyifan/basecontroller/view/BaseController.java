package com.xuyifan.basecontroller.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/8/27 16:01
 * @Version 1.0
 */
@RestController
public class BaseController {
    @GetMapping("/base")
    public Object get(){
        return "key";
    }
}
