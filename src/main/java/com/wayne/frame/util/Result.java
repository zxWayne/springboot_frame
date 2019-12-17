package com.wayne.frame.util;

import java.time.LocalDateTime;
import java.util.HashMap;


/**
 * 返回数据的统一处理
 */
public class Result extends HashMap<String, Object> {


    private static Result response = new Result();

    /**
     * init
     */
    private static void createResponse() {

        response.put("data", null);
        response.put("time", LocalDateTime.now());
    }

    public static Result ok(String message) {
        createResponse();
        response.put("message", message);
        return response;
    }
    public static Result ok() {
        createResponse();
        response.put("message", "success");
        return response;
    }

    public static Result data(Object data) {
        createResponse();
        response.put("code", 0);
        response.put("data", data);
        return response;
    }

    public static Result error(String errorMessage) {
        createResponse();
        response.put("code", 1);
        response.put("message", errorMessage);
        return response;
    }


}
