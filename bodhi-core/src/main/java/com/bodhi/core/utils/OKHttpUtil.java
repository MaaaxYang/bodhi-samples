package com.bodhi.core.utils;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @program: bodhi-samples
 * @description:
 * @author: Maxxx.Yg
 * @create: 2019-02-25 22:41
 **/
public class OKHttpUtil {

    static JavaSerializer serializer = new  JavaSerializer();

    static OkHttpClient okHttpClient = null;
    static MediaType mediaType = MediaType.parse("application/octet-stream; charset=utf-8");
    static {
        // 做成一个配置
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(300,TimeUnit.SECONDS)
                .readTimeout(300,TimeUnit.SECONDS)
                .writeTimeout(300,TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool(10,5L,TimeUnit.MINUTES))
                .build();
    }


    public static byte[] getClassFile(String name) throws IOException {

        Request request = new Request.Builder()
                .url("http://localhost:10000/my/class/"+name)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();

        byte[] bytes = response.body().bytes();

        return bytes;
    }


    public static byte[] getClassMap(String name) throws IOException {

        Request request = new Request.Builder()
                .url("http://localhost:10000/my/class/map/"+name)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();

        byte[] bytes = response.body().bytes();

        return bytes;
    }

}
