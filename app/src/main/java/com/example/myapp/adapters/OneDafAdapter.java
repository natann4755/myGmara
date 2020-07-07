package com.example.myapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.DafLearning1;
import com.example.myapp.R;

import java.util.ArrayList;

public class OneDafAdapter extends RecyclerView.Adapter<OneDafAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private Context context;
    private ArrayList<DafLearning1> myListDaf = new ArrayList<>();

    public OneDafAdapter(Context context, ArrayList<DafLearning1> myListDaf) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.myListDaf = myListDaf;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_rv_daf, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setHolder(myListDaf.get(position));

    }

    @Override
    public int getItemCount() {
        return myListDaf.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder  {
        CheckBox ifLernning;
        TextView masechet;
        TextView numDaf;
        TextView date;


        ViewHolder(View itemView) {
            super(itemView);
            ifLernning = itemView.findViewById(R.id.one_daf_checkbox);
            masechet = itemView.findViewById(R.id.one_daf_Tv_masechet);
            numDaf = itemView.findViewById(R.id.one_daf_Tv_numPage);
            date = itemView.findViewById((R.id.one_daf_Tv_date));


        }

        public void setHolder(DafLearning1 mydaf) {
            ifLernning.setChecked(false);
            masechet.setText(mydaf.getMasechet());
            numDaf.setText(" "+mydaf.getPageNumber()+ "");
            date.setText("א תמוז תשעט");

        }
    }
}

