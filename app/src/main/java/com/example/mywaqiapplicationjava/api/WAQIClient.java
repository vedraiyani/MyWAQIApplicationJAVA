package com.example.mywaqiapplicationjava.api;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class WAQIClient {
    private static WAQIService service;
    public WAQIClient(){

    }
    private static synchronized void initWAQIService(){
        if(service==null){
            service = new Retrofit.Builder()
                    .baseUrl("https://api.waqi.info/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build()
                    .create(WAQIService.class);
        }

    }
    public static WAQIService getClient(){
        if(service==null){
                service = new Retrofit.Builder()
                        .baseUrl("https://api.waqi.info/")
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .build()
                        .create(WAQIService.class);
        }
        return service;
    }
}
