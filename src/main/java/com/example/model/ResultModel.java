package com.example.model;


/**
 *@Date     : 2017/10/31 
 *@Author   : whilte
 *@Describe : 返回数据模型
 */
public class ResultModel<T> {

    /**
     * 状态码
     **/
    private Integer code;

    /**
     * 提示信息
     **/
    private String msg;

    /**
     * 具体内容
     **/
    private T data;

    public ResultModel() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
