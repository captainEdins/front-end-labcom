package com.example.labcomdemo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labcomdemo.Models.DropOffModel;
import com.example.labcomdemo.Models.pickUpModel;
import com.example.labcomdemo.R;

import java.util.List;

public class PickUpAdapter extends RecyclerView.Adapter<PickUpAdapter.viewholder> {

    List<pickUpModel>modelList;
    Context context;

    private OnItemClickListener mOnItemClickListener;


    public PickUpAdapter(List<pickUpModel> modelList, Context context) {

        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public PickUpAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pick_up_layout,parent,false);


        return new viewholder(view);


    }

    public interface OnItemClickListener {
        void onItemClick(ImageButton imagebutton , View view,   pickUpModel model, int position);
    }

    public  void setOnItemClickListener(final OnItemClickListener mItemClickListener) {

        this.mOnItemClickListener = mItemClickListener;
    }





    @Override
    public void onBindViewHolder(@NonNull final PickUpAdapter.viewholder holder, final int position) {

        final pickUpModel model=modelList.get(position);

        holder.t1.setText(model.getClientName());
        holder.t2.setText(model.getRequestId());

        holder.t3.setText(model.getNumberOfTerminal());
        holder.t4.setText(model.getPickUpTime());

        holder.t5.setText(model.getLocation());

        holder.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(holder.b1,view,model,position);
                }

            }
        });



    }

    @Override
    public int getItemCount() {

        return modelList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView t1,t2,t3,t4,t5;
        ImageButton b1,b2;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            t1=itemView.findViewById(R.id.ClientName);
            t2=itemView.findViewById(R.id.RequestId);

            t3=itemView.findViewById(R.id.TerminalNumber);
            t4=itemView.findViewById(R.id.PickTime);

            t5=itemView.findViewById(R.id.PickLocation);

            b1=itemView.findViewById(R.id.acceptBtn);
            b2=itemView.findViewById(R.id.declineBtn);



        }
    }
}
