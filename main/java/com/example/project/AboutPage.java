package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AboutPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        BottomNavigationView btv = findViewById(R.id.bottom_navigation);
        btv.setSelectedItemId(R.id.aboutw);

        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                   case R.id.aboutw:
                       return true;
                    case R.id.ads_listw:
                        startActivity(new Intent(getApplicationContext(), AdsList.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.homew:
                        startActivity(new Intent(getApplicationContext(), ItemAdd.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;


            }
        });
    }
}