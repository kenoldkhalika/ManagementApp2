package com.example.managementapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class updatesActivity extends AppCompatActivity implements View.OnClickListener {
    EditText updates;
    Button addUpdates, viewUpdates;
    Databasee myDB;
    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updates);
        updates = findViewById(R.id.writeUpdates);
        addUpdates = findViewById(R.id.addUpdatess);
        viewUpdates = findViewById(R.id.ViewUpdatess);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        findViewById(R.id.ViewUpdatess).setOnClickListener(this);
        findViewById(R.id.addUpdatess).setOnClickListener(this);
        updates.setOnClickListener(this);
        back = findViewById(R.id.sasa);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(updatesActivity.this, adminduties.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addUpdatess:
                String updtes = updates.getText().toString().trim();

                if (updtes.equals("")) {
                    Toast.makeText(updatesActivity.this, "Please enter update ", Toast.LENGTH_SHORT).show();

                } else {
                    Databasee db = new Databasee(this);
                    boolean success = db.addUpdates(updtes);
                    if (success) {

                        Toast.makeText(this, "Details saved", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "failed to save", Toast.LENGTH_SHORT).show();

                    }
                }
                break;
            case R.id.ViewUpdatess:
                Intent intent = new Intent(updatesActivity.this, ViewUpdateS.class);
                startActivity(intent);
                //  startActivity(new Intent(this, ViewUpdateS.class));

                break;
        }
    }
}
