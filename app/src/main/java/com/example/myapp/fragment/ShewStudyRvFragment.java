package com.example.myapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.model.Daf;
import com.example.myapp.R;
import com.example.myapp.activity.SplashActivity;
import com.example.myapp.adapters.OneDafAdapter;
import com.example.myapp.databinding.FragmentShewStudyRvBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShewStudyRvFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShewStudyRvFragment extends Fragment {
    FragmentShewStudyRvBinding binding;
    ArrayList<Daf> myList1 = new ArrayList<>();


    public ShewStudyRvFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ShewStudyRvFragment newInstance(ArrayList<Daf>myList1) {
        ShewStudyRvFragment fragment = new ShewStudyRvFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(SplashActivity.KEY_EXTRA_List1,myList1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            myList1 = getArguments().getParcelableArrayList(SplashActivity.KEY_EXTRA_List1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentShewStudyRvBinding.inflate(inflater, container, false);
        initReciclerview();
        return binding.getRoot();
    }

    private void initReciclerview() {
        RecyclerView recyclerView = binding.showStudyRV;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        OneDafAdapter myAdapter = new OneDafAdapter(getContext(),myList1);
        recyclerView.setAdapter(myAdapter);
    }
}