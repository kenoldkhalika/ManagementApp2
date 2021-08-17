package com.example.managementapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewListOfJobActivity extends AppCompatActivity {
    Databasee myDB;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        ListView listView= (ListView) findViewById(R.id.ListVView);
        myDB= new Databasee(this);
        ArrayList<String> thelist= new ArrayList<>();
        Cursor data =myDB.readalljob();
        if (data.getCount()==0){
            Toast.makeText(ViewListOfJobActivity.this,"Empty database", Toast.LENGTH_LONG).show();
        }
        else {
            while (data.moveToNext()){
                thelist.add("\nNAME : "+" "+""+data.getString(1)
                +"\nJOB :"+" "+" "+"    "+data.getString(2));
                ListAdapter listAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,thelist);
                listView.setAdapter(listAdapter);
            }
        }
    }

}
