package com.example.managementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class adminduties extends AppCompatActivity {
    Button btn2, btn, btn3, bnm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminduties);
        //added
        getSupportActionBar().setTitle("ADMIN");


        //added

        btn2 = (Button) findViewById(R.id.managemployeeebtn);

        btn = (Button) findViewById(R.id.vacncybtncg);
        bnm = (Button) findViewById(R.id.adminnnlogimn);

        bnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminduties.this, updatesActivity.class);
                //
                startActivity(intent);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminduties.this, VacancyActivities.class);
                startActivity(intent);
            }
        });


        btn3 = (Button) findViewById(R.id.jobschedulingtbtn);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminduties.this, JobActivity.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminduties.this, MainActivityPicture.class);
                startActivity(intent);
            }
        });


    }
}