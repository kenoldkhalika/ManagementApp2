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

    TextView textViewViewEmployees;
    EditText editTextName, editTextSalary;
    Spinner spinnerDepartment;
    String department;
    ImageView backbtn;
   // Button addEmployee;
    String empName;
    SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_picture);

        backbtn=findViewById(R.id.backToAD);

        textViewViewEmployees = (TextView) findViewById(R.id.textViewViewEmployees);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextSalary = (EditText) findViewById(R.id.editTextSalary);
        spinnerDepartment = (Spinner) findViewById(R.id.spinnerDepartment);
      //  addEmployee = findViewById(R.id.buttonAddEmployee);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivityPicture.this , adminduties.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.buttonAddEmployee).setOnClickListener(this);
        textViewViewEmployees.setOnClickListener(this);
        findViewById(R.id.buttonAddEmployee).setOnClickListener(this);
        ///added usiku




        List<String> dep = new ArrayList<>();
        dep.add("Marketing");
        dep.add("Finance");
        dep.add("ICT");
        dep.add("Support");

        spinnerDepartment.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, dep));
        spinnerDepartment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String  depart = (String)parent.getSelectedItem();
                department = depart;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //creating a database
    }
        //this method will validate the name and salary
    //dept does not need validation as it is a spinner and it cannot be empty
    private boolean inputsAreCorrect(String name, String salary) {
        if (name.isEmpty()) {
            editTextName.setError("Please enter a name");
            editTextName.requestFocus();
            return false;
        }

        if (salary.isEmpty() || Integer.parseInt(salary) <= 0) {
            editTextSalary.setError("Please enter salary");
            editTextSalary.requestFocus();
            return false;
        }
        return true;
    }

    //In this method we will do the create operation

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAddEmployee:
                String empName = editTextName.getText().toString().trim();
                double salary = Double.parseDouble(editTextSalary.getText().toString().trim());

                Databasee db = new Databasee(this);


               boolean success =  db.insertEmpData(empName, department, salary);
                if (success) {

                    Toast.makeText(this, "Details saved", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "failed to save", Toast.LENGTH_SHORT).show();

                }

                break;
            case R.id.textViewViewEmployees:

             // startActivity(new Intent(this, ShowEmployees.class));

                break;
        }
    }
}


