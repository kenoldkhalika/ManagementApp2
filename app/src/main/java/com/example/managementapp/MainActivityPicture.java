package com.example.managementapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivityPicture extends AppCompatActivity implements View.OnClickListener {

    TextView ViewViewEmployees;
    EditText editTextName, editTextSalary, lname, adress, nextOfKin;

    ImageView backbtn;

    // Button addEmployee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_picture);

        backbtn = findViewById(R.id.backToAD);


        ViewViewEmployees = (TextView) findViewById(R.id.textViewViewEmployees);
        editTextName = (EditText) findViewById(R.id.editTextName);
        lname = findViewById(R.id.editLastTextName);
        nextOfKin = findViewById(R.id.nextofkin);
        adress = findViewById(R.id.adress);
        editTextSalary = (EditText) findViewById(R.id.editTextSalary);
        //  addEmployee = findViewById(R.id.buttonAddEmployee);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityPicture.this, adminduties.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.buttonAddEmployee).setOnClickListener(this);
        ViewViewEmployees.setOnClickListener(this);
        findViewById(R.id.buttonAddEmployee).setOnClickListener(this);
        ///added usiku


    }

    //In this method we will do the create operation

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAddEmployee:
                String empName = editTextName.getText().toString().trim();
                String lnam = lname.getText().toString().trim();
                String adresss = adress.getText().toString().trim();
                String next = nextOfKin.getText().toString().trim();
                //-  double salary = Double.parseDouble(editTextSalary.getText().toString().trim());
                if (empName.equals("")) {
                    Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT).show();
                }
                if (lnam.equals("")) {
                    Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT).show();
                }
                if (adresss.equals("")) {
                    Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT).show();
                }
                if (next.equals("")) {
                    Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Databasee db = new Databasee(this);

                    boolean success = db.addNewEmployee(empName, lnam, adresss, next);
                    if (success) {

                        Toast.makeText(this, "Details saved", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "failed to save", Toast.LENGTH_SHORT).show();

                    }
                }

                break;
            case R.id.textViewViewEmployees:
                startActivity(new Intent(this, listOfEmployees.class));

                break;
        }
    }
}


