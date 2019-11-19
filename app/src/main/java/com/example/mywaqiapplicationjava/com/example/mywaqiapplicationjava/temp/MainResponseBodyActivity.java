package com.example.mywaqiapplicationjava.com.example.mywaqiapplicationjava.temp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mywaqiapplicationjava.R;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainResponseBodyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
//                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final GitHubService service = retrofit.create(GitHubService.class);
        Call<ResponseBody> result = service.listRepos("vvvvvvra");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String str = service.listRepos("vvvvvvra").execute().body().toString();
                    System.out.println(">>>>>>>>"+str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        result.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    System.out.println(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }
    public interface GitHubService {
        @GET("/users/{user}")
        Call<ResponseBody> listRepos(@Path("user") String user);
    }
}