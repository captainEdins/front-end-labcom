package com.example.labcomdemo;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
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
public class ChatRoomFragment extends Fragment {
    /*TEXTVIEW*/
    TextView chatroom_back, make_call2, messo_btn;
    /*BUTTON*/
    Button send_btn, back_btn4, yap, nope;
    /*LAYOUT*/
    ConstraintLayout pick_layput, main_layout, confirm_layout, pick_a_caller;
    /*cardView*/
    CardView cardView;

    public ChatRoomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat_room, container, false);
    }

}

