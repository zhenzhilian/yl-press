package com.TestJemeter;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendHttpRequest {
    private static String uriPOST = "http://localhost:8080/hello";

    public static int sendPostRequest(String value) throws ClientProtocolException, IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(uriPOST);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("name", value));
        params.add(new BasicNameValuePair("introduced", "2017-2-19"));
        params.add(new BasicNameValuePair("discontinued", "2017-2-19"));
        params.add(new BasicNameValuePair("company", "22"));
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        long startTime = System.currentTimeMillis();
        CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
        int responseCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println(responseCode + " ," + (System.currentTimeMillis() - startTime) + "ms");
        return responseCode;
    }
}
