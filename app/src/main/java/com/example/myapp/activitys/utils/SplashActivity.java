package com.example.myapp.activitys.utils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.model.Daf;
import com.example.model.Profile;
import com.example.myapp.R;
import com.example.myapp.utils.Language;
import com.example.myapp.utils.ManageSharedPreferences;
import com.google.gson.Gson;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    public static String KEYSharedPreferenceIsFirstTime = "KEYSharedPreferenceIsFirstTime";

    public static String KEY_EXTRAProfile = "KEYmyProfile";
    public static String KEY_EXTRA_List1 = "KEY_EXTRA_List1";
    public static String KEY_EXTRA_List2 = "KEY_EXTRA_List2";
    public static String KEY_EXTRA_List3 = "KEY_EXTRA_List3";

    private boolean isFirstTime;
    private Profile mProfile;
    private ArrayList <Daf> mArrayListStudy1;
    private ArrayList <Daf> mArrayListStudy2;
    private ArrayList <Daf> mArrayListStudy3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        isFirstTime();
        setLanguage();

        moveToNextActivity();
        initData();
    }

    private void setLanguage() {
        if (mProfile == null) {
            return;
        }
        Language.setAppLanguage(mProfile.getLanguage(), getBaseContext());
    }


    private void moveToNextActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startNextActivity();
                finish();
            }
        }, 3000);
    }



    private void isFirstTime() {
        mProfile = ManageSharedPreferences.getProfile(getBaseContext());
        if (mProfile != null){
            isFirstTime = false;
        } else {
            isFirstTime = true;
        }
    }


    private void initData() {
        mArrayListStudy1 = ManageSharedPreferences.getArrayList(this);
    }

    private void startNextActivity() {
        if (isFirstTime){
            startActivity(new Intent(SplashActivity.this, ProfileActivity.class));
        }else {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            intent.putExtra(KEY_EXTRAProfile, mProfile);
            intent.putExtra(KEY_EXTRA_List1, mArrayListStudy1);
            intent.putExtra(KEY_EXTRA_List2, mArrayListStudy2);
            intent.putExtra(KEY_EXTRA_List3, mArrayListStudy3);
            startActivity(intent);
        }
    }
}