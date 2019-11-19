package com.example.mywaqiapplicationjava.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface WAQIService {
    String token="bfd8cf670f2835bf31301292cc4b994535d059f9";

    //    https://api.waqi.info/feed/beijing/?token=bfd8cf670f2835bf31301292cc4b994535d059f9
    @GET("/feed/beijing/?token="+token)
    Call<String> getPoll();


//    https://api.waqi.info/feed/geo:31.224361;121.469170/?token=bfd8cf670f2835bf31301292cc4b994535d059f9
    //geobased
    @GET("/feed/geo:{lat};{lang}/?token="+token)
    Call<String> getFeed(@Path("lat") String lat,@Path("lang") String lang);

    //    https://api.waqi.info/feed/Shanghai/?token=bfd8cf670f2835bf31301292cc4b994535d059f9
    //City based
    @GET("/feed/{city}/?token="+token)
    Call<String> getFeed(@Path("city") String city);

//    @Headers("Content-Type: application/json")
//    @POST("/pollutionservice/")
//    Call<String> graphql(@Body String query);

    ///not using
//    https://api.waqi.info/map/bounds/?latlng=39.379436,116.091230,40.235643,116.784382&token=demo
    @GET("/feed/beijing/")
    Call<String> Stationfromsquarebound(@Query("token") String token);

    // https://api.waqi.info/search/?token=bfd8cf670f2835bf31301292cc4b994535d059f9&keyword=India
    @GET("/feed/beijing/")
    Call<String> searchstationbyname(@Query("token") String token);

}
