package com.ag.errorsbook.helper;

import android.widget.Filter;

import com.ag.errorsbook.adapter.AndroidRecycleAdapter;
import com.ag.errorsbook.model.AndroidDataModel;

import java.util.ArrayList;

public class CustomFilter extends Filter {
    private ArrayList<AndroidDataModel> filterList;
    private AndroidRecycleAdapter adapter;

    public CustomFilter(ArrayList<AndroidDataModel> filterlist, AndroidRecycleAdapter adapter) {
        this.filterList = filterlist;
        this.adapter = adapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        if (constraint != null && constraint.length() > 0) {
            constraint = constraint.toString().toUpperCase();
            ArrayList<AndroidDataModel> filteredData = new ArrayList<>();
            for (int i = 0; filterList.size() > i; i++) {
                if (filterList.get(i).getTitle().toUpperCase().contains(constraint)) {
                    filteredData.add(filterList.get(i));
                }
            }
            results.count = filteredData.size();
            results.values = filteredData;
        } else {
            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.list = (ArrayList<AndroidDataModel>) results.values;
        adapter.notifyDataSetChanged();
    }
}
