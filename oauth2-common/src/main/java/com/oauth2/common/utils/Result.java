package com.oauth2.common.utils;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * 所有返回结果类
 *
 * @author ：Mr.Li
 * @date ：Created in 2020/5/30 18:03
 */
@Data
public class Result {


    // 响应业务状态
    private Integer code;

    // 响应消息
    private String message;

    // 响应中的数据
    private Object data;

    public Result() {
    }

    public Result(Object data) {
        this.code = 200;
        this.message = "OK";
        this.data = data;
    }

    public Result(String message, Object data) {
        this.code = 200;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result ok() {
        return new Result(null);
    }

    public static Result ok(String message) {
        return new Result(message, null);
    }

    public static Result ok(Object data) {
        return new Result(data);
    }

    public static Result ok(String message, Object data) {
        return new Result(message, data);
    }

    public static Result build(Integer code, String message) {
        return new Result(code, message, null);
    }

    public static Result build(Integer code, String message, Object data) {
        return new Result(code, message, data);
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }


    /**
     * JSON字符串转成 Result 对象
     *
     * @param json
     * @return
     */
    public static Result format(String json) {
        try {
            return JSON.parseObject(json, Result.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
