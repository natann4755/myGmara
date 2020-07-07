package com.example.myapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.StudyOption;
import com.example.model.shas_masechtot_list_models.AllShasItem;
import com.example.myapp.R;
import com.example.myapp.interfaces.CreateTypeOfStudy;

import java.util.ArrayList;

public class RecyclerViewStudyOptionsAdapter extends RecyclerView.Adapter<RecyclerViewStudyOptionsAdapter.Holder> {

    private Context mContext;
    private ArrayList<StudyOption> mStudyOptions = new ArrayList<>();
    private AllShasItem mAllShasItem;
    private RecyclerView.Adapter mAdapter;
    private CreateTypeOfStudy mListener;

    public RecyclerViewStudyOptionsAdapter (Context mContext, ArrayList<StudyOption> studyOptions, AllShasItem mAllShasItem) {
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
        private StudyOption studyOptions;
        private RecyclerView mItemRecyclerView;
        private RecyclerViewStudyOptionsTalmudAdapter mRecyclerViewStudyOptionsTalmudAdapter;
        private LinearLayout mRvLinearLayout;

        public Holder(@NonNull View itemView) {
            super(itemView);
            study = itemView.findViewById(R.id.item_rv_study_TV);
            mItemRecyclerView = itemView.findViewById(R.id.item_rv_RV);
            mRvLinearLayout  = itemView.findViewById(R.id.item_rv_study_rv_LL);

            itemView.setOnClickListener(v -> {
                if (studyOptions.getNameStudyOption().equals(mStudyOptions.get(0).getNameStudyOption())){
                    mListener.CreateListTypeOfStudy(mStudyOptions.get(0).getNameStudyOption());
                }
                if (studyOptions.getNameStudyOption().equals(mStudyOptions.get(1).getNameStudyOption())){
                    if (studyOptions.isOpen()) {
                        studyOptions.setOpen(false);
                        mRvLinearLayout.setVisibility(View.GONE);
                    }else {
                        studyOptions.setOpen(true);
                        mItemRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                        mRvLinearLayout.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

        public void setTextHolder (StudyOption studyOptions){
            this.studyOptions = studyOptions;
            study.setText(studyOptions.getNameStudyOption());
        }
    }
}
