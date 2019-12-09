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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class PendingandCompleteFragment extends Fragment {
    /*TEXTVIEW*/
    TextView delivery_icon,order_icon,repairs_icon,pending_btn,complete_btn,dashboard4;
    /*LAYOUT*/
    ConstraintLayout icon_layout,recycle_layout_complete_delivery,recycle_layout_complete_orders,recylce_layout_complete_repairs;
    /*FLOATINGACTIONBUTTON*/
    FloatingActionButton repair_fab,delivery_fab,order_fab;

    public PendingandCompleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pendingand_complete, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NAVIGATION();
    }

    /*NAVIGATION*/
    private void NAVIGATION() {
        /*TEXTVIEW*/
        delivery_icon=getView().findViewById(R.id.delivery_icon);
        order_icon=getView().findViewById(R.id.order_icon);
        repairs_icon=getView().findViewById(R.id.repairs_icon);
        pending_btn=getView().findViewById(R.id.pending_btn);
        complete_btn=getView().findViewById(R.id.complete_btn);
        dashboard4=getView().findViewById(R.id.dashboard4);

        /*LAYOUTS*/
        icon_layout=getView().findViewById(R.id.icon_layout);
        recycle_layout_complete_delivery=getView().findViewById(R.id.recycle_layout_complete_delivery);
        recycle_layout_complete_orders=getView().findViewById(R.id.recycle_layout_complete_orders);
        recylce_layout_complete_repairs=getView().findViewById(R.id.recylce_layout_complete_repairs);

        /*FLOATINGACTIONBUTTON*/
        repair_fab=getView().findViewById(R.id.repair_fab);
        delivery_fab=getView().findViewById(R.id.delivery_fab);
        order_fab=getView().findViewById(R.id.order_fab);

        /*ONCLICKS*/
        delivery_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icon_layout.setVisibility(View.GONE);
                recycle_layout_complete_delivery.setVisibility(View.VISIBLE);
            }
        });
        delivery_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icon_layout.setVisibility(View.VISIBLE);
                recycle_layout_complete_delivery.setVisibility(View.GONE);
            }
        });
        order_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icon_layout.setVisibility(View.GONE);
                recycle_layout_complete_orders.setVisibility(View.VISIBLE);
            }
        });
        order_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icon_layout.setVisibility(View.VISIBLE);
                recycle_layout_complete_orders.setVisibility(View.GONE);
            }
        });
        repairs_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icon_layout.setVisibility(View.GONE);
                recylce_layout_complete_repairs.setVisibility(View.VISIBLE);
            }
        });
        repair_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icon_layout.setVisibility(View.VISIBLE);
                recylce_layout_complete_repairs.setVisibility(View.GONE);
            }
        });
        complete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PendingCompleteFragment fragment=new PendingCompleteFragment();
                FragmentTransaction transaction= Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container,fragment);
                transaction.commit();
            }
        });
   /*     dashboard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DashboardActivity fragment=new DashboardActivity();
                FragmentTransaction transaction= Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.dashboard_container,fragment);
                transaction.commit();
            }
        });*/

    }
}
