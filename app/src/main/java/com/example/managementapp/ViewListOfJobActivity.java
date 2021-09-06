package com.example.managementapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ViewListOfJobActivity extends AppCompatActivity {
    Databasee myDB;
    private ListView listView;
    private SearchView searchView;
    ImageView back;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        listView = (ListView) findViewById(R.id.ListVView);
        searchView = findViewById(R.id.search);
        back = findViewById(R.id.dd);

        myDB = new Databasee(this);
        ArrayList<String> thelist = new ArrayList<>();
        ArrayList<String> thelistName = new ArrayList<>();
        ArrayList<String> thelistJob = new ArrayList<>();

        Cursor data = myDB.readalljob();
        if (data.getCount() == 0) {
            Toast.makeText(ViewListOfJobActivity.this, "Empty database", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                thelistName.add(data.getString(1).toString());
                thelistJob.add(data.getString(2).toString());
                thelist.add("\nNAME : " + " " + "" + data.getString(1)
                        + "\nJOB :" + " " + " " + "    " + data.getString(2));
            }
        }
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
        listView.setAdapter(listAdapter);

        // search thingz here
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<String> searchResults = myDB.searchEmp(newText);
                ListAdapter listAdapter = new ArrayAdapter<>(ViewListOfJobActivity.this, android.R.layout.simple_list_item_1, searchResults);
                listView.setAdapter(listAdapter);

                return false;
            }
        });
        // search thingz endz here

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewListOfJobActivity.this, JobActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = thelistName.get(position).toString();
                String job = thelistJob.get(position).toString();
                Cursor data = myDB.getJobID(name, job);
                int itemID = -1;

                while (data.moveToNext()) {
                    itemID = data.getInt(0);

                }

                Intent editUpdate = new Intent(ViewListOfJobActivity.this, EditJobActivity.class);
                editUpdate.putExtra("id", itemID);
                editUpdate.putExtra("name", name);
                editUpdate.putExtra("job", job);
                startActivity(editUpdate);

            }
        });

    }

}
