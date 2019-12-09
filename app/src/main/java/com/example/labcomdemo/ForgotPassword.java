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
import android.widget.ScrollView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForgotPassword extends Fragment {

    /*LAYOUTS*/
    TextView forgot_pass_txt,forgot_pass_txt2,forgot_pass_txt3;
    /*BUTTONS*/
    Button forgot_pass_next_btn,forgot_pass_next_btn2,finish;
    /*SCROLLVIEW*/
    ScrollView enterEmail_scrollview,enterCode_scrollview,enterNewPass_scrollview;


    public ForgotPassword() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgot_password, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navigationCode();
    }
    /*NAVIGATION*/
    public void navigationCode(){

        /*LAYOUT ONE AND BUTTON ONE*/
        forgot_pass_next_btn=getView().findViewById(R.id.forgot_pass_next_btn);
        forgot_pass_next_btn2=getView().findViewById(R.id.forgot_pass_next_btn2);
        finish=getView().findViewById(R.id.finish);

        enterNewPass_scrollview=getView().findViewById(R.id.enterNewPass_scrollview);
        enterCode_scrollview=getView().findViewById(R.id.enterCode_scrollview);
        enterEmail_scrollview=getView().findViewById(R.id.enterEmail_scrollview);

        forgot_pass_txt=getView().findViewById(R.id.forgot_pass_txt1);
        forgot_pass_txt2=getView().findViewById(R.id.forgot_pass_txt2);
        forgot_pass_txt3=getView().findViewById(R.id.forgot_pass_txt3);

        /*GOING FORWARD*/
        forgot_pass_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterEmail_scrollview.setVisibility(View.GONE);
                enterCode_scrollview.setVisibility(View.VISIBLE);

            }
        });
        forgot_pass_next_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterCode_scrollview.setVisibility(View.GONE);
                enterNewPass_scrollview.setVisibility(View.VISIBLE);

            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login fragment=new login();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.loging_container,fragment);
                transaction.commit();

            }
        });


        /*GOING BACK*/
        forgot_pass_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login fragment=new login();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.loging_container,fragment);
                transaction.commit();

            }
        });forgot_pass_txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterEmail_scrollview.setVisibility(View.VISIBLE);
                enterCode_scrollview.setVisibility(View.GONE);

            }
        });forgot_pass_txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterCode_scrollview.setVisibility(View.VISIBLE);
                enterNewPass_scrollview.setVisibility(View.GONE);

            }
        });

    }
}
