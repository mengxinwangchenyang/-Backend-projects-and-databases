package com.mayikt.service.entity;

import lombok.Data;

@Data
public class Result {

    private int code;
    private String message;
    private Object data;

    public static Result success(Object data) {
        Result result = new Result();
        result.data = data;
        result.message = "成功";
        result.code = 200;
        return result;
    }
}
