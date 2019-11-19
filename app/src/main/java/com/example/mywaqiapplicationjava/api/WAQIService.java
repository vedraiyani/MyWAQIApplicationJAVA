package com.example.mywaqiapplicationjava.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//    https://api.waqi.info/feed/beijing/?token=bfd8cf670f2835bf31301292cc4b994535d059f9
public interface WAQIService {
    @GET("/feed/beijing/")
    Call<String> getPoll(@Query("token") String token);
}
