package cn.edu.cczu.iot161g2.finalproject;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import cn.edu.cczu.iot161g2.finalproject.fragments.AppBarSearchFragment;
import cn.edu.cczu.iot161g2.finalproject.fragments.AppBarTitleFragment;
import cn.edu.cczu.iot161g2.finalproject.fragments.HomeFragment;
import cn.edu.cczu.iot161g2.finalproject.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        BottomNavigationView navView = findViewById(R.id.bnv_nav_view);
        navView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        navView.setSelectedItemId(R.id.navigation_dict);
    }

    private void switchAppBarFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_app_bar_container, fragment)
                .commit();
    }

    private void switchMainFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_main_container, fragment)
                .commit();
    }

    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_dict:
                switchAppBarFragment(AppBarSearchFragment.newInstance());
                switchMainFragment(HomeFragment.newInstance());
                return true;
            case R.id.navigation_trans:
                switchAppBarFragment(AppBarTitleFragment.newInstance(getString(R.string.title_trans)));
                return true;
            case R.id.navigation_workbook:
                switchAppBarFragment(AppBarTitleFragment.newInstance(getString(R.string.title_wordbook)));
                return true;
            case R.id.navigation_settings:
                switchAppBarFragment(AppBarTitleFragment.newInstance(getString(R.string.title_settings)));
                switchMainFragment(SettingsFragment.newInstance());
                return true;
        }
        return false;
    }
}
