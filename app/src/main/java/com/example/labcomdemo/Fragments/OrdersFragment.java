package com.example.labcomdemo.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.labcomdemo.Adapters.OrderpickupsAdapater;
import com.example.labcomdemo.Adapters.PickUpAdapter;
import com.example.labcomdemo.Models.pickUpModel;
import com.example.labcomdemo.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class OrdersFragment extends Fragment {

 /*   TabLayout tbl;
    ViewPager viewPager;
*/
    RecyclerView recyclerView;
    List<pickUpModel> list;
    PickUpAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view;
         view=inflater.inflate(R.layout.fragment_orders, container, false);


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







       /*  tbl=view.findViewById(R.id.tablayout);
         viewPager=view.findViewById(R.id.viewPage);

        OrderpickupsAdapater adapater=new OrderpickupsAdapater(getFragmentManager());

        adapater.addFragment(new pickupsFragment(),"Pickups");
        adapater.addFragment(new dropOffFragment(),"DropOff");

        viewPager.setAdapter(adapater);
        tbl.setupWithViewPager(viewPager);
*/





     return view;

    }

}
