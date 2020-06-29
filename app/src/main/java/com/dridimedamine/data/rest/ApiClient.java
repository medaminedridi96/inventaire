package com.dridimedamine.data.rest;

import com.dridimedamine.global.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit mRetrofit;
    private static ApiInterface mInstance = null;

    public static ApiInterface getClient() {
        if (mInstance == null) {
            setUpWebClient();
        }
        return mInstance;
    }

    private static void setUpWebClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .addInterceptor(logging)
                .readTimeout(Constants.Durations.READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .connectTimeout(Constants.Durations.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mInstance = mRetrofit.create(ApiInterface.class);
    }

    private static String getBaseUrl() {
        return "http://b73bca09204f.ngrok.io/api/";
    }

}
