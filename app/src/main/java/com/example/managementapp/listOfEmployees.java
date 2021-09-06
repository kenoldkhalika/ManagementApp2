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
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class listOfEmployees extends AppCompatActivity {
    Databasee myDB;
    private ListView listView;
    SearchView searchView;
    ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employeedetails);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        listView = (ListView) findViewById(R.id.employeedetails);
        back = findViewById(R.id.backToEmployeeActivity);
        searchView = findViewById(R.id.searchmore);
        myDB = new Databasee(this);
        ArrayList<String> thelist = new ArrayList<>();
        ArrayList<String> fname = new ArrayList<>();
        ArrayList<String> lname = new ArrayList<>();
        ArrayList<String> address = new ArrayList<>();
        ArrayList<String> nextOfkin = new ArrayList<>();

        Cursor data = myDB.readallNewEmployee();
        if (data.getCount() == 0) {
            Toast.makeText(listOfEmployees.this, "Empty database", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                fname.add(data.getString(1).toString());
                lname.add(data.getString(2).toString());
                address.add(data.getString(3).toString());
                nextOfkin.add(data.getString(4).toString());
                thelist.add("\nFISRT NAME : " + " " + "" + data.getString(1)
                        + "\nLAST NAME :" + " " + " " + "    " + data.getString(2)
                        + "\nADDRESS :" + " " + " " + "    " + data.getString(3)
                        + "\nNEXT OF KIN :" + " " + " " + "    " + data.getString(4));

            }
        }

        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
        listView.setAdapter(listAdapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listOfEmployees.this, MainActivityPicture.class);
                startActivity(intent);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<String> searchResults = myDB.searchEmpDetails(newText);
                ListAdapter listAdapter = new ArrayAdapter<>(listOfEmployees.this, android.R.layout.simple_list_item_1, searchResults);
                listView.setAdapter(listAdapter);

                return false;
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String finame = fname.get(position).toString();
                String laname = lname.get(position).toString();
                String addrs = address.get(position).toString();
                String nextOfKinn = nextOfkin.get(position).toString();
                Cursor data = myDB.getEmployeeID(finame, laname, addrs, nextOfKinn);
                int itemID = -1;

                while (data.moveToNext()) {
                    itemID = data.getInt(0);

                }

                Intent editUpdate = new Intent(listOfEmployees.this, EditEmployeeActivity.class);
                editUpdate.putExtra("id", itemID);
                editUpdate.putExtra("fname", finame);
                editUpdate.putExtra("lname", laname);
                editUpdate.putExtra("address", addrs);
                editUpdate.putExtra("nextOfkin", nextOfKinn);
                startActivity(editUpdate);

            }
        });

    }
}