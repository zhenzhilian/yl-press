package com.Common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonToMap {
    public static void main(String args[]) {
//        String jsonstrWork="{\n" +
//                "  \"cti\": \"0\",\n" +
//                "  \"nodeParams\": [\n" +
//                "    {\n" +
//                "      \"id\": \"1HED6PrgFdlHmvrumkSLL9\",\n" +
//                "      \"params\": {\n" +
//                "        \"dt\": \"1.3\"\n" +
//                "      }\n" +
//                "    }\n" +
//                "  ],\n" +
//                "  \"workflowId\": \"0yVH-N1iRdRaX1lvnO6R1I\"\n" +
//                "}";
//        //字符串转map
//        JSONObject jsonObject = JSONObject.parseObject(jsonstrWork);
//        Map<String,Object> map = (Map<String,Object>)jsonObject;//    //json对象转Map
//        for (Map.Entry<String,Object> entry : map.entrySet()) {
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//            if (entry.getKey().equals("nodeParams")) {
//                List<Object> nodeObject=JSONObject.parseArray(entry.getValue().toString());
//                Map<String,Object> mapNode = (Map<String,Object>)nodeObject.get(0);
//                for (Map.Entry<String,Object> entryNode : mapNode.entrySet()) {
//                    System.out.println("Key = " + entryNode.getKey() + ", Value = " + entryNode.getValue());
//                    if (entryNode.getKey().equals("params")) {
//                        JSONObject params = JSONObject.parseObject(entryNode.getValue().toString());
//                        Map<String,Object> dtMap = (Map<String,Object>)params;
//                        if(dtMap.containsKey("dt")){
//                            dtMap.put("dt",System.currentTimeMillis());}
//                    }
//                }
//            }
//        }
//        //map转字符串
//        String jsonString = JSON.toJSONString(map)；
    }


}
