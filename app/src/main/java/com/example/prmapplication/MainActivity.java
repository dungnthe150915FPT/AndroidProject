package com.example.prmapplication;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
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

    private void bindingView() {
        fragmentContainerView = findViewById(R.id.fragmentContainerViewMainActivity);
    }

    private void bindingAction() {
        replaceFragment(new HomeFragment());
        setEventBottomNavigation();
    }

    @SuppressLint("NonConstantResourceId")
    private void setEventBottomNavigation() {
        BottomNavigationView bottomNavigation = findViewById(R.id.main_bottom_navigation);
        bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.btnHome:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.btnShop:
                    replaceFragment(new ShopFragment());
                    break;
                case R.id.btnProfile:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });
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