package com.xaa.api.goods;

import com.xaa.Module.HttpMoudle;
import com.xaa.Utils.HttpUtilHaha;
import com.xaa.api.Frist.Frist;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Goods {
    private static String evn = "开发环境";

    @Test
    public void test_goods_category() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        HttpMoudle me = yaml.loadAs(new FileInputStream(new File("D:\\javaProject\\test\\src\\main\\resources\\goods_category")), HttpMoudle.class);
        HttpUtilHaha.send(evn,me);

    }
}
