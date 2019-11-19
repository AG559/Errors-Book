package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    public void onBindViewHolder(@NonNull AndroidRecyclerAdapterView holder, int position) {
            
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class AndroidRecyclerAdapterView extends RecyclerView.ViewHolder {

         AndroidRecyclerAdapterView(@NonNull View itemView) {
            super(itemView);
        }
    }
}
