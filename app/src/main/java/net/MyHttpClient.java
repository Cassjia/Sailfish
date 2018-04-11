package net;

import okhttp3.OkHttpClient;

/**
 * Created by Castiel on 2018/3/19.
 */

public class MyHttpClient {
    private static volatile OkHttpClient okHttpClient;

    private MyHttpClient() {
    }

    public static OkHttpClient getInstance() {
        if (okHttpClient == null) {
            synchronized (MyHttpClient.class) {
                if (okHttpClient == null) {
//                    okHttpClient = new OkHttpClient();

//                    okHttpClient = new OkHttpClient.Builder()
//                            .addInterceptor(new LoggingInterceptor())
//                            .build();

                    okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(new LoggingInterceptor()).addInterceptor(new LoggingInterceptor())
                            .build();
                }
            }
        }
        return okHttpClient;
    }



    ;
}
