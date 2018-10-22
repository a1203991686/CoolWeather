package com.example.a1203.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author littlecorgi
 * @Date 2018-10-20 15:38
 * @email a1203991686@126.com
 */
public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        // 创建一个OKHttp对象
        OkHttpClient client = new OkHttpClient();
        // 发起一条HTTP请求
        Request request = new Request.Builder().url(address).build();
        // 调用newCall方法创建一个新的Call对象，并调用他的execute方法来发送请求并获取服务器返回的数据
        client.newCall(request).enqueue(callback);
    }
}
