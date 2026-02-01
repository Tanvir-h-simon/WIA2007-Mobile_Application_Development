package com.example.buttomnavigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView btnNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNavigationView = findViewById(R.id.bottom_navigation);

        // Load initial fragment
        loadFrag(new HomeFragment());

        btnNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.home) {
                    loadFrag(new HomeFragment());
                } else if (id == R.id.search) {
                    loadFrag(new SearchFragment());
                } else if (id == R.id.settings) {
                    loadFrag(new SettingsFragment());
                } else if (id == R.id.profile) {
                    loadFrag(new ProfileFragment());
                } else if (id == R.id.notifications) {
                    loadFrag(new NotificationsFragment());
                }
                return true;
            }
        });
    }

    public void loadFrag(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();
    }
}