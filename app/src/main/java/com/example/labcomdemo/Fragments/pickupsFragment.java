package com.example.labcomdemo.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.labcomdemo.Adapters.PickUpAdapter;
import com.example.labcomdemo.Models.pickUpModel;
import com.example.labcomdemo.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class pickupsFragment extends Fragment {

    RecyclerView recyclerView;
    List<pickUpModel>list;
    PickUpAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view;


        view=inflater.inflate(R.layout.fragment_pickups, container, false);

        recyclerView=view.findViewById(R.id.pickUpRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(false);


        list=new ArrayList<>();

        for (int i=0; i<5; i++){

            pickUpModel model= new pickUpModel("123456789","Equity Bank","450","Karen","12:00 hrs");

            list.add(model);

        }

        adapter=new PickUpAdapter(list,getContext());
        recyclerView.setAdapter(adapter);


    adapter.setOnItemClickListener(new PickUpAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(ImageButton imagebutton, View view, pickUpModel model, int position) {

                Toast.makeText(getContext(), "Accepted", Toast.LENGTH_SHORT).show();
                list.remove(list.size()-1);

                adapter.notifyDataSetChanged();

                Toast.makeText(getContext(), ""+list.size(), Toast.LENGTH_SHORT).show();



            }
        });

        return view;
    }



}
