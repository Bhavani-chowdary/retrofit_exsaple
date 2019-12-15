package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.retrofitexample.repo.UserRepo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserRepo userRepo = new UserRepo(this);
       // userRepo.getUSerDetails("fhq74");
        userRepo.getUserDetails2("user");
    }
}
