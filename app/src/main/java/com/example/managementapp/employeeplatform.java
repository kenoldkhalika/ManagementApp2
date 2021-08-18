package com.example.managementapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class employeeplatform extends AppCompatActivity {
TextView btn2;
TextView tx,text,report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employeeplatform);
      //  btn2 = (TextView) findViewById(R.id.jobView);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(employeeplatform.this, ViewUpdateS.class);
//                startActivity(intent);
//            }
//        });
        tx = (TextView) findViewById(R.id.jobView);
        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(employeeplatform.this, ViewListOfJobActivity.class);
                startActivity(intent);
            }
        });
       // text = (TextView) findViewById(R.id.jobView);
//        text.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(employeeplatform.this, ViewVacancies.class);
//                startActivity(intent);
//            }
//        });
//   report = (TextView) findViewById(R.id.reportbtn);
//       report.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(employeeplatform.this, reportforabsence.class);
//                startActivity(intent);
//            }
//        });
    }
}