package com.example.traveljournal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        View headerView = navigationView.getHeaderView(0);
        TextView tvFullName = headerView.findViewById(R.id.nav_header_full_name);
        TextView tvEmail = headerView.findViewById(R.id.nav_header_email);

        tvFullName.setText("Moisa Andrei");
        tvEmail.setText("andrei.moisa@gmail.com");

        Context context = this;

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
                    Intent intent = new Intent(context, ContactActivity.class);
                    startActivity(intent);
                    finish();
                    return true;
                } else if (id == R.id.nav_share) {
                    // Open the Share dialog
                    // ...
                } else if (id == R.id.nav_logout) {
                    // Logout the user and open the login activity
                    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit();
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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        FloatingActionButton fab = findViewById(R.id.fab_add_journal);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddJournalActivity.class);
                startActivity(intent);
            }
        });

    }
}