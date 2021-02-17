package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class AdsList extends AppCompatActivity {

    GridView gridView;
    ArrayList<Ads> list;
    AdsListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads_list);


        BottomNavigationView btv = findViewById(R.id.bottom_navigation);
        btv.setSelectedItemId(R.id.ads_listw);

        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.aboutw:
                        startActivity(new Intent(getApplicationContext(), AboutPage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ads_listw:
                        return true;

                    case R.id.homew:
                        startActivity(new Intent(getApplicationContext(), ItemAdd.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;


            }
        });

        gridView = (GridView)findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new AdsListAdapter(this,R.layout.ads_items,list);
        gridView.setAdapter(adapter);

        Cursor cursor = ItemAdd.sqLiteHelper.getData("SELECT * FROM ADS");
        list.clear();

        while (cursor.moveToNext()){

            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            byte[] image = cursor.getBlob(3);

            list.add(new Ads(id,name,price,image));


        }

        adapter.notifyDataSetChanged();


    }
}