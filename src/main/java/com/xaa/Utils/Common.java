package com.xaa.Utils;

import com.jayway.jsonpath.JsonPath;
import com.sun.org.apache.regexp.internal.RE;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by admin on 2017/7/18.
 */
public class Common {
    public static void main(String args[]){

        File file = new File(String.valueOf(new Resource().getResource("data.json")));
        try {
            System.out.println(JsonPath.read(file,"$.RequstHeardInfo").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String md5(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }

        StringBuffer hexString = new StringBuffer();

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] hash = md.digest();

            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
        } catch (NoSuchAlgorithmException e) {

        }

        return hexString.toString();
    }
    //获取配置文件中的url
    public static String getUrl(String env){
        String add ;
        switch (env){
            case "预发布环境": add = "http://gama.aifuns.com";break;
            case "测试环境": add = "http://192.168.1.51";break;
            case "开发环境": add = "http://192.168.1.50";break;
            case "正式环境": add = "";break;
            default: add = "";
        }
        return add;

    }

    //获取配置文件中的requstHeard信息
    public static String getRequstHeard(String key){
        String data = new Resource().getResource("data");
        return JsonPath.read(data,String.format("$.RequstHeardInfo.%s", key));
    }

    //获取用户名和密码
    public static String getUserInfo(String key){
        String data = new Resource().getResource("data");

        return JsonPath.read(data,String.format("$.userInfo.%s", key));
    }

    public static String getDbSetting(String key){
        String data = new Resource().getResource("data");

        return JsonPath.read(data,String.format("$.DB.data.%s", key));

    }

    public static String getResultDbStting(String key){
        String data = new Resource().getResource("data");
        return JsonPath.read(data,String.format("$.DB.result.%s", key));

    }
    //获取发送邮件信息
    public static String getMailSetting(String key){
        String data = new Resource().getResource("data");
        return JsonPath.read(data,String.format("$.Mail.%s", key));

    }
}
