package com.example.retrofitexample.url;

import com.example.retrofitexample.model.UserDetails;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("bins/{token}")
    Call<ArrayList<UserDetails>> getUser(@Path("token") String token);

}
