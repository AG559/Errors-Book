package com.ag.errorsbook;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapter.AndroidRecycleAdapter;
import model.AndroidDataModel;


public class FirstFragment extends Fragment {
    private ArrayList<AndroidDataModel> list;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.frag_one_recycler);
        setData();
        AndroidRecycleAdapter adapter = new AndroidRecycleAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    private void setData() {
        list = new ArrayList<>();
        list.add(new AndroidDataModel("Aung Kyaw Khaing",
                "Error inflating class android.support.v7.widget.Toolbar? ",
                "www.google.com",
                "whyoz His method adds unneeded complexity to view hierarchy. You will need two additional views (A layout container and the border view)",
                R.drawable.girl_one, "20/12/2019"));
        list.add(new AndroidDataModel("Ya Wai Aung",
                "Error inflating class android.support.v7.widget.Toolbar? ",
                "www.google.com",
                "whyoz His method adds unneeded complexity to view hierarchy. You will need two additional views (A layout container and the border view)",
                R.drawable.girl_two, "3/4/2019"));
        list.add(new AndroidDataModel("El Do Soe",
                "Error inflating class android.support.v7.widget.Toolbar? ",
                "www.google.com",
                "whyoz His method adds unneeded complexity to view hierarchy. You will need two additional views (A layout container and the border view)",
                R.drawable.girl_three, "11/3/2018"));
    }

}
