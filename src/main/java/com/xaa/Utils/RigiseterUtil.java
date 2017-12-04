package com.xaa.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.jayway.jsonpath.JsonPath;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

import java.util.Map;
import java.util.TreeMap;


import static com.xaa.Utils.HttpUtilHaha.postRuest;
import static com.xaa.Utils.HttpUtilHaha.setHeader;


/**
 * Created by admin on 2017/7/19.
 */

//注册
public class RigiseterUtil {

    //生成tk
    public static String gettk(String parm){
        TreeMap<String, String> map = JSON.parseObject(
                parm,new TypeReference<TreeMap<String, String>>(){} );

        String tk = null;

        StringBuffer sb = new StringBuffer();

        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getValue() == null ? "" : entry.getValue().trim());
            }
             tk = Common.md5(sb.toString());
        } catch (Exception e){
            System.out.println(e);
        }
        return tk;
    }
    //获取code
    public static String getCode(String env,String name, String pwd){
        String url = "/api/v2/auth/getcode";
        String pram = "{\n" +
                "    \"appid\": \""+Common.getRequstHeard("appid")+"\",\n" +
                "    \"appver\": \""+Common.getRequstHeard("appver")+"\",\n" +
                "    \"channel\": \""+Common.getRequstHeard("channel")+"\",\n" +
                "    \"clientid\": \""+Common.getRequstHeard("clientid")+"\",\n" +
                "    \"lang\": \""+Common.getRequstHeard("lang")+"\",\n" +
                "    \"password\": \""+pwd+"\",\n" +
                "    \"platform\": \""+Common.getRequstHeard("platform")+"\",\n" +
                "    \"username\": \""+name+"\",\n" +
                "    \"ver\": \""+Common.getRequstHeard("ver")+"\",\n" +
                "}";
        String tk = gettk(pram);

        String pramFinal = pram.substring(0,pram.length()-2) +"\"tk\":"+"\""+tk+"\""+"}";
        HttpRequest request = HttpRequest.post(Common.getUrl(env) + url);

        setHeader(request);
        request.form("data",pramFinal);
        HttpResponse response = request.send();

        return response.bodyText();
        }

    //获取token
    public static String getToken(String evn,String name, String pwd){
        System.out.println("进入到getToken方法，获取token");
        String url = "/api/v2/auth/gettoken";
        String pram = "{\n" +
                "    \"appid\": \""+Common.getRequstHeard("appid")+"\",\n" +
                "    \"appver\": \""+Common.getRequstHeard("appver")+"\",\n" +
                "    \"channel\": \""+Common.getRequstHeard("channel")+"\",\n" +
                "    \"clientid\": \""+Common.getRequstHeard("clientid")+"\",\n" +
                "    \"code\": \""+JsonPath.read(getCode(evn,name, pwd),"$.result.code")+"\",\n" +
                "    \"lang\": \""+Common.getRequstHeard("lang")+"\",\n" +
                "    \"platform\": \""+Common.getRequstHeard("platform")+"\",\n" +
                "    \"ver\": \""+Common.getRequstHeard("ver")+"\",\n" +
                "}";
        String tk = gettk(pram);
        HttpRequest request = HttpRequest.post(Common.getUrl(evn) + url);

        String pramFinal = pram.substring(0,pram.length()-2) +"\"tk\":"+"\""+tk+"\""+"}";
        setHeader(request);
        request.form("data",pramFinal);
        HttpResponse response = request.send();
        return JsonPath.read(response.bodyText(),"$.result.access_token");
    }
}
