package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.example.e_commerce.LoginSignUp.Welcome;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SystemClock.sleep( 3000);
        Intent loginIntent = new Intent(Splash.this, Welcome.class);
        startActivity(loginIntent);
        finish();


    }
}