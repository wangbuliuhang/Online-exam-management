package com.cn.shixun.common;

public class Message {
    public Message(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    private String code;
    private String msg;

    public void setInfo(String code,String msg)
    {
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
