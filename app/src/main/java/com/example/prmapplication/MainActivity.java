package com.example.prmapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.example.prmapplication.Fragment.HomeFragment;
import com.example.prmapplication.Fragment.ProfileFragment;
import com.example.prmapplication.Fragment.ShopFragment;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FragmentContainerView fragmentContainerView;

    private HomeFragment homeFragment;
    private ShopFragment shopFragment;
    private ProfileFragment profileFragment;

    private TextView tvNameFragment;

    private void bindingView() {
        fragmentContainerView = findViewById(R.id.fragmentContainerViewMainActivity);
        tvNameFragment = findViewById(R.id.tvNameFragment);
    }

    private void bindingAction() {
        replaceFragment(new HomeFragment());
        setEventBottomNavigation();
    }

    @SuppressLint({ "NonConstantResourceId", "SetTextI18n" })
    private void setEventBottomNavigation() {
        BottomNavigationView bottomNavigation = findViewById(R.id.main_bottom_navigation);
        bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.btnHome:
                    replaceFragment(new HomeFragment());
                    tvNameFragment.setText("Home");
                    break;
                case R.id.btnShop:
                    replaceFragment(new ShopFragment());
                    tvNameFragment.setText("Shop");
                    break;
                case R.id.btnProfile:
                    replaceFragment(new ProfileFragment());
                    tvNameFragment.setText("Profile");
                    break;
                case R.id.btnPlayGame:
                    openApp();
                    break;
            }
            return true;
        });
    }

    public void openApp() {
        String packageName = "com.google.PRUU.ProjectA";
        // String packageName = "com.google.android.youtube";
        Intent launchIntent = getPackageManager()
                .getLaunchIntentForPackage(packageName);
        if (launchIntent != null) {
            rotationDevice();
            startActivity(launchIntent);
        } else {
            Toast.makeText(this, "There is no package available in android " + packageName,
                    Toast.LENGTH_LONG).show();
        }
    }

    private void rotationDevice() {
        // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerViewMainActivity, fragment);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindingView();
        bindingAction();
    }

}