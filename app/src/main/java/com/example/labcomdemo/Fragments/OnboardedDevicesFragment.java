package com.example.labcomdemo.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.labcomdemo.R;

public class OnboardedDevicesFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;


        view = inflater.inflate(R.layout.fragment_onboarded_devices, container, false);





        return view;
    }

}
