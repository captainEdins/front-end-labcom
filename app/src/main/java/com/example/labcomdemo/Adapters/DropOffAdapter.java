package com.example.labcomdemo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labcomdemo.Models.DropOffModel;
import com.example.labcomdemo.Models.pickUpModel;
import com.example.labcomdemo.R;

import java.util.List;

public class DropOffAdapter extends RecyclerView.Adapter<DropOffAdapter.viewholder> {

    List<DropOffModel> modelList;
    Context context;


    public  DropOffAdapter (List<DropOffModel> modelList, Context context) {

        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public DropOffAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.drop_off_layout,parent,false);


        return new DropOffAdapter.viewholder(view);




    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        DropOffModel model=modelList.get(position);

        holder.t1.setText(model.getEngineerName());
        holder.t2.setText(model.getRequestId());
        holder.t3.setText(model.getNumberOfTerminals());
        holder.t4.setText(model.getDeliveryTime());


    }


    @Override
    public int getItemCount() {

        return modelList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView t1,t2,t3,t4;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            t1=itemView.findViewById(R.id.engineerName);
            t2=itemView.findViewById(R.id.RequestId);
            t3=itemView.findViewById(R.id.TerminalNumber);
            t4=itemView.findViewById(R.id.DropTime);




        }
    }




}
