package com.example.mywaqiapplicationjava.com.example.mywaqiapplicationjava.temp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mywaqiapplicationjava.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MainWAQIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.waqi.info/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();


        final WAQIService service = retrofit.create(WAQIService.class);
        Call<String> result = service.getPoll("bfd8cf670f2835bf31301292cc4b994535d059f9");

        result.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println(response.body().toString());

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }
    //    https://api.waqi.info/feed/beijing/?token=bfd8cf670f2835bf31301292cc4b994535d059f9
    public interface WAQIService {
        @GET("/feed/beijing/")
        Call<String> getPoll(@Query("token") String token);
    }
}