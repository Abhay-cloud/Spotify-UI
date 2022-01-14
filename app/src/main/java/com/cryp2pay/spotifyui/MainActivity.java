package com.cryp2pay.spotifyui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.cryp2pay.spotifyui.fragments.HomeFragment;
import com.cryp2pay.spotifyui.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bottomNavigationView = findViewById(R.id.bottomNev);
        bottomNavigationView.setOnItemSelectedListener(itemSelectedListener);
        frameLayout = findViewById(R.id.frameLayout);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment())
                .commit();

    }

   private NavigationBarView.OnItemSelectedListener itemSelectedListener = new NavigationBarView.OnItemSelectedListener() {
       @Override
       public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
           Fragment fragment = null;
            switch (id) {
                case R.id.homeNev:
                    fragment = new HomeFragment();
                    break;
                case R.id.searchNev:
                    fragment = new SearchFragment();
                    break;

            }

           getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment)
                   .commit();

           return true;
       }
   };
}