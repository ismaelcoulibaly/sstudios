package com.sstudios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.sstudios.navigation.HomeFragment;
import com.sstudios.navigation.MessagesFragment;
import com.sstudios.navigation.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sstudios.navigation.HomeFragment;
import com.sstudios.navigation.MessagesFragment;
import com.sstudios.navigation.SearchFragment;

public class MainActivity extends AppCompatActivity {

    //bottom navbar instantiated
    MeowBottomNavigation bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationBar);

        bottomNavigationView.add(new MeowBottomNavigation.Model(1, R.drawable.home_icon));
        bottomNavigationView.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_search_24));
        bottomNavigationView.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_textsms_24));

        bottomNavigationView.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment selectedFragment = null;

                switch(item.getId()){
                    case 1:
                        selectedFragment = new HomeFragment();
                        break;

                    case 2:
                        selectedFragment = new SearchFragment();
                        break;

                    case 3:
                        selectedFragment = new MessagesFragment();
                        break;
                }
                loadFragment(selectedFragment);
            }
        });

        //set notification count
        bottomNavigationView.setCount(1, "10");
        bottomNavigationView.setCount(3, "10");

        bottomNavigationView.show(1, true);

        bottomNavigationView.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
            }
        });

        bottomNavigationView.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
            }
        });

    }

    private void loadFragment(Fragment selectedFragment) {
        //Replace fragement
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, selectedFragment)
                .commit();
    }


}