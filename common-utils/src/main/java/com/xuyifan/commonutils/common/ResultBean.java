package com.xuyifan.commonutils.common;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/8/22 9:19
 * @Version 1.0
 */
public class ResultBean {
    public final static Integer ERROR_CODE=5000;
    public final static Integer SUCCESS_CODE=2000;
    public final static Integer USER_NO_LOGIN_CODE=3000;
    private int code;
    private String msg;
    private Object data;
    public ResultBean() {
        this.code=this.SUCCESS_CODE;
        this.msg="ok";
    }
    public ResultBean(int code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.data = object;
    }
    public ResultBean(Object data){
        this.code=this.SUCCESS_CODE;
        this.msg="ok";
        this.data=data;
    }
    public ResultBean error(String msg){
        this.code=this.ERROR_CODE;
        this.msg=msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultBean getFail(String msg){
        ResultBean resultBean=new ResultBean();
        resultBean.setData(null);
        resultBean.setMsg(msg);
        resultBean.setCode(ResultBean.ERROR_CODE);
        return resultBean;
    }
}
