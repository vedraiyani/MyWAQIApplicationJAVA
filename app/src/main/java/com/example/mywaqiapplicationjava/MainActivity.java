package com.example.mywaqiapplicationjava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.mywaqiapplicationjava.api.WAQIClient;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://mypds.herokuapp.com/pollutionservice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        ApolloClient apolloClient = ApolloClient.builder()
                .serverUrl(BASE_URL)
                .okHttpClient(okHttpClient)
                .build();
        WAQIPollutionByCityQuery q= WAQIPollutionByCityQuery.builder().city("beijing").build();
        apolloClient.query(q).enqueue(new ApolloCall.Callback<WAQIPollutionByCityQuery.Data>() {
            @Override
            public void onResponse(@NotNull Response<WAQIPollutionByCityQuery.Data> response) {
                Log.i(">>>>>>>>>>>>>>","aya");
            }

            @Override
            public void onFailure(@NotNull ApolloException e) {

            }
        });

//        Call<String> result = WAQIClient.getClient().getFeed("Beijing");
//
//        result.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                Log.i("WAQIService CityBased",response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });

//        WAQIClient.getClient().getFeed("31.224361", "121.469170")
//                .enqueue(new Callback<String>() {
//                    @Override
//                    public void onResponse(Call<String> call, Response<String> response) {
//                        Log.i("WAQIService GeoBased", response.body().toString());
//                    }
//
//                    @Override
//                    public void onFailure(Call<String> call, Throwable t) {
//                        t.printStackTrace();
//                    }
//                });
    }

}