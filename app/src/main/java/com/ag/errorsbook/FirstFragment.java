package com.ag.errorsbook;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapter.AndroidRecycleAdapter;
import model.AndroidDataModel;


public class FirstFragment extends Fragment {

    private RecyclerView recyclerView;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        recyclerView = getActivity().findViewById(R.id.frag_one_recycler);
//        AndroidRecycleAdapter adapter = new AndroidRecycleAdapter(getActivity(), new ArrayList<AndroidDataModel>());
//        recyclerView.setAdapter(adapter);
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

}
