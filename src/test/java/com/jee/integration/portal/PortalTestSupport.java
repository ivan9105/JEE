package com.jee.integration.portal;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Иван on 18.02.2017.
 */
public class PortalTestSupport {
    protected String doGet(String url) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader
                (new InputStreamReader(
                        response.getEntity().getContent()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    protected String doPost(String url, Map<String, String> paramsMap) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<>();
        for (String key : paramsMap.keySet()) {
            params.add(new BasicNameValuePair(key, paramsMap.get(key)));
        }
        request.setEntity(new UrlEncodedFormEntity(params));
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }
}
