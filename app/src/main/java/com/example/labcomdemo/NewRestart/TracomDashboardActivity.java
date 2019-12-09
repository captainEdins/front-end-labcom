package com.example.labcomdemo.NewRestart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;

import com.example.labcomdemo.R;

public class TracomDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracom_dashboard);




        Toolbar toolbar=findViewById(R.id.dashToolbar);
        setSupportActionBar(toolbar);






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.dash_tool_menu,menu);

        return true;

    }
}
