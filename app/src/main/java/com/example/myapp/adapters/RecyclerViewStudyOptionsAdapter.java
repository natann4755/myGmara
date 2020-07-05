package com.example.myapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.shas_masechtot_list_models.AllShasItem;
import com.example.myapp.R;
import com.example.myapp.interfaces.CreateTypeOfStudy;

import java.util.ArrayList;

public class RecyclerViewStudyOptionsAdapter extends RecyclerView.Adapter<RecyclerViewStudyOptionsAdapter.Holder> {

    private Context mContext;
    private ArrayList<String> mStudyOptions = new ArrayList<>();
    private AllShasItem mAllShasItem;
    private RecyclerView.Adapter mAdapter;
    private CreateTypeOfStudy mListener;

    public RecyclerViewStudyOptionsAdapter (Context mContext, ArrayList<String> studyOptions, AllShasItem mAllShasItem) {
        this.mContext = mContext;
        this.mStudyOptions = studyOptions;
        this.mAllShasItem = mAllShasItem;
        this.mListener = (CreateTypeOfStudy) mContext;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_study_options, parent, false);
        return new RecyclerViewStudyOptionsAdapter.Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.setTextHolder(mStudyOptions.get(position));
    }

    @Override
    public int getItemCount() {
        return mStudyOptions.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        private TextView study;
        private String studyOptions;

        public Holder(@NonNull View itemView) {
            super(itemView);
            study = itemView.findViewById(R.id.item_rv_study_TV);

            itemView.setOnClickListener(v -> {
                if (studyOptions.equals(mStudyOptions.get(0))){
                    mListener.CreateListTypeOfStudy(mStudyOptions.get(0));
                }
            });
        }

        public void setTextHolder (String studyOptions){
            this.studyOptions = studyOptions;
            study.setText(studyOptions);
        }
    }
}
