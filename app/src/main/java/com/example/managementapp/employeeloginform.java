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

public class employeeloginform extends AppCompatActivity {

    EditText username, password;
    Button btnlogin;
    TextView btnm;
    Databasee DB;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employeeloginform);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        back = findViewById(R.id.backToHome);
        btnm = (TextView) findViewById(R.id.registernuewemployee);
        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employeeloginform.this, registernewemployee.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(employeeloginform.this, MainActivity.class);
                startActivity(intent);
            }
        });
        username = (EditText) findViewById(R.id.employeeusernameeee);
        password = (EditText) findViewById(R.id.employeepasssw);
        btnlogin = (Button) findViewById(R.id.employeeloginbtnnv);
        DB = new Databasee(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.equals(" ") || pass.equals(" "))
                    Toast.makeText(employeeloginform.this, "please enter all fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.passwordmetod(user, pass);
                    if (checkuserpass == true) {
                        Toast.makeText(employeeloginform.this, "sign in successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), adminduties.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(employeeloginform.this, "invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

}