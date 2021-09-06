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

public class EditJobActivity extends AppCompatActivity {
    private Button update, delete;
    private EditText editName;
    private EditText editJob;
    ImageView back;
    Databasee myDB;
    private String selectedName;
    private String selectedJob;
    private int selectedID;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editjoblistview);
        update = findViewById(R.id.updateJob);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        delete = findViewById(R.id.deleteJob);
        back = findViewById(R.id.goToJobActivity);
        editName = findViewById(R.id.nameU);
        editJob = findViewById(R.id.jobU);
        myDB = new Databasee(this);
        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id", -1);
        selectedName = receivedIntent.getStringExtra("name");
        selectedJob = receivedIntent.getStringExtra("job");
        editName.setText(selectedName);
        editJob.setText(selectedJob);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditJobActivity.this, ViewListOfJobActivity.class);
                startActivity(intent);

            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString().trim();
                String job = editJob.getText().toString().trim();
                if (!name.isEmpty() && !job.isEmpty()) {
                    myDB.updateJob(name, job, selectedID);
                } else {
                    Toast.makeText(EditJobActivity.this, "put somethig", Toast.LENGTH_LONG).show();
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.deleteJob(selectedID);
                Toast.makeText(EditJobActivity.this, "deleted successfully", Toast.LENGTH_LONG).show();
                editName.setText("");
                editJob.setText("");
                Intent editUpdate = new Intent(EditJobActivity.this, updatesActivity.class);
                startActivity(editUpdate);

            }
        });


    }
}