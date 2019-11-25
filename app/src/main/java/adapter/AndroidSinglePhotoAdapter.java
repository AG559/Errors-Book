package adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ag.errorsbook.R;

import java.util.ArrayList;

public class AndroidSinglePhotoAdapter extends RecyclerView.Adapter<AndroidSinglePhotoAdapter.PhotoHolder> {
    private Context context;
    private ArrayList<Integer> list;

    public AndroidSinglePhotoAdapter(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.android_single_row_image, parent, false);
        return new PhotoHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PhotoHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        PhotoHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.aimg_single_row);
        }

    }
}
