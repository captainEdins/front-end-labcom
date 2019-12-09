package com.example.labcomdemo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labcomdemo.Models.UnrepairableModel;
import com.example.labcomdemo.R;

import java.util.List;

public class adapterUnrepairable extends RecyclerView.Adapter<adapterUnrepairable.viewholder>{

    List<UnrepairableModel> unrepairableModelList;
    Context context;

    public adapterUnrepairable(List<UnrepairableModel> unrepairableModelList, Context context) {

        this.unrepairableModelList = unrepairableModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public adapterUnrepairable.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.unrepairable_design_view,parent,false);

        return new viewholder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull adapterUnrepairable.viewholder holder, int position) {

        UnrepairableModel posit=unrepairableModelList.get(position);

        holder.bankName.setText(posit.getBankName());
        holder.serialNo.setText(posit.getSerialNumber());
        holder.partNo.setText(posit.getPartNumber());


    }

    @Override
    public int getItemCount() {
        return unrepairableModelList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{

        TextView bankName,serialNo,partNo;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            bankName=itemView.findViewById(R.id.textView15);
            serialNo=itemView.findViewById(R.id.textView16);
            partNo=itemView.findViewById(R.id.textView18);

        }
    }
}
