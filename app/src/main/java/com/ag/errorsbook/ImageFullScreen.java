package com.ag.errorsbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.ag.errorsbook.adapter.ImageFullScreenAdapter;

import java.util.ArrayList;

public class ImageFullScreen extends AppCompatActivity {

    ViewPager viewPager;
    ArrayList<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));
        setContentView(R.layout.activity_image_full_screen);
        viewPager = findViewById(R.id.aimg_full_viewpager);
        Intent i = getIntent();
        list = i.getIntegerArrayListExtra("imgs");
        ImageFullScreenAdapter adapter = new ImageFullScreenAdapter(this, list);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(i.getIntExtra("position", 0));

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
        }
        return true;
    }
}
