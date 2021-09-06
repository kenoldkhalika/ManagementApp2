package com.example.managementapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Button btn2;
    Databasee databasee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        databasee = new Databasee(MainActivity.this);
        // btn =(Button) findViewById(R.id.adminhomebtn);
        getEmployes();
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, adminnform.class);
//                startActivity(intent);
//            }
//        });
        btn2 = (Button) findViewById(R.id.employeehomebtn);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, employeeloginform.class);
                startActivity(intent);
            }
        });
    }

    public void getEmployes() {
        Cursor cursor = databasee.getEmployee();
        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "NO data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                Toast.makeText(getApplicationContext(), cursor.getString(1)
                        .toString() + "\n" + cursor.getString(2).toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}

