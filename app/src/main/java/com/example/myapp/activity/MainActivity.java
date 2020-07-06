package com.example.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.model.Daf;
import com.example.myapp.R;
import com.example.myapp.fragment.TypeStudyFragment;
import com.example.myapp.fragment.ViewPagerShewStudyFragment;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements ViewPagerShewStudyFragment.OnFragmentInteractionListener {

    ArrayList<Daf> myList1;
//    ArrayList<Daf>  myList2 = new ArrayList<>();
//    ArrayList<Daf>  myList3 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList1 = getIntent().getParcelableArrayListExtra(SplashActivity.KEY_EXTRA_List1);
        openFragment(TypeStudyFragment.newInstance(myList1), TypeStudyFragment.TAG);


    }
    public void openFragment(Fragment myFragment, String tag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.MA_frameLayout, myFragment)
                .addToBackStack(tag)
                .commit();
    }


}