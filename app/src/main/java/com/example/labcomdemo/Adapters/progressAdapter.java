package com.example.labcomdemo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labcomdemo.Models.progressModel;
import com.example.labcomdemo.R;

import java.util.List;

public class progressAdapter extends RecyclerView.Adapter<progressAdapter.viewholder> {

    Context context;
    List<progressModel>progressModelList;

    public progressAdapter(Context context, List<progressModel> progressModelList) {

        this.context = context;
        this.progressModelList = progressModelList;
    }

    @NonNull
    @Override
    public progressAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view;

       view= LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_design_view,parent,false);

       return  new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull progressAdapter.viewholder holder, int position) {

        progressModel model=progressModelList.get(position);

        holder.client.setText(model.getClientName());
        holder.progress.setText(model.getProgress());

    }

    @Override
    public int getItemCount() {
        return progressModelList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView client,progress;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            client=itemView.findViewById(R.id.textView3);
            progress=itemView.findViewById(R.id.TotalTT);


        }
    }
}
