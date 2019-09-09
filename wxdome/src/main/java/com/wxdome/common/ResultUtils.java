package com.wxdome.common;

import java.util.Map;

public class ResultUtils<T> {
    private static final String CODE_SUCCESS = "200";

    private static final String CODE_FAIL = "400";

    private static final String MSG_SUCCESS="success";

    private static final String MSG_FAIL="fail";

    public ResultUtils(){
    }
    public ResultUtils(String code ){
        this.code=code;
    }
    public ResultUtils(String code,T data ){
        this.code=code;
        this.data=data;
    }
    public ResultUtils(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public ResultUtils(String code, String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data=data;
    }
    public static ResultUtils success(){
        return new ResultUtils(CODE_SUCCESS,MSG_SUCCESS);
    }

    public static ResultUtils success(Object data){
        return new ResultUtils(CODE_SUCCESS,MSG_SUCCESS, data);
    }

    public static ResultUtils fail(){
        return new ResultUtils(CODE_FAIL, MSG_FAIL);
    }

    public static ResultUtils fail(Object data){
        return new ResultUtils(CODE_FAIL,MSG_FAIL,data);
    }

    private String code;

    private String msg;

    public T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
