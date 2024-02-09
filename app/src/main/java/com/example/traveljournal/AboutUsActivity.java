package com.example.traveljournal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class AboutUsActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        // Setează toolbar-ul
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setează meniul de navigare
        drawerLayout = findViewById(R.id.about_us_drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Context context = this;
        // Setează evenimentul de selectare a elementelor din meniul de navigare
        NavigationView navigationView = findViewById(R.id.nav_view);
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
                    // Already in about us activity. Do nothing.
                } else if (id == R.id.nav_contact) {
                    Intent intent = new Intent(context, ContactActivity.class);
                    startActivity(intent);
                    finish();
                } else if (id == R.id.nav_share) {
                    // Open the Share dialog
                    // ...
                } else if (id == R.id.nav_logout) {
                    // Logout the user and open the login activity
                    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(AboutUsActivity.this).edit();
                    editor.clear();
                    editor.apply();

                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        // Setează lista de membri ai echipei
        ListView teamList = findViewById(R.id.about_us_team_list);
        String[] teamMembers = getResources().getStringArray(R.array.team_members);
        ArrayAdapter<String> teamAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teamMembers);
        teamList.setAdapter(teamAdapter);
    }
}