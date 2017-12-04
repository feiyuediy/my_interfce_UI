package com.xaa.api.Gift;

import com.xaa.Module.HttpMoudle;
import com.xaa.Utils.HttpUtilHaha;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Gift {
    private static String evn = "开发环境";
    @Test
    public void test_main_gift_list() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        HttpMoudle me = yaml.loadAs(new FileInputStream(new File("D:\\javaProject\\test\\src\\main\\resources\\main_gift_list")), HttpMoudle.class);
        HttpUtilHaha.send(evn,me);
    }

    @Test
    public void test_new_present_order() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        HttpMoudle me = yaml.loadAs(new FileInputStream(new File("D:\\javaProject\\test\\src\\main\\resources\\new_present_order")), HttpMoudle.class);
        HttpUtilHaha.send(evn,me);
    }

    @Test
    public void test_1(){
        String value = "\\u666e\\u901a\\u793c\\u7269";

        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }

        System.out.println(sbu.toString());
    }
}
