package com.xaa.Utils;

import com.sun.org.apache.regexp.internal.RE;
import com.xaa.Frame.LoginPage;

public class LoginApi {
    private String token;

    public LoginApi(String evn,String username,String pwd){
         this.token = RigiseterUtil.getToken(evn,username,pwd);
    }

    public String getToken(){
        return token;
    }

}
