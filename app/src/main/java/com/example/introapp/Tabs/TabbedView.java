package com.example.introapp.Tabs;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.introapp.Helper.Session;
import com.example.introapp.R;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class TabbedView extends AppCompatActivity {
    private static final String HI = "https://uniqueandrocode.000webhostapp.com/hiren/androidweb.php";
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed_view);
        ViewPager viewPager = findViewById(R.id.pager);
        TabLayout tabLayout = findViewById(R.id.tablayout);
        session = new Session(this);
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        tabAdapter.addFragment(new Tab1Fragment(), "Closed");
        tabAdapter.addFragment(new Tab2Fragment(), "Open");
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1, false);
        getData();

    }

    private void getData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, HI, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("responce", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("data");

                    String jsonString = array.toString();
                    session.getListdata(jsonString);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
              /*  myAdapter = new MyAdapter(list_data, getApplicationContext());
                rv.setAdapter(myAdapter);

                myAdapter.notifyDataSetChanged();*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}