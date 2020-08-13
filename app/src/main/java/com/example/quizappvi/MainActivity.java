package com.example.quizappvi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.quizappvi.adapters.MainPagerAdapter;
import com.example.quizappvi.ui.fragments.MainFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView navigationView;

    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.main_pager);

     navigationView=findViewById(R.id.navigView);

        NavigationViewPager();

    }






    private void NavigationViewPager() {




        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));


        viewPager.setOffscreenPageLimit(2);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.MainFragmentM:
                        viewPager.setCurrentItem(0,false);
                        break;
                    case R.id.HistoryFragmentM:
                        viewPager.setCurrentItem(1,false);
                        break;
                        case R.id.SettingsFragment:
                        viewPager.setCurrentItem(2,false);
                        break;



                }
                return true;
            }





        });
    }



}