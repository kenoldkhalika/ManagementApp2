package com.example.managementapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class ShowData extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<model> dataholder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
//        recyclerView=(RecyclerView) findViewById(R.id.recview);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        Cursor cursor= new Databasee(this).readalldata();
//        dataholder=new ArrayList<>();
//        while (cursor.moveToNext()){
//            model obj = new model(cursor.getString(1));
//            dataholder.add(obj);
//        }
//        dataAdapter dataAdapter=new dataAdapter(dataholder);
//        recyclerView.setAdapter(dataAdapter);

    }
}