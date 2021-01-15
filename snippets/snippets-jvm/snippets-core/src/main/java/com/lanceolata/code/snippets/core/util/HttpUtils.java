package com.lanceolata.code.snippets.core.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * HTTP工具类
 */
public class HttpUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * 默认HTTP请求配置
     */
    public static final RequestConfig DEFAULT_REQUEST_CONFIG = RequestConfig
            .custom()
            .setSocketTimeout(3000)
            .setConnectTimeout(3000)
            .setConnectionRequestTimeout(3000)
            .build();

    /**
     * HTTP get请求
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String get(String url) throws IOException {
        HttpGet get = new HttpGet(url);
        get.setConfig(DEFAULT_REQUEST_CONFIG);
        return execute(get);
    }

    /**
     * HTTP post请求
     *
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public static String post(String url, List<NameValuePair> params) throws IOException {
        HttpPost post = buildHttpPost(url, params);
        post.setConfig(DEFAULT_REQUEST_CONFIG);
        return execute(post);
    }

    /**
     * 构造POST请求
     *
     * @param url 请求url
     * @param params 请求参数
     *
     * @return
     * @throws IOException
     */
    private static HttpPost buildHttpPost(String url, List<NameValuePair> params) throws UnsupportedEncodingException {
        HttpPost post = new HttpPost(url);
        post.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));
        return post;
    }

    /**
     * 发送HTTP请求
     *
     * @param request
     * @return
     * @throws Exception
     */
    private static String execute(HttpUriRequest request) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpEntity entity = httpClient.execute(request).getEntity();
            return EntityUtils.toString(entity, StandardCharsets.UTF_8);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                LOGGER.error("error occured while close httpClient ", e);
            }
        }
    }
}
