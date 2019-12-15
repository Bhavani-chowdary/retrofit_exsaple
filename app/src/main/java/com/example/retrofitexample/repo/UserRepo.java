package com.example.retrofitexample.repo;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.retrofitexample.model.UserDetails;
import com.example.retrofitexample.model.UserDetailsModel2;
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

    public void getUserDetails2(String user){

      ApiInterface apiInterface =  ApiClient.getRetrofit2().create(ApiInterface.class);
      Call<ArrayList<UserDetailsModel2>> arrayListCall = apiInterface.getUsrDetails(user);

      arrayListCall.enqueue(new Callback<ArrayList<UserDetailsModel2>>() {
          @Override
          public void onResponse(Call<ArrayList<UserDetailsModel2>> call, Response<ArrayList<UserDetailsModel2>> response) {
              Log.i("APPDATA",""+call.request().url());
              if (response.isSuccessful()){

                  ArrayList<UserDetailsModel2> userDetailsModel2sLIst = response.body();
                  Log.i("ARRAYLIST",userDetailsModel2sLIst.get(1).getName());

              }
          }

          @Override
          public void onFailure(Call<ArrayList<UserDetailsModel2>> call, Throwable t) {

          }
      });

    }
}
