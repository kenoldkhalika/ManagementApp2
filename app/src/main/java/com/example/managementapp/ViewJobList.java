package com.example.managementapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewJobList extends AppCompatActivity {
    ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Databasee myDB;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ListView listView = (ListView) findViewById(R.id.ListVView);
        myDB = new Databasee(this);
        ArrayList<String> thelist = new ArrayList<>();
        Cursor cursor = myDB.readalljob();
        if (cursor.getCount() == 0) {
            Toast.makeText(ViewJobList.this, "Database is empty", Toast.LENGTH_LONG).show();
        } else {
            while (cursor.moveToNext()) {
                thelist.add(cursor.getString(1));
                thelist.add(cursor.getString(2));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
