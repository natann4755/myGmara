package com.example.myapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.adapters.ViewPagerDataLearningAdapter;
import com.example.myapp.databinding.FragmentViewPagerShewStudyBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewPagerShewStudy#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewPagerShewStudy extends Fragment {

    public static final String TAG = ViewPagerShewStudy.class.getSimpleName();
    FragmentViewPagerShewStudyBinding binding;

    private ViewPager myViewpajer;
    private ViewPagerDataLearningAdapter viewPagerDataLearningAdapter;
    private ArrayList<Fragment> myListDataLernen = new ArrayList<>();
    private OnFragmentInteractionListener mListener;

    public ViewPagerShewStudy() {

    }


    public static ViewPagerShewStudy newInstance() {
        ViewPagerShewStudy fragment = new ViewPagerShewStudy();
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
        binding = FragmentViewPagerShewStudyBinding.inflate(inflater, container, false);
        initMyViewPager();
        return binding.getRoot();
    }

    private void initMyViewPager() {
        myViewpajer = binding.FFSViewpager;
        viewPagerDataLearningAdapter = new ViewPagerDataLearningAdapter(getActivity().getSupportFragmentManager(),initMyListStudy(),getContext());
        myViewpajer.setAdapter(viewPagerDataLearningAdapter);
        TabLayout tabLayout = binding.FFSTabLayout;
//        tabLayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        tabLayout.setupWithViewPager(myViewpajer, true);
    }
    private ArrayList<Fragment> initMyListStudy() {
        myListDataLernen.add(ShewStudyRvFragment.newInstance());
        myListDataLernen.add(ShewStudyRvFragment.newInstance());
        myListDataLernen.add(ShewStudyRvFragment.newInstance());
        return myListDataLernen;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }




    public interface OnFragmentInteractionListener {

    }
}