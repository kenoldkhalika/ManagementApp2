package com.example.managementapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class VacancyActivities extends AppCompatActivity implements View.OnClickListener {
    EditText vacancy;
    Button addVacancy, viewvacancy;
    Databasee myDB;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacancy_activities);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        vacancy = findViewById(R.id.writevacancy);
        addVacancy = findViewById(R.id.addVacaciess);
        viewvacancy = findViewById(R.id.ViewVacacies);
        findViewById(R.id.ViewVacacies).setOnClickListener(this);
        findViewById(R.id.addVacaciess).setOnClickListener(this);
        vacancy.setOnClickListener(this);

        back = findViewById(R.id.backtoad);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VacancyActivities.this, adminduties.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addVacaciess:
                String empName = vacancy.getText().toString().trim();
                if (empName.equals("")) {
                    Toast.makeText(VacancyActivities.this, "Please enter vacancy ", Toast.LENGTH_SHORT).show();

                } else {

                    Databasee db = new Databasee(this);


                    boolean success = db.addVacancy(empName);
                    if (success) {

                        Toast.makeText(this, "Details saved", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "failed to save", Toast.LENGTH_SHORT).show();

                    }
                }
                break;
            case R.id.ViewVacacies:
//                Intent intent = new Intent(VacancyActivities.this, ViewVacancies.class);
//                startActivity(intent);
                startActivity(new Intent(this, ViewVacancies.class));

                break;
        }
    }
}
