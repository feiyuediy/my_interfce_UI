package com.xaa.api.Sec;

import com.xaa.Utils.JsonUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/7/8.
 */
public class Sec {
    @Test
    public void test_3(){
        Map<String,Object> dataMap = new HashMap<String,Object>();
        dataMap.put("tag", "data");
        dataMap.put("hospitalName", "宜都市妇幼保健院");
        dataMap.put("name", "欧阳夏凡");
        dataMap.put("gender", "女");
        dataMap.put("age", "28");
        dataMap.put("code", "420502042");
        dataMap.put("examineDoc", "杨林");
        dataMap.put("examineDate", "2016-05-10");
        dataMap.put("verifyDoc", "王菲");
        System.out.println(dataMap);

        String x = JsonUtils.obj2JsonString(dataMap);
        System.out.println(x);
    }

    @Test
    @Parameters({"testEvn","testEvn1"})
    public void test_4(String testEvn,String testEvn1){
        System.out.println(testEvn);
        System.out.println(testEvn1);
    }

}
