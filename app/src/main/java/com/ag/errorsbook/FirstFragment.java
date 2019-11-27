package com.ag.errorsbook;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ag.errorsbook.adapter.AndroidRecycleAdapter;
import com.ag.errorsbook.model.AndroidDataModel;

import java.util.ArrayList;


public class FirstFragment extends Fragment {
    private ArrayList<AndroidDataModel> list;
    private SearchView searchView;
    AndroidRecycleAdapter adapter;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.frag_one_recycler);
        setData();
        adapter = new AndroidRecycleAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.toolbar_menu, menu);
        searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
    }

    private void setData() {
        list = new ArrayList<>();
        list.add(new AndroidDataModel("Aung Kyaw Khaing",
                "Error inflating class android.support.v7.widget.Toolbar? ",
                "www.google.com",
                getResources().getString(R.string.test_html),
                getResources().obtainTypedArray(R.array.test_img_ary),
                "3/4/2019"
        ));
        list.add(new AndroidDataModel("Ya Wai Aung",
                "The repetition of “pale” reinforces the subtext of tubercular illness. In the next stanza we see the victims’ “starved lips” (starved for air?) and hear their only words, “La Belle Dame sans Merci / Thee hath in thrall!” ",
                "www.google.com",
                getResources().getString(R.string.test_one_html),
                getResources().obtainTypedArray(R.array.test_img_ary_one),
                "3/4/2019"));
        list.add(new AndroidDataModel("El Do Soe",
                "Martin Earl lives in Coimbra, in central Portugal ",
                "www.google.com",
                getResources().getString(R.string.test_two_html),
                getResources().obtainTypedArray(R.array.test_img_ary_two),
                "11/3/2018"));
    }
}
