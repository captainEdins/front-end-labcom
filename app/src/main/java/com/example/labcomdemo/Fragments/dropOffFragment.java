package com.example.labcomdemo.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.labcomdemo.Adapters.DropOffAdapter;
import com.example.labcomdemo.Adapters.PickUpAdapter;
import com.example.labcomdemo.Models.DropOffModel;
import com.example.labcomdemo.Models.pickUpModel;
import com.example.labcomdemo.R;

import java.util.ArrayList;
import java.util.List;


public class dropOffFragment extends Fragment {

    RecyclerView recyclerView;
    List<DropOffModel>list;
    DropOffAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view;

        view=inflater.inflate(R.layout.fragment_drop_off, container, false);


        RecyclerView recyclerView;
        List<DropOffModel>list;
        DropOffAdapter adapter;

        recyclerView=view.findViewById(R.id.dropOffRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(false);


        list=new ArrayList<>();

        for (int i=0; i< 50; i++){

            DropOffModel model=new DropOffModel("12345678","Engineer Ephantus","500","12:00 PM");

            list.add(model);


        }

        adapter=new DropOffAdapter(list,getContext());
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);



        return view;
    }

}
