package com.example.managementapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Fragmentss extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragmentss);
//        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigationn);
//bottomNavigationView.setOnItemSelectedListener(naVListener);
//getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contaner, new PeopleFragments()).commit();
//
//    }
//private NavigationBarView.OnItemSelectedListener naVListener= new BottomNavigationView.OnItemSelectedListener() {
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        Fragment selectedFragment=null;
//        switch (item.getItemId()){
//            case R.id.managePeople:
//                selectedFragment=new PeopleFragments();
//                break;
//            case R.id.VacancyN:
//                selectedFragment=new fragmentJob();
//                break;
//            case R.id.updted:
//                selectedFragment=new fragmentupdatE();
//                break;
//        }
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contaner,
//               selectedFragment ).commit();
//        return true;
//    }
//
//};
}