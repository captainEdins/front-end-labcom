package com.example.labcomdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationCode();
    }

    /*Navigation*/
    public void NavigationCode(){
        /*Buttons*/
        Button get_started_btn;
        /*Button ids*/
        get_started_btn=findViewById(R.id.get_started_btn);
        get_started_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KidoleOption fragment=new KidoleOption();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,fragment);
                transaction.commit();
            }
        });
    }
}


//    if(b == false){
//
//            //*******//
//            Handler handler = new Handler();
//            handler.postDelayed(new Runnable() {
//public void run() {
////                    paraLabel.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));
//        //  paraLabel.setText("Place your Finger on the Scanner to Proceed");
//        //  paraLabel.setTypeface(paraLabel.getTypeface(), Typeface.BOLD);
//        // icon_kidole.setBackgroundResource(R.drawable.kidole);
//        }
//        }, 500);
//        //*******//
//
////            paraLabel.setTextColor(ContextCompat.getColor(context, R.color.colorRed));
//        // paraLabel.setTypeface(paraLabel.getTypeface(), Typeface.BOLD);
//        // icon_kidole.setBackgroundResource(R.drawable.fingerprint_error);
//        } else {
//        // paraLabel.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));
//        // paraLabel.setTypeface(paraLabel.getTypeface(), Typeface.BOLD);
//        //  icon_kidole.setBackgroundResource(R.drawable.kidole_check);
//        }