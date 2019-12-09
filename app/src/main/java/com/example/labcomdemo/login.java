package com.example.labcomdemo;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.labcomdemo.retrofit_api_client.ServiceGenerator;
import com.example.labcomdemo.retrofit_api_client.Ufs_User_Client;
import com.example.labcomdemo.retrofit_api_interface.Ufs_User_Interface;
import com.example.labcomdemo.retrofit_model.Ufs_Authentication_Model;
import com.example.labcomdemo.retrofit_model.Ufs_Login;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class login extends Fragment {


    public login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navigationCode();
    }
    /*NAVIGATION*/
    public void navigationCode(){
        /*Button*/
        final Button login_btn;
        /*TEXTVIEW*/
        TextView forgot_pass_txt;
        login_btn=getView().findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText login_email_edt= getView().findViewById(R.id.login_email_edt);
                EditText login_pass_edt = getView().findViewById(R.id.login_pass_edt);


                String getMail = login_email_edt.getText().toString();
                String getPass = login_pass_edt.getText().toString();

                Ufs_User_Interface ufs_user_interface = ServiceGenerator.createService(Ufs_User_Interface.class,"devglan-client","devglan-secret");

                Call<Ufs_Authentication_Model> call = ufs_user_interface.getAuth("password",getMail,getPass);

                call.enqueue(new Callback<Ufs_Authentication_Model>() {
                    @Override
                    public void onResponse(Call<Ufs_Authentication_Model> call, Response<Ufs_Authentication_Model> response) {
                        if (response.isSuccessful()) {
                            DashboardActivity fragment = new DashboardActivity();
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.loging_container, fragment);
                            transaction.commit();
                        } else {
                            Toast.makeText(getContext(), "" + response.code(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Ufs_Authentication_Model> call, Throwable t) {
                        Toast.makeText(getContext(),""+t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        forgot_pass_txt=getView().findViewById(R.id.forgot_pass_txt1);
        forgot_pass_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClientFragment fragment=new ClientFragment();

                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.loging_container,fragment);
                transaction.commit();
            }
        });
    }
}
