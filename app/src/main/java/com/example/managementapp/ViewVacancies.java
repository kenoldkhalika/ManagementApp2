package com.example.managementapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewVacancies extends AppCompatActivity {
    Databasee myDB;
    ImageView back;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vacanciesviewing);
        back = findViewById(R.id.gg);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewVacancies.this, VacancyActivities.class);
                startActivity(intent);
            }
        });


        listView = (ListView) findViewById(R.id.Vacaciesview);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        myDB = new Databasee(this);
        ArrayList<String> thelist = new ArrayList<>();
        Cursor data = myDB.readallVacancy();
        if (data.getCount() == 0) {
            Toast.makeText(ViewVacancies.this, "Empty database", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                thelist.add(data.getString(1));

            }
        }
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String string = (String) parent.getItemAtPosition(position);
                //String string = (String) parent.getItemIdAtPosition(position);


                Cursor data = myDB.getVacancyID(string);
                int itemID = -1;
                while (data.moveToNext()) {
                    itemID = data.getInt(0);
                }
                if (itemID > -1) {
                    Intent editUpdate = new Intent(ViewVacancies.this, EditVacancyActivity.class);
                    editUpdate.putExtra("id", itemID);
                    editUpdate.putExtra("update", string);
                    startActivity(editUpdate);
                }
            }
        });

    }
}
