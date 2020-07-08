package com.example.myapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.shas_masechtot_list_models.SederItem;
import com.example.myapp.R;
import com.example.myapp.interfaces.CreateTypeOfStudy;

import java.util.List;

public class RecyclerViewStudyOptionsMasechetAdapter extends RecyclerView.Adapter<RecyclerViewStudyOptionsMasechetAdapter.Holder> {

    private List <SederItem> mSederItems;
    private CreateTypeOfStudy mListener;
    private Context mContext;

    public RecyclerViewStudyOptionsMasechetAdapter(List<SederItem> mSederItems, Context context) {
        this.mSederItems = mSederItems;
        mContext = context;
        this.mListener = (CreateTypeOfStudy) context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_study_options, parent, false);
        return new RecyclerViewStudyOptionsMasechetAdapter.Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
           holder.setHolder(mSederItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mSederItems.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView study;
        private SederItem sederItem;
        private RecyclerView mItemRecyclerView;
        private RecyclerViewStudyOptionsMasechetAdapter mRecyclerViewStudyOptionsTalmudAdapter;
        private LinearLayout mRvLinearLayout;

        public Holder(@NonNull View itemView) {
            super(itemView);
            study = itemView.findViewById(R.id.item_rv_study_TV);
            mItemRecyclerView = itemView.findViewById(R.id.item_rv_RV);
            mRvLinearLayout  = itemView.findViewById(R.id.item_rv_study_rv_LL);
        }

        public void setHolder (SederItem sederItem){
            this.sederItem = sederItem;
            study.setText(sederItem.getName());
        }

    }
}
