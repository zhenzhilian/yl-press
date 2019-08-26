package com.Controller;

import com.Common.HttpClientUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TestController {
    @Autowired
    private HttpClientUtil httpClientUtil;

    @ResponseBody
    @RequestMapping("/start")
    public String start(){
        String str="{\"cti\":\"0\",\"nodeParams\":[{\"id\":\"1HED6PrgFdlHmvrumkSLL9\",\"params\":{\"dt\":\"1.3\"}}],\"workflowId\":\"0yVH-N1iRdRaX1lvnO6R1I\"}";
        //System.out.println(str);
        String tmp="{\"dt\":"+System.currentTimeMillis()+"}";
        String jsonstrWork=str.replace("{\"dt\":\"1.3\"}",tmp);
        //System.out.println(jsonstrWork);
        String workProcessUrl="http://172.16.35.13:8080/dispatch-server/executive/execute";
        String resultWork=httpClientUtil.doPostJson(workProcessUrl,jsonstrWork);
        return resultWork;
    }
}
