package com.example.labcomdemo;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.labcomdemo.Fragments.DashFragment;
import com.example.labcomdemo.Fragments.DeliveryFragment;
import com.example.labcomdemo.Fragments.OrdersFragment;
import com.example.labcomdemo.Fragments.RepairFragment;
import com.google.android.material.navigation.NavigationView;


public class DashboardActivity extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drwl;
    ActionBarDrawerToggle toogle;
    NavigationView navigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {

    View view;
    view =  inflater.inflate(R.layout.fragment_dashboard, container, false);

         toolbar=view.findViewById(R.id.dashToolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true);


        navigationView=view.findViewById(R.id.dashnavView);
        navigationView.setNavigationItemSelectedListener(this);



        drwl=view.findViewById(R.id.dashDrawer);

        toogle=new ActionBarDrawerToggle(getActivity(),drwl,toolbar,R.string.Open,R.string.Close);

        drwl.addDrawerListener(toogle);
        toogle.syncState();

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new DashFragment()).commit();


      /*  BottomNavigationView bottom=view.findViewById(R.id.bottomNav);



        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment selectedFragment = null;

                switch (menuItem.getItemId()){

                    case R.id.repairMenu:

                        selectedFragment=new RepairFragment();


                        break;


                    case R.id.consultationMenu:

                        selectedFragment=new CommunicationFragment();


                        break;

                    case R.id.dashMenu:

                        selectedFragment=new DashFragment() ;


                        break;

                    case R.id.orderMenu:

                        selectedFragment=new OrdersFragment();

                        break;

                    case R.id.deliveryMenu:

                        selectedFragment= new DeliveryFragment();

                        break;



                }

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer,selectedFragment).commit();

                return true;
            }
        });

        if (savedInstanceState == null){

            bottom.setSelectedItemId(R.id.dashMenu);

        }
*/







        return view;
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

       super.onCreateOptionsMenu(menu, inflater);
       // menu.clear();
       inflater.inflate(R.menu.dash_tool_menu,menu);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {




        switch (menuItem.getItemId()){

            case R.id.repairMenu:



                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer,new RepairFragment()).commit();


                break;


            case R.id.consultationMenu:



                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer,new CommunicationFragment()).commit();


                break;

            case R.id.dashMenu:



                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer,new DashFragment()).commit();


                break;

            case R.id.orderMenu:


                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer,new OrdersFragment()).commit();

                break;

            case R.id.deliveryMenu:



                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer,new DeliveryFragment()).commit();

                break;



        }


        drwl.closeDrawer(GravityCompat.START);
        return true;
    }
}
