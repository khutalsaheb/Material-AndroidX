package com.example.introapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.introapp.Tabs.TabbedView;
import com.example.introapp.Temp.News;
import com.example.introapp.Temp.NewsAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.infideap.drawerbehavior.Advance3DDrawerLayout;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, NewsAdapter.ChangeStatusListener {

    private Advance3DDrawerLayout drawer;
    private BottomSheetDialog bottomSheetDialog;
    private RecyclerView mNewsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//Recycle Data START
        mNewsList = findViewById(R.id.recycler_view);
        ReCycle();
//Recycle Data END
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer.setViewScale(Gravity.START, 0.96f);
        drawer.setRadius(Gravity.START, 20);
        drawer.setViewElevation(Gravity.START, 8);
        drawer.setViewRotation(Gravity.START, 15);


        //This will initialize the BottomAppBar
        BottomAppBar bar = findViewById(R.id.appbar);

        //This will add the OptionMenu to BottomAppBar
        bar.replaceMenu(R.menu.bottom_appbar_menu_primary);

        //This will handle the onClick Action for the menu item
        bar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.like:
                        Toast.makeText(MainDrawerActivity.this, "Like Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.search:
                        Toast.makeText(MainDrawerActivity.this, "Search Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings:
                        Toast.makeText(MainDrawerActivity.this, "Settings Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.profile:
                        Toast.makeText(MainDrawerActivity.this, "Logout Clicked", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        //handle the onClick action for bottom app bar navigation icon
        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNavigationMenu();
            }
        });

        //add the onClick to the floatingactionbutton
        FloatingActionButton fab = findViewById(R.id.fab_bar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    Toast.makeText(MainDrawerActivity.this,"Floating Action Button Clicked",Toast.LENGTH_SHORT).show();
                //   openNavigationMenu();
                @SuppressLint("InflateParams") final View bootomNavigation = getLayoutInflater().inflate(R.layout.customdialog, null);
                bottomSheetDialog = new BottomSheetDialog(MainDrawerActivity.this);
                bottomSheetDialog.setContentView(bootomNavigation);
                bottomSheetDialog.show();
            }
        });
    }

    private void openNavigationMenu() {

        //this will get the menu layout
        @SuppressLint("InflateParams") final View bootomNavigation = getLayoutInflater().inflate(R.layout.navigation_menu, null);
        bottomSheetDialog = new BottomSheetDialog(MainDrawerActivity.this);
        bottomSheetDialog.setContentView(bootomNavigation);
        bottomSheetDialog.show();

        //this will find NavigationView from id
        NavigationView navigationView = bootomNavigation.findViewById(R.id.navigation_menu);

        //This will handle the onClick Action for the menu item
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.item1:
                        startActivity(new Intent(getApplicationContext(), TabbedView.class));
                        //  Toast.makeText(MainDrawerActivity.this, "Item 1 Clicked", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        break;
                    case R.id.item2:
                        startActivity(new Intent(getApplicationContext(), TabbedView.class));
                        bottomSheetDialog.dismiss();
                        break;
                    case R.id.item3:
                        startActivity(new Intent(getApplicationContext(), TabbedView.class));
                        bottomSheetDialog.dismiss();
                        break;
                    case R.id.item4:
                        startActivity(new Intent(getApplicationContext(), TabbedView.class));
                        bottomSheetDialog.dismiss();
                        break;
                }
                return false;
            }
        });


    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("RtlHardcoded")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_right_drawer:
                ReCycle();
                drawer.openDrawer(Gravity.RIGHT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void ReCycle() {
        ArrayList<News> data = new ArrayList<>();

        data.add(new News("13 reasons why Rotterdam may be Europe's new capital of cool"));
        data.add(new News("Protests after Netherlands bars Turkish official's plane from landing"));
        data.add(new News("Abuja airport shutdown 'hugely embarrassing'"));
        data.add(new News("Somalia: 'People are dying of hunger'"));
        data.add(new News("Concern over yellow fever outbreak"));
        data.add(new News("Detained DREAMer files petition to go free"));
        data.add(new News("Mexico opens immigrant defense centers"));
        data.add(new News(" Canada: 'Point to prove' after funds cut"));
        data.add(new News("Mark Zuckerberg, Priscilla Chan expecting second baby girl"));
        data.add(new News("Tinder's Sean Rad: App has made 250,000 transgender matches"));
        data.add(new News("California officially embraces the self-driving car"));
        data.add(new News("Cory Booker: We need to love each other"));
        data.add(new News("H-4 visa holder: Working 'changed my life'"));
        data.add(new News("Testing earbuds that translate in real-time"));
        data.add(new News("Experts: 'Vault 7' leak describes common hacks"));
        data.add(new News("Musk offers to fix Australia's energy crisis in 100 days"));
// Get a reference of our RecyclerView from xml
        // It allows us the do things like set the Adapter of the RecyclerView and toggle the
        // visibility

        // GridLayoutManager is responsible for measuring and positioning item views within a RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNewsList.setLayoutManager(layoutManager);


        // Don't change the size of the content
        mNewsList.setHasFixedSize(true);
        int NUM_ITEMS = 100;
        NewsAdapter adapter = new NewsAdapter(getApplicationContext(), NUM_ITEMS, data, this);

        mNewsList.setAdapter(adapter);
    }

    @Override
    public void ChangeStatus(News product) {
        @SuppressLint("InflateParams") final View bootomNavigation = getLayoutInflater().inflate(R.layout.layout_full_screen_dialog, null);

        bottomSheetDialog = new BottomSheetDialog(MainDrawerActivity.this);
        final Toolbar toolbar = bootomNavigation.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_close);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });
        toolbar.setTitle("Notification");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));//for red colored toolbar title
        TextView title = bootomNavigation.findViewById(R.id.title);
        title.setText(product.getNewsTitle());
        bottomSheetDialog.setContentView(bootomNavigation);

        bottomSheetDialog.show();
    }
}


