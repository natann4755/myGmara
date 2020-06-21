package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    public static String KEYSharedPreferenceIsFirstTime = "KEYSharedPreferenceIsFirstTime";
    public static String KEYisConnected = "KEYisConnected";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        moveToNextActivity();
    }

    private void moveToNextActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isFirstTime();
                finish();
            }
        }, 3000);
    }

    private void isFirstTime() {
        SharedPreferences prefs = getSharedPreferences(KEYSharedPreferenceIsFirstTime, 0);
        boolean isConnected = prefs.getBoolean(KEYisConnected, false);

        if (isConnected) {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        } else {
            startActivity(new Intent(SplashActivity.this, ProfileActivity.class));
        }
    }
}