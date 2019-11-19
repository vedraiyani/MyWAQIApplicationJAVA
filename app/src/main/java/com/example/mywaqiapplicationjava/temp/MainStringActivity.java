package com.example.mywaqiapplicationjava.temp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mywaqiapplicationjava.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        final GitHubService service = retrofit.create(GitHubService.class);
        Call<String> result = service.listRepos("vvvvvvra");

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
    public interface GitHubService {
        @GET("/users/{user}")
        Call<String> listRepos(@Path("user") String user);
    }
}