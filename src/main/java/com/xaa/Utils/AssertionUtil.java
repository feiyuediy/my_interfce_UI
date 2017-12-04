package com.xaa.Utils;
import com.jayway.jsonpath.JsonPath;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangjianfeng on 2017/1/18.
 */
public class AssertionUtil {

    @Step("检验信息")
    public static void asserContain(String result, String key){
        String resultInfo ="";
        boolean isSecc = true;
        String failString = "";
        if (result.contains(key)){
            resultInfo = result+("检验字符串:  "+result+"   包含("+key+")------->ok");
        }else {
            failString = failString+("检验字符串:  "+result+"   包含("+key+")------->fail");
            isSecc = false;
        }
        wCheckData(resultInfo);
        if (!isSecc){
            wCheckData(failString);
            throw new AssertionError(failString);
        }
    }

    @Step("校验信息")
    public static void assertion(String result, Map<String,Object> expect){
        Set<String> keys = expect.keySet();//获取expect 的键
        String resultInfo ="";
        boolean isSecc = true;
        String failString = "";
        for (String key:keys){
            try{
                String ac = JsonPath.read(result, key).toString();
                if (ac.equals(expect.get(key).toString())){
                    resultInfo = resultInfo +"校验:"+key+"  期望值:"+expect.get(key)+"   实际值:"+ac+"----->ok"+"\n";
                }else {
                    resultInfo = resultInfo +"校验:"+key+"  期望值:"+expect.get(key)+"   实际值:"+ac+"----->fail"+"\n";
                    failString = failString+"校验:"+key+"  期望值:"+expect.get(key)+"   实际值:"+ac+"----->fail"+"\n";
                    isSecc = false;
                }
            }catch (Exception e){
                failString = failString+("找不到这个元素--->"+key+"\n");
                isSecc = false;
            }
        }
        wCheckData(resultInfo);
        if (!isSecc){
            throw new AssertionError(failString);
        }
    }

    @Step("校验信息")
    public static void assertionList(List<String> actList, List<String> expectList){
        String resultInfo = "";
        String falInfo = "";
        boolean result = true;
        for (String expect:expectList){
            if (!actList.contains(expect.replace(" ",""))){
                falInfo = falInfo+("期望值:"+expect+"不存在\n");
                result = false;
            }else {
                resultInfo = resultInfo +("期望值:"+expect+"校验成功\n");
            }
        }
        for (String act:actList){
            if (!expectList.contains(act.replace(" ",""))){
                falInfo = falInfo+("预期值中多了元素:"+act+"\n");
                result = false;
            }
        }
        wCheckData(resultInfo);
        if (!result){
            throw new AssertionError(falInfo);
        }
    }

    /**
     * 在报告中添加校验信息
     */
    @Attachment(value = "校验信息",type = "text/plain")
    private static String wCheckData(String data){
            return data;

    }
}
