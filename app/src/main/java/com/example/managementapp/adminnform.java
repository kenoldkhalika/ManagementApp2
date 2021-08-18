package com.example.managementapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class adminnform extends AppCompatActivity {
Button btn;
ImageView back1;
EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        back1=(ImageView) findViewById(R.id.imageV);
        username=(EditText) findViewById(R.id.adminusernamee);
        password=(EditText) findViewById(R.id.adminpasss);
        setContentView(R.layout.activity_adminnform);
        btn = (Button) findViewById(R.id.adminnnlogimn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(adminnform.this, adminduties.class);
                startActivity(intent);
            }
        });
//        back1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(adminnform.this, MainActivity.class);
//                startActivity(intent);
//
//            }
//        });
    }
}