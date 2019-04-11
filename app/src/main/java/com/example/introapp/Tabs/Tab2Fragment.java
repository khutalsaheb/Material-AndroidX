package com.example.introapp.Tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.introapp.R;
import com.example.introapp.Temp.MyAdapter;
import com.example.introapp.Temp.News;
import com.example.introapp.ViewModel.TabViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Tab2Fragment extends Fragment {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview_layout, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TabViewModel model = ViewModelProviders.of(this).get(TabViewModel.class);
        model.getHeroes().observe(this, new Observer<List<News>>() {
            @Override
            public void onChanged(@Nullable List<News> list_data) {
                myAdapter = new MyAdapter(getActivity(), list_data);
                recyclerView.setAdapter(myAdapter);
            }
        });

        return view;
    }


}