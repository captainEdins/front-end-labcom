package com.example.labcomdemo;


import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.labcomdemo.Adapters.ContactsAdapter;
import com.example.labcomdemo.Adapters.PickUpAdapter;
import com.example.labcomdemo.Models.ContactsModel;
import com.example.labcomdemo.Models.pickUpModel;
import com.example.labcomdemo.retrofit_api_client.Ufs_User_Client;
import com.example.labcomdemo.retrofit_api_interface.Ufs_User_Interface;
import com.example.labcomdemo.retrofit_model.Ufs_User_Model;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CommunicationFragment extends Fragment {

    RecyclerView recyclerView;
    List<ContactsModel> list;
    ContactsAdapter adapter;
    ContactsModel model;
    BottomSheetDialog bottomSheetDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view;

        view = inflater.inflate(R.layout.fragment_communication, container, false);

        recyclerView=view.findViewById(R.id.contactRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(false);

        bottomSheetDialog=new BottomSheetDialog(getContext());
        View layout=LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_layout,container,false);
        bottomSheetDialog.setContentView(layout);

        list=new ArrayList<>();
        //**connecting to the database**//
        Ufs_User_Client ufs_user_client = new Ufs_User_Client();
        Ufs_User_Interface ufs_user_interface = ufs_user_client.getApiClient().create(Ufs_User_Interface.class);


        Call<List<Ufs_User_Model>> called;
        called = ufs_user_interface.getFullList();


        called.enqueue(new Callback<List<Ufs_User_Model>>() {
            @Override
            public void onResponse(Call<List<Ufs_User_Model>> call, Response<List<Ufs_User_Model>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Ufs_User_Model> ufs_user_model = (List<Ufs_User_Model>) response.body();



                for(Ufs_User_Model ufs_user_model1 : ufs_user_model){
                    String setPhone = ufs_user_model1.phone_number;
                    String setMail = ufs_user_model1.email;
                    String setName = ufs_user_model1.full_name;
                    int setGender = ufs_user_model1.gender;



                    model = new ContactsModel(setPhone,setMail,setName,setGender);
                    list.add(model);
                }

                adapter=new ContactsAdapter(list,getContext());
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);


                adapter.setOnItemClickListener(new ContactsAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(CardView cardView, View view, final ContactsModel model, int position) {






                        bottomSheetDialog.show();
                        TextView call=bottomSheetDialog.findViewById(R.id.callEng);
                        TextView email=bottomSheetDialog.findViewById(R.id.emailEng);
                        TextView sms=bottomSheetDialog.findViewById(R.id.smsEng);



                        final TextView contactName = view.findViewById(R.id.contactName);
                        final TextView contactEmail = view.findViewById(R.id.contactEmail);
                        final TextView contactNumber = view.findViewById(R.id.contactNumber);

                        if (call != null){

                            call.setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(getContext(),"calling "+contactNumber.getText(),Toast.LENGTH_LONG).show();
                                    bottomSheetDialog.dismiss();

                                }
                            });


                        }

                        if (email != null){

                            email.setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(getContext(),"You're about to email "+contactEmail.getText(),Toast.LENGTH_LONG).show();
                                    bottomSheetDialog.dismiss();

                                }
                            });


                        }


                        if (sms != null){

                            sms.setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(getContext(),"Sms to "+contactName.getText(),Toast.LENGTH_LONG).show();
                                    bottomSheetDialog.dismiss();

                                }
                            });


                        }




                    }
                });




            }

            @Override
            public void onFailure(Call<List<Ufs_User_Model>> call, Throwable t) {
                Toast.makeText(getContext(),""+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });









        return view;
    }

}
