package com.ag.errorsbook.adapter;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ag.errorsbook.R;
import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class AndroidSinglePhotoAdapter extends SliderViewAdapter<AndroidSinglePhotoAdapter.SliderAdapterVH> {
    private Context context;
    private int mCount;

    public AndroidSinglePhotoAdapter(Context context) {
        this.context = context;
    }

    public void setCount(int count) {
        this.mCount = count;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.android_single_row_image, parent, false);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });

        switch (position) {
            case 0:
                viewHolder.textViewDescription.setText("This is slider item " + position);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                Glide.with(viewHolder.itemView)
                        .load("https://scontent.frgn9-1.fna.fbcdn.net/v/t1.0-9/45358969_1964329763610438_3931455836890595328_n.jpg?_nc_cat=100&_nc_ohc=pMxtsAPotcQAQmJIvoisTJj1re_aohA4vweQ7OaB0aIpTJaetEvQC_aWw&_nc_ht=scontent.frgn9-1.fna&oh=4c1ca6cb12cf45f20b866a162da99ccb&oe=5E4913EB")
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;
            case 1:
                viewHolder.textViewDescription.setText("This is slider item " + position);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                Glide.with(viewHolder.itemView)
                        .load("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260")
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;
            case 2:
                viewHolder.textViewDescription.setText("This is slider item " + position);
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                Glide.with(viewHolder.itemView)
                        .load("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260")
                        .fitCenter()
                        .into(viewHolder.imageViewBackground);
                break;
            default:

                break;

        }

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mCount;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        TextView textViewDescription;
        ImageView imagegifContainer;

        SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            imagegifContainer = itemView.findViewById(R.id.iv_gif_container);
            this.itemView = itemView;
        }
    }

}
