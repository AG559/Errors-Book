package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ag.errorsbook.AndroidSingle;
import com.ag.errorsbook.R;

import java.util.ArrayList;

import model.AndroidDataModel;

public class AndroidRecycleAdapter extends RecyclerView.Adapter<AndroidRecycleAdapter.AndroidRecyclerAdapterView> {
    private Context context;
    private ArrayList<AndroidDataModel> list;

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
        holder.title.setText(list.get(position).getTitle());
        holder.name.setText(list.get(position).getAuthor());
        holder.desc.setText(list.get(position).getDescription());
        holder.date.setText(list.get(position).getDate());
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, AndroidSingle.class);
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
}
