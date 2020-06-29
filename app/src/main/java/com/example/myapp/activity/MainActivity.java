package com.example.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.myapp.R;
import com.example.myapp.fragment.TypeStudyFragment;
import com.example.myapp.fragment.ViewPagerShewStudy;


public class MainActivity extends AppCompatActivity implements ViewPagerShewStudy.OnFragmentInteractionListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openFragment(TypeStudyFragment.newInstance(), TypeStudyFragment.TAG);


    }
    public void openFragment(Fragment myFragment, String tag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.MA_frameLayout, myFragment)
                .addToBackStack(tag)
                .commit();
    }


}