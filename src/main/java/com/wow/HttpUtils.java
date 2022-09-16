package com.wow;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by arthur.hw on 2020/6/25.
 */
//@Slf4j
public class HttpUtils {

    /**
     * httpGet
     *
     * @param url
     * @param paramsMap
     * @param headerMap
     * @throws IOException
     */
    public void callGet(String url, Map<String, String> paramsMap, Map<String, String> headerMap) throws IOException {
        HttpResponse response;
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            URI uri = null;
            try {
                // 将参数放入键值对类NameValuePair中,再放入集合中
                List<NameValuePair> params = new ArrayList<>();
                paramsMap.keySet().stream().forEach(key -> {
                    params.add(new BasicNameValuePair(key, paramsMap.get(key)));
                });

                uri = new URIBuilder().setPath(url).setParameters(params).build();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }

            HttpGet httpGet = new HttpGet(uri);
            httpGet.setHeader("Content-Type", "application/json;charset=utf8");
            headerMap.keySet().stream().forEach(key -> {
                httpGet.addHeader(key, headerMap.get(key));
            });
            response = client.execute(httpGet);

            EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception ex) {
            System.out.println(">>>HttpUtils|callGet|Error" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            client.close();
        }
    }

    /**
     *
     * @param url
     * @param paramsMap
     * @param headerMap
     * @throws IOException
     */
    public void callPostWithJsonData(String url, Map<String, String> paramsMap, Map<String, String> headerMap)
        throws IOException {
        HttpResponse response;
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            URI uri = null;
            try {
                // 将参数放入键值对类NameValuePair中,再放入集合中
                List<NameValuePair> params = new ArrayList<>();
                paramsMap.keySet().stream().forEach(key -> {
                    params.add(new BasicNameValuePair(key, paramsMap.get(key)));
                });

                uri = new URIBuilder().setPath(url).setParameters(params).build();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }

            HttpPost httpPost = new HttpPost(uri);
            httpPost.setHeader("Content-Type", "application/json;charset=utf8");
            response = client.execute(httpPost);

            EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception ex) {
            System.out.println(">>>TestcaseServiceImpl|executeHttp|Error" + ex.getMessage());
        } finally {
            client.close();
        }
    }

    /**
     *
     *
     * @param url
     * @param formData
     * @param headerMap
     */
    public void callPostWithFormData(String url, Map<String, String> formData, Map<String, String> headerMap)
        throws IOException {
        HttpResponse response;
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();

            HttpEntity httpEntity = multipartEntityBuilder.build();

            HttpPost httpPost = new HttpPost();
            httpPost.setEntity(httpEntity);

            // header
            headerMap.keySet().stream().forEach(key -> {
                httpPost.addHeader(key, headerMap.get(key));
            });
            response = client.execute(httpPost);

            EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception ex) {
            System.out.println(">>>TestcaseServiceImpl|executeHttp|Error" + ex.getMessage());
        } finally {
            client.close();
        }
    }


    public static void main(String[] args){
        System.out.println(21399 % 100);
    }
}
