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
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {
    /*TEXTVIEW*/
    TextView back_messo;
    /*LAYOUT*/
    ConstraintLayout chats_layout,pick_a_caller;
    /*BUTTON*/
    Button back_btn5;
    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NAVIGATION();
    }
    /*NAVIGATION*/
    private void NAVIGATION() {
        /*LAYOUT*/
        pick_a_caller=getView().findViewById(R.id.pick_a_caller);
        chats_layout=getView().findViewById(R.id.chats_layout);
        /*BUTTON*/
        back_btn5=getView().findViewById(R.id.back_btn5);
        /*TEXTVIEW*/
        back_messo=getView().findViewById(R.id.back_messo);
        back_messo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chats_layout.setVisibility(View.GONE);
                pick_a_caller.setVisibility(View.VISIBLE);
            }
        });
        back_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatRoomFragment fragment=new ChatRoomFragment();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.messo_container,fragment);
                transaction.commit();
            }
        });
    }
}
