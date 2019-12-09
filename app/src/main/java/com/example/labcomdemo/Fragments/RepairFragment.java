package com.example.labcomdemo.Fragments;


import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.labcomdemo.Adapters.adapterUnrepairable;
import com.example.labcomdemo.Adapters.progressAdapter;
import com.example.labcomdemo.Models.UnrepairableModel;
import com.example.labcomdemo.Models.progressModel;
import com.example.labcomdemo.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class RepairFragment extends Fragment {


    RecyclerView recyclerView,recyclerView1;
    adapterUnrepairable adapter;
    List<UnrepairableModel> unrepairableModelList;
    UnrepairableModel model;

    List<progressModel>progressModelList;
    progressAdapter progressadapter;

    Button add;
    Dialog dialog;



    //String [] agents={"Equity","KWFT","KCB","CO-OP"};
    int [] terminalnumbers ={100, 200 ,500 ,100 };
    int [] terminals ={100, 200 ,500 ,100 };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;

        view=inflater.inflate(R.layout.fragment_repair, container, false);


        BarChart bar=view.findViewById(R.id.barchart);


        List<BarEntry>testingList=new ArrayList<>();

        for (int i=0;  i<terminalnumbers.length; i++){

            testingList.add(new BarEntry(terminalnumbers[i],terminals[i]));

        }

        BarDataSet dataset=new BarDataSet(testingList,"POS perfomance");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData data=new BarData(dataset);
        data.setBarWidth(30.5f);

        bar.setData(data);
        bar.animateX(2000);
        bar.animateY(1000);
        bar.setFitBars(true);
        bar.invalidate();


        dialog=new Dialog(getActivity());
        dialog.setContentView(R.layout.new_unrepairable_terminal);
        dialog.setCanceledOnTouchOutside(false);

        add=view.findViewById(R.id.add_new_btn);


        recyclerView=view.findViewById(R.id.recyclerView3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        recyclerView1=view.findViewById(R.id.recyclerView);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));

        //  recyclerView.scrollToPosition();

        unrepairableModelList=new ArrayList<>();
        progressModelList=new ArrayList<>();

        for (int i=0; i <5; i++){

            progressModelList.add(new progressModel("KCB","150\t/\t500"));

        }


        for (int i=0; i <5; i++){

            model=new UnrepairableModel("Equity","0110181746327","348282228982892");
            unrepairableModelList.add(model);

        }

        progressadapter=new progressAdapter(getContext(),progressModelList);
        progressadapter.notifyDataSetChanged();
        recyclerView1.scrollToPosition(progressModelList.size()-1);
        recyclerView1.setAdapter(progressadapter);




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show();
                Button dialogsave=dialog.findViewById(R.id.dialogsavebtn);
                final EditText bnknm=dialog.findViewById(R.id.dialogBankName);
                final   EditText serial=dialog.findViewById(R.id.dialogSerialNo);
                final   EditText part=dialog.findViewById(R.id.dialogPartNo);


                dialogsave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (bnknm.getText().toString().trim().isEmpty() || serial.getText().toString().trim().isEmpty() || part.getText().toString().trim().isEmpty()  ){

                            Toast.makeText(getContext(),"Cant save null values",Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                            return;
                        }

                        UnrepairableModel  model1=new UnrepairableModel(bnknm.getText().toString(),serial.getText().toString(),part.getText().toString());
                        unrepairableModelList.add(model1);

                        bnknm.getText().clear();
                        serial.getText().clear();
                        part.getText().clear();

                        unrepairableModelList.add(model);


                        Toast.makeText(getContext(),"Saved",Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });



            }
        });

        adapter=new adapterUnrepairable(unrepairableModelList,getContext());
        adapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(unrepairableModelList.size()-1);
        recyclerView.setAdapter(adapter);







        return view;
    }




}
