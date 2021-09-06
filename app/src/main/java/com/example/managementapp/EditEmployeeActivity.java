package com.example.managementapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class EditEmployeeActivity extends AppCompatActivity {
    Databasee myDB;
    Button delete;
    ImageView back;
    private EditText fname;
    private EditText lname;
    private EditText address;
    private EditText nextOfkin;
    TextView update;
    private String selectedfname;
    private String selectedlname;
    private String selectedadres;
    private String selectednextofkin;

    private int selectedID;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editemployee);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        delete = findViewById(R.id.deleteEmployee);
        back = findViewById(R.id.backwards);
        fname = findViewById(R.id.updatefname);
        update = findViewById(R.id.updateEmployee);
        lname = findViewById(R.id.updatelname);
        address = findViewById(R.id.updateaddres);
        nextOfkin = findViewById(R.id.updatenextofkin);
        myDB = new Databasee(this);
        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id", -1);
        selectedfname = receivedIntent.getStringExtra("fname");
        selectedlname = receivedIntent.getStringExtra("lname");
        selectedadres = receivedIntent.getStringExtra("address");
        selectednextofkin = receivedIntent.getStringExtra("nextOfkin");
        fname.setText(selectedfname);
        lname.setText(selectedlname);

        address.setText(selectedadres);
        nextOfkin.setText(selectednextofkin);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditEmployeeActivity.this, listOfEmployees.class);
                startActivity(intent);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.deleteEmpDetails(selectedID);
                Toast.makeText(EditEmployeeActivity.this, "deleted successfully", Toast.LENGTH_LONG).show();
                fname.setText("");
                lname.setText("");

                address.setText("");
                nextOfkin.setText("");

                Intent editUpdate = new Intent(EditEmployeeActivity.this, MainActivityPicture.class);
                startActivity(editUpdate);

            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String finame = fname.getText().toString().trim();
                String lnamee = lname.getText().toString().trim();
                String adrees = address.getText().toString().trim();
                String nextofKinnb = nextOfkin.getText().toString().trim();
                Toast.makeText(EditEmployeeActivity.this, "updated successfully", Toast.LENGTH_LONG).show();
                if (!finame.isEmpty() && !lnamee.isEmpty() && !adrees.isEmpty() && !nextofKinnb.isEmpty()) {
                    myDB.updateEmployee(finame, lnamee, adrees, nextofKinnb, selectedID);

                } else {
                    Toast.makeText(EditEmployeeActivity.this, "put somethig", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}