package com.example.introapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    BottomAppBar bar;
    private BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //This will initialize the BottomAppBar
        bar = findViewById(R.id.appbar);

        //This will add the OptionMenu to BottomAppBar
        bar.replaceMenu(R.menu.bottom_appbar_menu_primary);

        //This will handle the onClick Action for the menu item
        bar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.like:
                        Toast.makeText(MainActivity.this, "Like Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.search:
                        Toast.makeText(MainActivity.this, "Search Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings:
                        Toast.makeText(MainActivity.this, "Settings Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.profile:
                        Toast.makeText(MainActivity.this, "Logout Clicked", Toast.LENGTH_SHORT).show();
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
                //    Toast.makeText(MainActivity.this,"Floating Action Button Clicked",Toast.LENGTH_SHORT).show();
                //   openNavigationMenu();
                @SuppressLint("InflateParams") final View bootomNavigation = getLayoutInflater().inflate(R.layout.customdialog, null);
                bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
                bottomSheetDialog.setContentView(bootomNavigation);
                bottomSheetDialog.show();
            }
        });
    }

    private void openNavigationMenu() {

        //this will get the menu layout
        @SuppressLint("InflateParams") final View bootomNavigation = getLayoutInflater().inflate(R.layout.navigation_menu, null);
        bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
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
                        Toast.makeText(MainActivity.this, "Item 1 Clicked", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        break;
                    case R.id.item2:
                        Toast.makeText(MainActivity.this, "Item 2 Clicked", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        break;
                    case R.id.item3:
                        Toast.makeText(MainActivity.this, "Item 3 Clicked", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        break;
                    case R.id.item4:
                        Toast.makeText(MainActivity.this, "Item 4 Clicked", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        break;
                }
                return false;
            }
        });


    }
}