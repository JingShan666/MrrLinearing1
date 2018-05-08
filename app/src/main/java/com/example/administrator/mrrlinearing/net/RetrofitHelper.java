package com.example.administrator.mrrlinearing.net;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/5/8.
 */

public class RetrofitHelper {

    OkHttpClient httpClient= new OkHttpClient();
    GsonConverterFactory factory= GsonConverterFactory.create(new GsonBuilder().create());
    private static Retrofit mRetrofit = null;

    private RetrofitHelper(){
        init();
    }
    private static RetrofitHelper inStance= null;

    public static RetrofitHelper getIntance(){
        if (inStance == null){
            inStance = new RetrofitHelper();

        }
        return inStance;

    }

    private void init() {
        reStartApp();

    }

    private void reStartApp() {
        mRetrofit= new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .client(httpClient)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


    }

    public  RetrofitService getRetrofitService(){

        return mRetrofit.create(RetrofitService.class);

    }


}
