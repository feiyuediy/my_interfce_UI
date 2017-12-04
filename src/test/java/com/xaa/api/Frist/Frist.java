package com.xaa.api.Frist;

import com.xaa.Module.HttpMoudle;
import com.xaa.Module.Me;
import com.xaa.Utils.HttpUtil;
import com.xaa.Utils.HttpUtilHaha;

import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by admin on 2017/7/8.
 */
public class Frist {
    private static String evn = "开发环境";
    @Test
    public void test_socail_call_inviet() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        HttpMoudle me = yaml.loadAs(new FileInputStream(new File("D:\\javaProject\\test\\src\\main\\resources\\socail_call_inviet")), HttpMoudle.class);
        HttpUtilHaha.send(evn,me);
    }
    @Test
    public void test_social_call_start() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        HttpMoudle me = yaml.loadAs(new FileInputStream(new File("D:\\javaProject\\test\\src\\main\\resources\\social_call_start")), HttpMoudle.class);
        HttpUtilHaha.send(evn,me);
    }

    @Test
    public void test_social_call_end() throws FileNotFoundException {

        Yaml yaml = new Yaml();
        HttpMoudle me = yaml.loadAs(new FileInputStream(new File("D:\\javaProject\\test\\src\\main\\resources\\social_call_end")), HttpMoudle.class);
        HttpUtilHaha.send(evn,me);
    }

    @Test
    public void test_balance() throws FileNotFoundException {

        Yaml yaml = new Yaml();
        HttpMoudle me = yaml.loadAs(new FileInputStream(new File("D:\\javaProject\\test\\src\\main\\resources\\balance")), HttpMoudle.class);
        HttpUtilHaha.send(evn,me);
    }

    @Test
    public void test_mian_gift_list () throws FileNotFoundException {
        Yaml yaml = new Yaml();
        HttpMoudle me = yaml.loadAs(new FileInputStream(new File("D:\\javaProject\\test\\src\\main\\resources\\main_gift_list")), HttpMoudle.class);
        HttpUtilHaha.send(evn,me);
    }
}


//    }

//    @Test
//    public void test_mood_list() throws FileNotFoundException {
//        Yaml yaml = new Yaml();
//        HttpMoudle me = yaml.loadAs(new FileInputStream(new File("D:\\javaProject\\test\\src\\main\\resources\\moode_list")), HttpMoudle.class);
//        HttpUtilHaha.send(me);
//    }
//}
