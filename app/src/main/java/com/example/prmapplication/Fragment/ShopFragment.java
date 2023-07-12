package com.example.prmapplication.Fragment;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prmapplication.Handler.NewsDBContext;
import com.example.prmapplication.MainActivity;
import com.example.prmapplication.Models.DefaultData;
import com.example.prmapplication.Models.Weapon;
import com.example.prmapplication.R;
import com.example.prmapplication.Recycler.Shop.ItemAdapter_Shop_Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShopFragment extends Fragment {
    private RecyclerView rcvShopWeapon;

    private Button btnOpenGame;

    private void bindingViews(View view) {
        rcvShopWeapon = view.findViewById(R.id.rcvShopWeapon);
        rcvShopWeapon.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    private void bindingActions() {
    }

    private void btnOpenGameOnClick(View view) {
        // Intent launchIntent = requireActivity().getPackageManager()
        // .getLaunchIntentForPackage("com.google.android.youtube");
        // if (launchIntent != null) {
        // startActivity(launchIntent);// null pointer check in case package name was
        // not found
        // } else {
        // Toast.makeText(getContext(), "There is no package available in android",
        // Toast.LENGTH_LONG).show();
        // }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // add data
        addData(view);
        bindingViews(view);
        loadData(view);
    }

    private NewsDBContext newsDBContext;

    private void addData(View view) {
        List<Weapon> weaponsNew = DefaultData.getDefaultWeapon();
        newsDBContext = new NewsDBContext(view.getContext());
        for (Weapon weapon : weaponsNew) {
            newsDBContext.addWeapon(weapon);
        }
    }

    private void loadData(View view) {
        newsDBContext = new NewsDBContext(view.getContext());
        List<Weapon> weaponsNew = newsDBContext.getAllWeapon();
        ItemAdapter_Shop_Weapon itemAdapter_shop_weapon = new ItemAdapter_Shop_Weapon(weaponsNew, getContext());
        rcvShopWeapon.setAdapter(itemAdapter_shop_weapon);
    }
}