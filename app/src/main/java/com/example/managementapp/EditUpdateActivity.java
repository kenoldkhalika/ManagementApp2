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

public class EditUpdateActivity extends AppCompatActivity {
    private Button update, delete;
    private EditText editUpdate;
    Databasee myDB;
    private String selectedUpdate;
    private int selectedID;
    ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editupdatelistview);


        back = findViewById(R.id.idnameq);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditUpdateActivity.this, ViewUpdateS.class);
                startActivity(intent);
            }
        });


        update = findViewById(R.id.updateUpdate);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        delete = findViewById(R.id.deleteupdate);
        editUpdate = findViewById(R.id.updateZ);
        myDB = new Databasee(this);
        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id", -1);
        selectedUpdate = receivedIntent.getStringExtra("update");
        editUpdate.setText(selectedUpdate);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String update = editUpdate.getText().toString().trim();
                if (!update.isEmpty()) {
                    myDB.updateUpdate(update, selectedID, selectedUpdate, getApplicationContext());
                } else {
                    Toast.makeText(EditUpdateActivity.this, "put somethig", Toast.LENGTH_LONG).show();
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.deleteUpdate(selectedUpdate, selectedID);
                Toast.makeText(EditUpdateActivity.this, "deleted successfully", Toast.LENGTH_LONG).show();
                editUpdate.setText("");
                Intent editUpdate = new Intent(EditUpdateActivity.this, updatesActivity.class);
                startActivity(editUpdate);

            }
        });

    }
}
