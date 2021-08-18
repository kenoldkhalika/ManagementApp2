package com.example.managementapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ViewJobActvityy extends AppCompatActivity {
ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_job_actvityy);
        Databasee databasee= new Databasee(this);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        back=findViewById(R.id.dd);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ViewJobActvityy.this, JobActivity.class);
                startActivity(intent);
            }
        });
        TextView textView= findViewById(R.id.tex);
        Cursor cursor= databasee.readalljob();
        StringBuilder stringBuilder=new StringBuilder();
        while (cursor.moveToNext()){
            stringBuilder.append("\nRoll number :" +cursor.getInt(0)
                    +"\nStudent name :"+cursor.getString(1)
                    +"\nMarks:"+cursor.getInt(3));
        }
        textView.setText(stringBuilder);
    }
}