package com.example.retrofitexample.repo;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.retrofitexample.model.UserDetails;
import com.example.retrofitexample.url.ApiClient;
import com.example.retrofitexample.url.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepo {

    Context context;
    public UserRepo(Activity activity) {
        context = activity;
    }
    public void getUSerDetails(String token) {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<ArrayList<UserDetails>> call = apiInterface.getUser(token);
        call.enqueue(new Callback<ArrayList<UserDetails>>() {
            @Override
            public void onResponse(Call<ArrayList<UserDetails>> call, Response<ArrayList<UserDetails>> response) {
                if (response.isSuccessful()) {

                    ArrayList<UserDetails> arrayList = response.body();

                    for (int i=0;i<arrayList.size();i++){
                        Log.d("APPDATA",arrayList.get(i).getName());
                    }

                }
            }

            @Override
            public void onFailure(Call<ArrayList<UserDetails>> call, Throwable t) {

            }
        });


    }
}
