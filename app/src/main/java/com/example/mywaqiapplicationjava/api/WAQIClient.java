package com.example.mywaqiapplicationjava.api;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class WAQIClient {
    private static WAQIService service;
    public WAQIClient(){

    }
    private static synchronized void initWAQIService(){
        if(service==null){
            service = new Retrofit.Builder()//"https://api.waqi.info/"
                    .baseUrl("https://api.waqi.info/")//https://mypds.herokuapp.com/pollutionservice
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build()
                    .create(WAQIService.class);
        }

    }
    public static WAQIService getClient(){
        if(service==null){
                initWAQIService();
        }
        return service;
    }
}
