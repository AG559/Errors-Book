package com.ag.errorsbook.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


import com.ag.errorsbook.R;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;

public class ImageFullScreenAdapter extends PagerAdapter {
    private Activity activity;
    private ArrayList<Integer> _imagePaths;
    private LayoutInflater inflater;

    // constructor
    public ImageFullScreenAdapter(Activity activity, ArrayList<Integer> imagePaths) {
        this.activity = activity;
        this._imagePaths = imagePaths;
    }

    @Override
    public int getCount() {
        return this._imagePaths.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        PhotoView imageView;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.aimg_full_screen, null, false);
        imageView = view.findViewById(R.id.imgDisplay);
        imageView.setImageResource(_imagePaths.get(position));

        container.setFocusableInTouchMode(true);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }

}
