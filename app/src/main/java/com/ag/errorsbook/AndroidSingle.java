package com.ag.errorsbook;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapter.AndroidSinglePhotoAdapter;

public class AndroidSingle extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Integer> list;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_single);
        toolbar =findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Error Collection Book");


        recyclerView = findViewById(R.id.android_single_row_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        list = new ArrayList<>();
        list.add(R.drawable.girl_one);
        list.add(R.drawable.girl_two);
        list.add(R.drawable.girl_three);

        AndroidSinglePhotoAdapter adapter = new AndroidSinglePhotoAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }
}
