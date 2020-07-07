package com.example.myapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.interfaces.CreateTypeOfStudy;

import java.util.ArrayList;

public class RecyclerViewStudyOptionsTalmudAdapter extends RecyclerView.Adapter<RecyclerViewStudyOptionsTalmudAdapter.Holder> {

    private ArrayList <Object> mLocationUsers;
    private CreateTypeOfStudy mListener;
    private Context mContext;

    public RecyclerViewStudyOptionsTalmudAdapter(ArrayList<Object> mLocationUsers, Context context) {
        this.mLocationUsers = mLocationUsers;
        mContext = context;
        this.mListener = (CreateTypeOfStudy) context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Holder extends RecyclerView.ViewHolder {

        public Holder(@NonNull View itemView) {
            super(itemView);
        }
    }





}
