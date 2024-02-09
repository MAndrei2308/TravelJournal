package com.example.traveljournal;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;


import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.widget.Toolbar;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Context context = this;

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Handle navigation view item clicks here.
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    // Open the main activity
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else if (id == R.id.nav_about_us) {
                    Intent intent = new Intent(context, AboutUsActivity.class);
                    startActivity(intent);
                    finish();
                } else if (id == R.id.nav_contact) {
                    // Already in contact activity. Do nothing.
                } else if (id == R.id.nav_share) {
                    // Open the Share dialog
                    // ...
                } else if (id == R.id.nav_logout) {
                    // Logout the user and open the login activity
                    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(ContactActivity.this).edit();
                    editor.clear();
                    editor.apply();

                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(navigationView);
                return true;
            }
        });
    }
}