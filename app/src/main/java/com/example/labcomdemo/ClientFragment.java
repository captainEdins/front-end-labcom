package com.example.labcomdemo;


import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ClientFragment extends Fragment {

    Toolbar toolbar;
    DrawerLayout drwl;
    ActionBarDrawerToggle toogle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view;
        view=LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_client, container, false);

        toolbar=view.findViewById(R.id.clientToolbar);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Dashboard");

        drwl=view.findViewById(R.id.drawer);

        toogle=new ActionBarDrawerToggle(getActivity(),drwl,toolbar,R.string.Open,R.string.Close);

        drwl.addDrawerListener(toogle);
        toogle.syncState();



        return view;
    }

}
