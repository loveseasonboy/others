package com.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTransformUtils {
//    public static Map<String, Object> getMapByJson(JSONObject jsonObject) {
//        return (Map<String, Object>) jsonObject.keySet();
//    }

    public static void main(String[] args) {
        String string = "{\n" +
                "    \"rtnCode\": \"0\",\n" +
                "    \"rtnMsg\": \"成功!\",\n" +
                "    \"bean\": {},\n" +
                "    \"beans\": [],\n" +
                "    \"object\": {\n" +
                "        \"respCode\": \"0\",\n" +
                "        \"result\": {\n" +
                "            \"discntItems\": [\n" +
                "                {\n" +
                "                    \"discntLeft\": \"50.0\",\n" +
                "                    \"discntType\": \"语音套餐\",\n" +
                "                    \"discntRun\": \"0.0\",\n" +
                "                    \"discntName\": \"4G飞享38元套餐\",\n" +
                "                    \"discntUnit\": \"优惠分钟数（分钟）\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"discntLeft\": \"1572864.0\",\n" +
                "                    \"discntType\": \"移动数据流量套餐\",\n" +
                "                    \"discntRun\": \"0.0\",\n" +
                "                    \"discntName\": \"38元飞享套餐“一套一包”优惠（省内流量）\",\n" +
                "                    \"discntUnit\": \"优惠GPRS流量（KB）\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"discntLeft\": \"307200.0\",\n" +
                "                    \"discntType\": \"移动数据流量套餐\",\n" +
                "                    \"discntRun\": \"0.0\",\n" +
                "                    \"discntName\": \"产品必选优惠-送300M移动数据流量（超出后0.29元/M）(201711月结转)\",\n" +
                "                    \"discntUnit\": \"优惠GPRS流量（KB）\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"discntLeft\": \"307200.0\",\n" +
                "                    \"discntType\": \"移动数据流量套餐\",\n" +
                "                    \"discntRun\": \"0.0\",\n" +
                "                    \"discntName\": \"产品必选优惠-送300M移动数据流量（超出后0.29元/M）\",\n" +
                "                    \"discntUnit\": \"优惠GPRS流量（KB）\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"respDesc\": \"ok\",\n" +
                "        \"resultRows\": \"4\"\n" +
                "    }\n" +
                "}";
        /**
         * 当字符串中没有对应的key时，第一次的值是不会报错的，只会返回是空的，及他的长度为0，当对这个为0的json在操作的
         * 时候就会发生异常
         * JSONArray.toList 转换现在是以下的转换方式。其他的过时了，使用的是递归来实现的。
         */
        JSONObject jsonObject = JSONObject.fromObject(string);
        CommonCsfResult commonCsfResult= (CommonCsfResult) JSONObject.toBean(jsonObject,CommonCsfResult.class);
        System.out.println(commonCsfResult.getObject());
        JSONObject json= JSONObject.fromObject(commonCsfResult.getObject());
//        if (jsonObject.getJSONObject("ss").size() <= 0) {
//            jsonObject.getJSONObject("ss").getJSONObject("we");
//            System.err.println("ssss");
//        }
        JSONObject result = json.getJSONObject("result");//jsonObject.getJSONObject("object").getJSONObject("result");
        if (result.size() > 0) {
            JSONArray discntItems = result.getJSONArray("discntItems");
            List<Map<String, Object>> list = JSONArray.toList(discntItems, new HashMap<>(), new JsonConfig());
            System.out.println(list.get(0).get("discntLeft"));
        }
    }
}
