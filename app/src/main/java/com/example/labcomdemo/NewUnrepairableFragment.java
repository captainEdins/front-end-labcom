 package com.example.labcomdemo;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.labcomdemo.Fragments.RepairFragment;

import java.util.Objects;


 /**
 * A simple {@link Fragment} subclass.
 */
public class NewUnrepairableFragment extends Fragment {

    /*BUTTON*/
    Button add,cancel;

    public NewUnrepairableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_unrepairable, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navigaTION();
    }
    public void navigaTION(){
        cancel=getView().findViewById(R.id.cancel);
        add=getView().findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RepairFragment fragment=new RepairFragment();
                FragmentTransaction transaction= Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.repair_contain,fragment);
                transaction.commit();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RepairFragment fragment=new RepairFragment();
                FragmentTransaction transaction= Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.repair_contain,fragment);
                transaction.commit();
            }
        });
    }
}
