package com.xuyifan.commonutils.exception;

import com.xuyifan.commonutils.common.ResultBean;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/4 17:20
 * @Version 1.0
 */
public class BizException extends RuntimeException {
    private int code;
    private String msg;
    private Object data;

    public BizException() {
        this.code = ResultBean.ERROR_CODE;

    }

    public BizException(String message) {
        super(message);
        this.code = ResultBean.ERROR_CODE;
        this.msg = message;
    }

    public BizException(int code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }


    public BizException(int code, String message, Object data) {
        super(message);
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public void setError(int code) {
        this.setError(code, "fail");
    }

    public void setError(int code, String errmsg) {
        this.code = code;
        this.msg = errmsg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public void setData(final Object data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BizException)) {
            return false;
        } else {
            BizException other = (BizException)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BizException;
    }


    public String toString() {
        return "BizException(code=" + this.getCode() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
    }
}
