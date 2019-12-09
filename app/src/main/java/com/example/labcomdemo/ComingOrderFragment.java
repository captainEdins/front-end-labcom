package com.example.labcomdemo;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class ComingOrderFragment extends Fragment {
/*TEXTVIEW*/
    TextView pick_up_btn,drop_off_btn,drop_off_btn2,pick_up_btn2,dashboard4;
    /*LAYOUT*/
    ConstraintLayout recycle_layout_pickups,recycle_layout_dropoffs;

    public ComingOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coming_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NAVIGATION();
    }

    /*NAVIGATION*/
    private void NAVIGATION() {
        /*LAYOUTS*/
        recycle_layout_pickups=getView().findViewById(R.id.recycle_layout_pickups);
        recycle_layout_dropoffs=getView().findViewById(R.id.recycle_layout_dropoffs);
        /*TEXTVIEW*/
        pick_up_btn=getView().findViewById(R.id.pick_up_btn);
        drop_off_btn=getView().findViewById(R.id.drop_off_btn);
        drop_off_btn2=getView().findViewById(R.id.drop_off_btn2);
        pick_up_btn2=getView().findViewById(R.id.pick_up_btn2);
        dashboard4=getView().findViewById(R.id.dashboard4);

        /*ONCLICK*/
        drop_off_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recycle_layout_pickups.setVisibility(View.GONE);
                drop_off_btn.setVisibility(View.GONE);
                pick_up_btn.setVisibility(View.GONE);
                recycle_layout_dropoffs.setVisibility(View.VISIBLE);
                drop_off_btn2.setVisibility(View.VISIBLE);
                pick_up_btn2.setVisibility(View.VISIBLE);

            }
        });
        pick_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recycle_layout_pickups.setVisibility(View.VISIBLE);
                drop_off_btn.setVisibility(View.VISIBLE);
                pick_up_btn.setVisibility(View.VISIBLE);
                recycle_layout_dropoffs.setVisibility(View.GONE);
                drop_off_btn2.setVisibility(View.GONE);
                pick_up_btn2.setVisibility(View.GONE);
            }
        });
        pick_up_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recycle_layout_pickups.setVisibility(View.VISIBLE);
                drop_off_btn.setVisibility(View.VISIBLE);
                pick_up_btn.setVisibility(View.VISIBLE);
                recycle_layout_dropoffs.setVisibility(View.GONE);
                drop_off_btn2.setVisibility(View.GONE);
                pick_up_btn2.setVisibility(View.GONE);
            }
        });
        dashboard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DashboardActivity fragment=new DashboardActivity();
                FragmentTransaction transaction= Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.order_container,fragment);
                transaction.commit();
            }
        });
    }
}
