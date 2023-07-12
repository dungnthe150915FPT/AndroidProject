package com.example.prmapplication;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.Glide;
import com.example.prmapplication.Fragment.HomeFragment;
import com.example.prmapplication.Fragment.ProfileFragment;
import com.example.prmapplication.Fragment.ShopFragment;
import com.example.prmapplication.Fragment.WelcomeFragment;
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
        Intent launchIntent = getPackageManager()
                .getLaunchIntentForPackage(packageName);
        if (launchIntent != null) {
            rotationDevice();
            startActivity(launchIntent);
        } else {
            Toast.makeText(this, "Download game...",
                    Toast.LENGTH_LONG).show();
            openLink();
        }
    }

    private void openLink() {
        String url = "https://drive.google.com/drive/folders/1fYJ4Z4SYziEYgxhwRvFScg4hPKsSBV1s";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setPackage("com.android.chrome");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            intent.setPackage(null);
            startActivity(intent);
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
        openDialog();
    }

    @SuppressLint("SetTextI18n")
    private void openDialog() {
        replaceFragment(new WelcomeFragment());
        // replace to HomeFragment after 2s
        new Handler().postDelayed(() -> {
            replaceFragment(new HomeFragment());
            tvNameFragment.setText("Home");
        }, 2500);
    }

}