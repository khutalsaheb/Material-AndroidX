package com.example.introapp.Tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.introapp.Helper.Session;
import com.example.introapp.R;
import com.example.introapp.Temp.MyAdapter;
import com.example.introapp.Temp.News;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Tab2Fragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_notification, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Session session = new Session(getActivity());
        List<News> list_data = new ArrayList<>();
        HashMap<String, String> user = session.getUserDetail();
        String jsonString = user.get(Session.KEY_DATA);
        JSONArray jsonArray;
        try {
            jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject ob = jsonArray.getJSONObject(i);
                News ld = new News(ob.getString("name"), ob.getString("imageurl"));
                list_data.add(ld);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        MyAdapter myAdapter = new MyAdapter(list_data, getActivity());
        recyclerView.setAdapter(myAdapter);

        myAdapter.notifyDataSetChanged();

        return view;
    }


}