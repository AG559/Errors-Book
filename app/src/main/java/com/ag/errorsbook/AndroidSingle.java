package com.ag.errorsbook;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.viewpager.widget.ViewPager;

import com.ag.errorsbook.adapter.AndroidSinglePhotoAdapter;

import java.util.ArrayList;

public class AndroidSingle extends AppCompatActivity {
    ArrayList<Integer> list;
    Toolbar toolbar;
    TextView title, content;
    ViewPager viewPager;

    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_single);
        toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Error Collection");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.flag));
        }

        title = findViewById(R.id.asingle_tv_title);
        content = findViewById(R.id.asingle_tv_content);
        viewPager = findViewById(R.id.viewPager);


        Intent i = getIntent();
        list = i.getIntegerArrayListExtra("img_array");


        title.setText(i.getStringExtra("title"));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            content.setText(HtmlCompat.fromHtml(i.getStringExtra("description"), 0));
        }

        final AndroidSinglePhotoAdapter adapter = new AndroidSinglePhotoAdapter(this, list);
        viewPager.setAdapter(adapter);

        sliderDotspanel = findViewById(R.id.SliderDots);
        dotscount = list.size();
        dots = new ImageView[dotscount];

        for (int ii = 0; ii < dotscount; ii++) {

            dots[ii] = new ImageView(this);
            dots[ii].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[ii], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < list.size(); i++) {
                    dots[i].setImageResource(R.drawable.non_active_dot);
                }
                dots[position].setImageResource(R.drawable.active_dot);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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



