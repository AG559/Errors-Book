package com.ag.errorsbook;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ag.errorsbook.adapter.AndroidSinglePhotoAdapter;

import java.util.ArrayList;

public class AndroidSingle extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Integer> list;
    Toolbar toolbar;
    TextView title, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_single);
        toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Error Collection Book");


        recyclerView = findViewById(R.id.android_single_row_recycler);
        title = findViewById(R.id.asingle_tv_title);
        content = findViewById(R.id.asingle_tv_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        Intent i = getIntent();
        list = i.getIntegerArrayListExtra("img_array");


        title.setText(i.getStringExtra("title"));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            content.setText(HtmlCompat.fromHtml(i.getStringExtra("description"), 0));
        }
        AndroidSinglePhotoAdapter adapter = new AndroidSinglePhotoAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.asingle_code_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.codeView:
                startActivity(new Intent(this, CodeDisplay.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
