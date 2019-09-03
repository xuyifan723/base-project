package com.xuyifan.commonutils.common;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/8/22 9:19
 * @Version 1.0
 */
public class ResultBean {
    private int code=0;
    private String msg="ok";
    private Object object;
    public ResultBean() {
    }
    public ResultBean(int code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }
    public ResultBean(Object data){
        this.object=data;
    }


}
