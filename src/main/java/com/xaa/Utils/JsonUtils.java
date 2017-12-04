package com.xaa.Utils;

import com.alibaba.fastjson.JSON;

import java.util.Map;

public class JsonUtils {
    @SuppressWarnings("unchecked")
    public static Map<String,String> json2Map(String json){
        return JSON.parseObject(json, Map.class);
    }

    public static String obj2JsonString(Object obj){
        return JSON.toJSONString(obj);
    }
}
