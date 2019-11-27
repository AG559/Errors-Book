package com.ag.errorsbook.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.ag.errorsbook.AndroidSingle;
import com.ag.errorsbook.R;
import com.ag.errorsbook.helper.CustomFilter;
import com.ag.errorsbook.model.AndroidDataModel;

import java.util.ArrayList;

public class AndroidRecycleAdapter extends RecyclerView.Adapter<AndroidRecycleAdapter.AndroidRecyclerAdapterView> {
    private Context context;
    public ArrayList<AndroidDataModel> list;
    private ArrayList<Integer> img_list;
    private CustomFilter customFilter;

    public AndroidRecycleAdapter(Context context, ArrayList<AndroidDataModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AndroidRecyclerAdapterView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.android_fragment_row, parent, false);
        return new AndroidRecyclerAdapterView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AndroidRecyclerAdapterView holder, final int position) {
        final String title = list.get(position).getTitle();
        final String author = list.get(position).getAuthor();
        final String description = list.get(position).getDescription();
        final String date = list.get(position).getDate();
        final TypedArray imgs = list.get(position).getImage();
        if (title.length() > 70) {
            holder.title.setText(title.subSequence(0, 70));
        } else {
            holder.title.setText(title);
        }
        holder.name.setText(author);
        if (description.length() > 136) {
            holder.desc.setText(HtmlCompat.fromHtml(description, 0).subSequence(0, 136));
        } else {
            holder.desc.setText(HtmlCompat.fromHtml(description, 0));
        }
        holder.date.setText(date);
        holder.imageView.setImageDrawable(imgs.getDrawable(0));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, AndroidSingle.class);
                img_list = new ArrayList<>();
                for (int i = 0; i < imgs.length(); i++) {
                    img_list.add(imgs.getResourceId(i, 0));
                }
                intent.putExtra("title", title);
                intent.putExtra("author", author);
                intent.putExtra("description", description);
                intent.putExtra("date", date);
                intent.putExtra("img_array", img_list);
                context.startActivity(intent);
                Toast.makeText(context, list.get(position).getAuthor(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class AndroidRecyclerAdapterView extends RecyclerView.ViewHolder {
        private TextView title, name, desc, date;
        private ImageView imageView;
        private CardView cardView;

        AndroidRecyclerAdapterView(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_arecycler_row_title);
            name = itemView.findViewById(R.id.tv_arecycler_row_name);
            desc = itemView.findViewById(R.id.tv_arecycler_row_content);
            date = itemView.findViewById(R.id.tv_arecycler_row_date);
            imageView = itemView.findViewById(R.id.img_arecycler_row);
            cardView = itemView.findViewById(R.id.android_row_cardView);
        }
    }

    public CustomFilter getFilter() {
        if (customFilter == null) {
            customFilter = new CustomFilter(list,this);
        }
        return customFilter;
    }
}
