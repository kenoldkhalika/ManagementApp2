package com.example.managementapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class EditVacancyActivity extends AppCompatActivity {
    private Button update, delete;
    private EditText editVacancy;
    ImageView back;
    Databasee myDB;
    private String selectedUpdate;
    private int selectedID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editvacancylistview);

        back = findViewById(R.id.g);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditVacancyActivity.this, ViewVacancies.class);
                startActivity(intent);
            }
        });


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        update = findViewById(R.id.updateVacancy);
        delete = findViewById(R.id.deleteVacancy);
        editVacancy = findViewById(R.id.vacancyZ);
        myDB = new Databasee(this);
        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id", -1);
        selectedUpdate = receivedIntent.getStringExtra("update");
        editVacancy.setText(selectedUpdate);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vacancy = editVacancy.getText().toString().trim();
                if (!vacancy.isEmpty()) {
                    myDB.updateVacancy(vacancy, selectedID, selectedUpdate, getApplicationContext());
                } else {
                    Toast.makeText(EditVacancyActivity.this, "put somethig", Toast.LENGTH_LONG).show();
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.deleteVacancy(selectedUpdate, selectedID);
                Toast.makeText(EditVacancyActivity.this, "deleted successfully", Toast.LENGTH_LONG).show();
                editVacancy.setText("");
//                Intent editUpdate=new Intent(EditVacancyActivity.this, updatesActivity.class);
//                startActivity(editUpdate);

            }
        });

    }
}
