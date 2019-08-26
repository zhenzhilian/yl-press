package com.TestJemeter;


import com.Common.HttpClientUtil;
import org.apache.http.client.ClientProtocolException;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class TestClient extends AbstractJavaSamplerClient {
    @Autowired
    private HttpClientUtil httpClientUtil;
    private static String uriPOST = "http://localhost:8080/hello";

    @Override
    public Arguments getDefaultParameters() {
        Arguments arguments = new Arguments();
        arguments.addArgument("val", "");
        return arguments;
    }
    @Override
    public SampleResult runTest(JavaSamplerContext arg0) {
        // 添加事务 new SampleResult
        SampleResult result = new SampleResult();
        result.sampleStart();
        String value = arg0.getParameter("val");
        try {
//            int responseCode = SendHttpRequest.sendPostRequest(value);
//            if (responseCode == 200) {
//                result.setSuccessful(true);
//            } else {
//                result.setSuccessful(false);
//            }
            String responseCode=httpClientUtil.doPostJson("","");
            if (responseCode.indexOf("200")>1) {
                result.setSuccessful(true);
            } else {
                result.setSuccessful(false);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        result.sampleEnd();
        return result;
    }

    public static void main(String[] args) {
        new TestClient().runTest(new JavaSamplerContext(new Arguments()));
        System.out.println("this is test");
    }
}
