package com.example.bottomappbar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
Created by Shubhankar Mahajan
follow me on github : https://github.com/SmTech-Developers
 */

public class MainActivity extends AppCompatActivity {

    private BottomSheetDialog bottomSheetDialog;
    private FloatingActionButton floatingActionButton;
    BottomAppBar bottomAppBar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomAppBar = findViewById(R.id.bottom_appbar);
        button = findViewById(R.id.btn);
        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Fab Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        bottomAppBar.replaceMenu(R.menu.menu);

        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.menu_setting:
                        Toast.makeText(MainActivity.this, "Setting Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_refresh:
                        Toast.makeText(MainActivity.this, "Refreshed", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_rate:
                        Toast.makeText(MainActivity.this, "Rate Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_policy:
                        Toast.makeText(MainActivity.this, "Policy Clicked", Toast.LENGTH_SHORT).show();
                        break;


                }
                return false;
            }
        });

        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNavigationMenu();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bottomAppBar.getFabAlignmentMode() == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)
                    bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
                else {
                    bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
                }
            }
        });

    }

    private void openNavigationMenu() {
        final View bottomNavigation = getLayoutInflater().inflate(R.layout.navigation_menu, null);
        bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        bottomSheetDialog.setContentView(bottomNavigation);
        bottomSheetDialog.show();

        NavigationView navigationView = bottomNavigation.findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.navMenu1:
                        Toast.makeText(MainActivity.this, "Menu 1 Clicked", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        break;
                    case R.id.navMenu2:
                        Toast.makeText(MainActivity.this, "Menu 2 Clicked", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        break;
                    case R.id.navMenu3:
                        Toast.makeText(MainActivity.this, "Menu 3 Clicked", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        break;
                    case R.id.navMenu4:
                        Toast.makeText(MainActivity.this, "Menu 4 Clicked", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        break;
                }

                return false;
            }
        });

    }


}