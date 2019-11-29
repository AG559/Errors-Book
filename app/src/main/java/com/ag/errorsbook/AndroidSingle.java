package com.ag.errorsbook;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;

import com.ag.errorsbook.adapter.AndroidSinglePhotoAdapter;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class AndroidSingle extends AppCompatActivity {
    ArrayList<Integer> list;
    Toolbar toolbar;
    TextView title, content;
    SliderView sliderView;

    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_single);
        toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Error Collection Book");


        title = findViewById(R.id.asingle_tv_title);
        content = findViewById(R.id.asingle_tv_content);


        Intent i = getIntent();
        list = i.getIntegerArrayListExtra("img_array");


        title.setText(i.getStringExtra("title"));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            content.setText(HtmlCompat.fromHtml(i.getStringExtra("description"), 0));
        }
        sliderView = findViewById(R.id.imageSlider);

        final AndroidSinglePhotoAdapter adapter = new AndroidSinglePhotoAdapter(this);
        adapter.setCount(5);

        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorVisibility(false);
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.startAutoCycle();


        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                sliderView.setCurrentPagePosition(position);
            }
        });

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



