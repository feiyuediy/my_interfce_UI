package com.xaa.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xaa.Module.HttpMoudle;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.omg.CORBA.ObjectHelper;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;


public class HttpUtilHaha {
    private static Logger logger = LogManager.getLogger("HttpUtilHaha");
    private static String token;

    private static String appid = Common.getRequstHeard("appid");
    private static String appver = Common.getRequstHeard("appver");
    private static String channel = Common.getRequstHeard("channel");
    private static String clientid = Common.getRequstHeard("clientid");
    private static String lang = Common.getRequstHeard("lang");
    private static String platform = Common.getRequstHeard("platform");
    private static String ver = Common.getRequstHeard("ver");


    public static void send(String evn,HttpMoudle httpMoudle){
        //解析httpMoudle
        String name = httpMoudle.getName();
        //获取request
        Map<String,Object> request = httpMoudle.getRequest();
        //获取url
        String url = request.get("url").toString();
        logger.info("url:"+url);
        //获取是否需要登录
        String isneedLogin = request.get("isneedLogin").toString();
        logger.info("isneedLogin"+isneedLogin);
        if (isneedLogin.equals("true")){
            String acc =  request.get("acc").toString();
            String pwd =  request.get("pwd").toString();
            getToken(evn,acc,pwd);
        }

        //获取mode
        String mode = request.get("mode").toString();

        /* 获取data */
        String dataString = JsonUtils.obj2JsonString(request.get("data"));
        Map<String , String> data = JsonUtils.json2Map(dataString);
        //获取validators
        Map<String,Object> validators  = httpMoudle.getValidators();
//        logger.info("validators:"+validators);

        String result ="";
        if (mode.equals("post")){
            try{
                result = postRuest(evn,url,data);
            }catch (NullPointerException e){
                result = postRuest(evn,url);
            }

        }if (mode.equals("get")){
//            getRuest(url,data);
        }

        //校验validators
        AssertionUtil.assertion(result,validators);
    }
    //获取token
    private static void getToken(String evn,String naame, String passWord){
        if (token == null){
            token = RigiseterUtil.getToken(evn,naame,passWord);
        }
    }
    public static String postRuestForUI(String url, Map<String,String> pram,String token1){
        HttpRequest request = HttpRequest.post(url);

        String parm_hear = "";
        pram.put("appid",appid);
        pram.put("appver",appver);
        pram.put("channel",channel);
        pram.put("clientid",clientid);
        pram.put("lang",lang);
        pram.put("platform",platform);
        pram.put("ver",ver);
        for (Map.Entry<String, String> entry : pram.entrySet()) {
            try {
                parm_hear =parm_hear +"\"" +entry.getKey()+"\""+":"+"\""+entry.getValue()+"\""+",";
            }catch (ClassCastException e){
                parm_hear =parm_hear +"\"" +entry.getKey()+"\""+":"+"\""+String.valueOf(entry.getValue())+"\""+",";            }
        }
        parm_hear = "{"+parm_hear.substring(0,parm_hear.length()-1)+","+"\""+"token"+"\""+":"+"\""+token1+"\""+"}";
        String tk = RigiseterUtil.gettk(parm_hear);
        String finalParm = parm_hear.substring(0,parm_hear.length()-1) +",\"tk\":"+"\""+tk+"\""+"}";
        logger.info("请求参数："+finalParm);
        setHeader(request);
        request.form("data",finalParm);
        HttpResponse response = request.send();

        logger.info("返回接口："+ response.bodyText());

        return response.bodyText();
    }
    public static String postRuest(String evn,String url, Map<String,String> pram){
        HttpRequest request = HttpRequest.post(url);
        if (token ==null){
            getToken( evn,Common.getUserInfo("name") , Common.getUserInfo("passWord"));
        }
        String parm_hear = "";
        pram.put("appid",appid);
        pram.put("appver",appver);
        pram.put("channel",channel);
        pram.put("clientid",clientid);
        pram.put("lang",lang);
        pram.put("platform",platform);
        pram.put("ver",ver);
        for (Map.Entry<String, String> entry : pram.entrySet()) {
            try {
                parm_hear =parm_hear +"\"" +entry.getKey()+"\""+":"+"\""+entry.getValue()+"\""+",";
            }catch (ClassCastException e){
                parm_hear =parm_hear +"\"" +entry.getKey()+"\""+":"+"\""+String.valueOf(entry.getValue())+"\""+",";            }
        }
        parm_hear = "{"+parm_hear.substring(0,parm_hear.length()-1)+","+"\""+"token"+"\""+":"+"\""+token+"\""+"}";
        String tk = RigiseterUtil.gettk(parm_hear);
        String finalParm = parm_hear.substring(0,parm_hear.length()-1) +",\"tk\":"+"\""+tk+"\""+"}";
        logger.info("请求参数："+finalParm);
        setHeader(request);
        request.form("data",finalParm);
        HttpResponse response = request.send();

        logger.info("返回接口："+ response.bodyText());

        return response.bodyText();
    }
    public static String postRuest(String evn,String url){
        HttpRequest request = HttpRequest.post(url);
        if (token ==null){
            getToken(evn,Common.getUserInfo("name") , Common.getUserInfo("passWord"));
        }
        String parm_hear = "";
        HashMap<String,String> pram = new HashMap<>();

        pram.put("appid",appid);
        pram.put("appver",appver);
        pram.put("channel",channel);
        pram.put("clientid",clientid);
        pram.put("lang",lang);
        pram.put("platform",platform);
        pram.put("ver",ver);
        for (Map.Entry<String, String> entry : pram.entrySet()) {
            try {
                parm_hear =parm_hear +"\"" +entry.getKey()+"\""+":"+"\""+entry.getValue()+"\""+",";
            }catch (ClassCastException e){
                parm_hear =parm_hear +"\"" +entry.getKey()+"\""+":"+"\""+String.valueOf(entry.getValue())+"\""+",";            }
        }
        parm_hear = "{"+parm_hear.substring(0,parm_hear.length()-1)+","+"\""+"token"+"\""+":"+"\""+token+"\""+"}";
        String tk = RigiseterUtil.gettk(parm_hear);
        String finalParm = parm_hear.substring(0,parm_hear.length()-1) +",\"tk\":"+"\""+tk+"\""+"}";
        logger.info("请求参数："+finalParm);
        setHeader(request);
        request.form("data",finalParm);
        HttpResponse response = request.send();
        logger.info("返回接口："+ response.bodyText());
        return response.bodyText();
    }
    public static void setHeader(HttpRequest request){
        request.header("Accept-Encoding","Accept-Encoding");
        request.header("Accept-Language","zh-cn");
        request.header("Content-Type","application/x-www-form-urlencoded");
    }
}
