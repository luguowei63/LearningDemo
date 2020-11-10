package com.lgw.android.common.http.base;

/**
 * Created by lgw on 2020/11/10
 */
public class BaseResponse<T>  {
   private int code;
   private String errMsg;
   private T content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
