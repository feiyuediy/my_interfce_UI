package com.xaa.Utils;


import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangjianfeng on 2017/1/18.
 */
public class HttpUtil {
    private static String baseurl = "http://192.168.1.51/api/v2";

    public static void main(String args[]) {
        String url = "/idphoto/lists";
        String parm = "{\"tags\":\"\",\"limit\":\"15\",\"platform\":\"2\",\"last_photo_publish_score\":\"\",\"appid\":\"1\",\"ver\":\"1.0\",\"tk\":\"92f60ea5ac8bb0dd80274f35a69d3154\",\"lang\":\"zh\",\"appver\":\"60\",\"last_photo_publish_time\":\"\",\"clientid\":\"407e2af3-4216-3307-9b47-cca8c410caa7\",\"token\":\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOnsiY2xpZW50SWQiOiI0MDdlMmFmMy00MjE2LTMzMDctOWI0Ny1jY2E4YzQxMGNhYTciLCJ1c2VySWQiOiIzMjUifSwiaXVhIjoxNTAyMDY5OTAxfQ.DvZHu1j5qN2bC6TdRDgR7qKF2YUvW1JLFIp_j8s6f9U\",\"page\":\"0\",\"channel\":\"unknow\"}";
        send(url, parm);
    }

    @Step("请求接口")
    public static String send(String url, String parm) {
//        File file = new File("src/main/resources/basedata.json");
//        try{
//            url = JsonPath.read(file, "$.baseurl") + url;
//        }catch (Exception e){
//            e.getStackTrace();
//        }
        url =baseurl+url;
        wRequestUrl(url);
        wRequestData(parm);
        System.out.println("请求参数---->" + parm);
        System.out.println("请求URL---->" + url);
        HttpRequest request = HttpRequest.post(url);
        setHeader(request);
        if (parm!=null){
            request.form("data",parm);
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        HttpResponse response = request.send();
        System.out.println(response.body());
        String result = response.bodyText();
        wRequestResult(result);
        System.out.println("返回结果---->" + result);
        return result;
    }

    @Step("请求接口")
    @Parameters("baseurl")
    public static String send(String url) {
//        File file = new File("src/main/resources/basedata.json");
//        try{
//            url = JsonPath.read(file, "$.baseurl") + url;
//        }catch (Exception e){
//            e.getStackTrace();
//        }
        url = baseurl+url;
        wRequestUrl(url);
        System.out.println("请求URL---->" + url);
        HttpRequest request = HttpRequest.post(url);
        setHeader(request);
        HttpResponse response = request.send();
        String result = response.bodyText();
        wRequestResult(result);
        System.out.println("返回结果---->" + result);
        return result;
    }


    public static HttpRequest setHeader(HttpRequest request) {
        request.header("Accept-Encoding", "zip");
        request.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        return request;
    }

    /**
     * 在报告中添加请求地址
     */
    @Attachment(value = "请求地址",type = "text/plain")
    private static String wRequestUrl(String url){
        return url;
    }

    /**
     * 在报告中添加请求参数
     */
    @Attachment(value = "请求参数",type = "application/json")
    private static String wRequestData(String data){
        if(null == data || data.length()<0){
            return "该接口无请求参数";
        }
        return data;
    }
    /**
     * 在报告中添加返回数据
     */
    @Attachment(value = "返回结果",type = "application/json")
    private static String wRequestResult(String result){
        return result;
    }
}
