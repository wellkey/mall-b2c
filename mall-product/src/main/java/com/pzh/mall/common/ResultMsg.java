package com.pzh.mall.common;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/23 13:34
 * @Version 1.0
 */
public class ResultMsg<T> {
    private final Integer DEFAULT_CODE = 0;
    private final String DEFAULT_MSG = "请求成功";

    public Integer code;

    public String message;

    public T data;

    public ResultMsg() {
        this.code = DEFAULT_CODE;
        this.message = DEFAULT_MSG;
    }

    public ResultMsg(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultMsg(T data) {
        this();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
