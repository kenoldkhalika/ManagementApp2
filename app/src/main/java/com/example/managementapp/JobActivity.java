package com.example.managementapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class JobActivity extends AppCompatActivity {
    Button sbmt, view;
    EditText name, job, marks;
    Databasee myDB;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        name = findViewById(R.id.namE);
        job = findViewById(R.id.personJob);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        back = findViewById(R.id.backToadminAcvity);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobActivity.this, adminduties.class);
                startActivity(intent);
            }
        });

//
//     marks=(EditText) findViewById(R.id.editTextTextPersonN) ;
        sbmt = findViewById(R.id.addJob);
        view = findViewById(R.id.viewJob);
        myDB = new Databasee(this);
////
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobActivity.this, ViewListOfJobActivity.class);
                startActivity(intent);
            }
        });


        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = job.getText().toString();
                String item2 = name.getText().toString();
                if (item.equals("") || item2.equals(""))
                    Toast.makeText(JobActivity.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean insert = myDB.addjob(item, item2);
                    if (insert) {
                        Toast.makeText(JobActivity.this, "Successfully added", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(JobActivity.this, "Registration failed", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

    }

    public void addData(String entry, String entry1) {
        boolean insertData = myDB.addjob(entry, entry1);
        if (insertData == true) {
            Toast.makeText(JobActivity.this, "Successfully entered", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(JobActivity.this, "something went wrong", Toast.LENGTH_LONG).show();
        }
    }


}

