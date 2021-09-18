package com.sstudios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.sstudios.navigation.HomeFragment;
import com.sstudios.navigation.AddFragment;
import com.sstudios.navigation.LikesFragment;
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
        bottomNavigationView.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_add_24));
        bottomNavigationView.add(new MeowBottomNavigation.Model(4, R.drawable.ic_baseline_likes));

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
                        selectedFragment = new AddFragment();
                        break;

                    case 4:
                        selectedFragment = new LikesFragment();
                }
                loadFragment(selectedFragment);
            }
        });

        //set notification count
        bottomNavigationView.setCount(1, "7");
        bottomNavigationView.show(1, true);
        bottomNavigationView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), android.R.color.transparent));
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