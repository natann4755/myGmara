package com.example.myapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.databinding.FragmentTypeStudyBinding;


public class TypeStudyFragment extends Fragment {
    public static final String TAG = TypeStudyFragment.class.getSimpleName();
    FragmentTypeStudyBinding binding;
    View view;


    public TypeStudyFragment() {

    }


    public static TypeStudyFragment newInstance() {
        TypeStudyFragment fragment = new TypeStudyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTypeStudyBinding.inflate(inflater, container, false);
        openFragment(ViewPagerShewStudy.newInstance(),ViewPagerShewStudy.TAG );
        initViews();
        return binding.getRoot();
    }
    private void initViews() {
        binding.FTPFIRSTSTUDYBUTTON.setOnClickListener(v -> openFragment(ViewPagerShewStudy.newInstance(),ViewPagerShewStudy.TAG ));
        binding.FTPTOWSTUDYBUTTON.setOnClickListener(v -> openFragment(ViewPagerShewStudy.newInstance(),ViewPagerShewStudy.TAG ));
        binding.FTPTHREETSTUDYBUTTON.setOnClickListener(v -> openFragment(ViewPagerShewStudy.newInstance(),ViewPagerShewStudy.TAG ));
    }
    public void openFragment(Fragment myfragment, String tag){

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.FTP_framelayout,myfragment)
                .addToBackStack(tag)
                .commit();

    }
}