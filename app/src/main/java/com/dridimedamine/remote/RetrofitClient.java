package com.dridimedamine.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class RetrofitClient {

    private static Retrofit retrofit = null;
    public static Retrofit getClient(String url){
        if(retrofit == null){
            Gson gson = new GsonBuilder()
                            .setLenient()
                            .create();

           // OkHttpClient client = new OkHttpClient();

            retrofit = new Retrofit.Builder()
                                    .baseUrl(url)
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();
        }
        return retrofit;
    }
}
