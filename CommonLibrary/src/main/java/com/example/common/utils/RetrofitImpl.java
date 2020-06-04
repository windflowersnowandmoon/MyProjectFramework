package com.example.common.utils;

import android.content.Context;

import retrofit2.Retrofit;

public class RetrofitImpl {

    public static final String BASE_URL = "";

    //读超时时常，单位：毫秒
    public static final int READ_TIME_OUT = 15 * 1000;

    //写超时时常，单位：毫秒
    public static final int WRITE_TIME_OUT = 15 * 1000;

    //链接超时时常，单位：毫秒
    public static final int CONNECT_TIME_OUT = 15 * 1000;

    private volatile static Retrofit retrofit;

    //单利
    public static Retrofit getRetrofit(Context context){
        if (retrofit == null){
            synchronized (RetrofitImpl.class){

            }
        }
        return retrofit;
    }
}
