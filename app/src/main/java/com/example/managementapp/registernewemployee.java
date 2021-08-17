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

public class registernewemployee extends AppCompatActivity {
EditText password, username,retypepassword;
Button signup;
TextView sighin ;
ImageView back;
Databasee DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registernewemployee);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        back=findViewById(R.id.imageView4);
        username=(EditText) findViewById(R.id.newusername);
         password=(EditText) findViewById(R.id.newemployeepass1);
         retypepassword=(EditText) findViewById(R.id.newemployeepass2);
         signup=(Button) findViewById(R.id.signupp);
        sighin=(TextView) findViewById(R.id.gud) ;
         DB = new Databasee(this);

         back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(),employeeloginform.class);
                 startActivity(intent);

             }
         });
         signup.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = retypepassword.getText().toString();
                if (user.equals(" ")|| pass.equals(" ")|| repass.equals(" "))
                    Toast.makeText(registernewemployee.this, "Please enter all fields", Toast.LENGTH_SHORT ).show();
                else {
                    if (pass.equals(repass)){
                        Boolean checkuser=DB.userr(user);
                        if (checkuser==false){
                            Boolean insert =DB.insertData(user, pass);
                            if (insert==true){
                                Toast.makeText(registernewemployee.this, "registered successfully",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),employeeloginform.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(registernewemployee.this,"registration failed",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else {
                            Toast.makeText(registernewemployee.this,"user already exixts",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(registernewemployee.this,"password not matching",Toast.LENGTH_SHORT).show();
                    }
                }
             }
         });
         sighin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(),employeeloginform.class);
                 startActivity(intent);

             }
         });
    }
}