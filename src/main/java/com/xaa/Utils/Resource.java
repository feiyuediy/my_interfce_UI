package com.xaa.Utils;

import java.io.*;
import java.net.URL;

public class Resource {
    public String getResource(String filename)  {
        //返回读取指定资源的输入流
        try{
            InputStream is=this.getClass().getResourceAsStream("/data.json");
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String data = "";
            String s = "";
            while((s = br.readLine())!=null)
                data=data + s;
            return data;
        }catch (Exception exception){
            return new File("/resources/"+filename).getPath();
        }

    }
    public static void main(String args[]){
        new Resource().getResource("dd");
    }

}
