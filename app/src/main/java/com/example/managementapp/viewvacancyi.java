package com.example.managementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class viewvacancyi extends AppCompatActivity {
    Button sbmt,view;
    EditText vacancy;
    Databasee myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_viewvacancyi);
//        sbmt=findViewById(R.id.addVacancY);
//        vacancy=(EditText) findViewById(R.id.gh) ;
//        view=findViewById(R.id.viewVacancY);
//        myDB= new Databasee(this);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//             //   Intent intent= new Intent(viewvacancyi.this , ViewListOfVacancy.class);
//             //   startActivity(intent);
//            }
//        });
//        sbmt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String item = vacancy.getText().toString();
//
//                if (item.equals(""))
//                    Toast.makeText(viewvacancyi.this, "Fill this field", Toast.LENGTH_SHORT).show();
//                else {
//                    Boolean insert = myDB.addVacancy(item);
//                    if (insert){
//                        Toast.makeText(viewvacancyi.this, "Success", Toast.LENGTH_SHORT).show();
//                    }
//                    else{
//                        Toast.makeText(viewvacancyi.this, "Registration failed", Toast.LENGTH_LONG).show();
//                    }
//                }
//
//            }
//        });
//
//
//    }
//    public void addData(String entry){
//      boolean insertData = myDB.addVacancy(entry);
//       if (insertData==true){
//          Toast.makeText(viewvacancyi.this,"Successfully entered", Toast.LENGTH_LONG).show();
//     }
//      else {Toast.makeText(viewvacancyi.this,"something went wrong", Toast.LENGTH_LONG).show();
//        }

   }
   }
