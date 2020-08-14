package com.xuyifan.projectinit.searchbean;

import lombok.Data;

/**
 * @Author: xuyifan
 * @Date: 2020/8/14
 */
@Data
public class PageBean {
    private Integer page;
    private Integer limit;
    public Integer getCurNumIndex(){
        if (page!=null&&limit!=null){
            return (this.page-1)*this.limit;
        }else {
           return 0;
        }
    }
}
