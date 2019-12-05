package com.ag.errorsbook.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ag.errorsbook.ImageFullScreen;
import com.ag.errorsbook.R;

import java.util.ArrayList;


public class AndroidSinglePhotoAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Integer> images;
    private LayoutInflater layoutInflater;

    public AndroidSinglePhotoAdapter(Context context, ArrayList<Integer> images) {
        super();
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.android_single_row_image, null);
        ImageView imageView = view.findViewById(R.id.asingle_row_img);
        imageView.setImageResource(images.get(position));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ImageFullScreen.class);
                i.putExtra("imgs", images);
                i.putExtra("position", position);
                context.startActivity(i);
            }
        });
        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}
