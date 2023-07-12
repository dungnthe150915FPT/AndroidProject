package com.example.prmapplication.Fragment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.prmapplication.Handler.NewsDBContext;
import com.example.prmapplication.Models.Weapon;
import com.example.prmapplication.R;
import com.example.prmapplication.Recycler.Shop.ItemAdapter_Shop_Weapon;
import com.example.prmapplication.Recycler.Weapon.ItemAdapter_Weapon_Select;

import java.util.List;

public class SmallWeapDetailFragment extends Fragment {
    private TextView tvWeaponNameDetail, tvWeaponDesDetail, tvWeaponDetailType, tvWeaponDetailFireMode;
    private ProgressBar prgBarFireRate, prgBarDamage, prgBarAmmo, prgBarBSpeed;
    private Button btnBuyWeapon;

    private ImageView imgWeaponDetail;

    private void bindingViews(View view) {
        tvWeaponNameDetail = view.findViewById(R.id.tvWeaponNameDetail);
        tvWeaponDesDetail = view.findViewById(R.id.tvWeaponDesDetail);
        tvWeaponDetailType = view.findViewById(R.id.tvWeaponDetailType);
        tvWeaponDetailFireMode = view.findViewById(R.id.tvWeaponDetailFireMode);
        prgBarFireRate = view.findViewById(R.id.prgBarFireRate);
        prgBarDamage = view.findViewById(R.id.prgBarDamage);
        prgBarAmmo = view.findViewById(R.id.prgBarAmmo);
        prgBarBSpeed = view.findViewById(R.id.prgBarBSpeed);
        btnBuyWeapon = view.findViewById(R.id.btnBuyWeapon);
        imgWeaponDetail = view.findViewById(R.id.imgWeaponDetail);
    }

    private void setWeaponDetail() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            Weapon weapon = (Weapon) bundle.getSerializable("weapon");
            tvWeaponNameDetail.setText(weapon.getDisplayName());
            tvWeaponDesDetail.setText(weapon.getDescription());
            tvWeaponDetailType.setText(weapon.getType());
            tvWeaponDetailFireMode.setText(weapon.getFireMode());
            prgBarFireRate.setProgress(Integer.parseInt(weapon.getFireRate()));
            prgBarDamage.setProgress(Integer.parseInt(weapon.getDamage()));
            prgBarAmmo.setProgress(Integer.parseInt(weapon.getAmmo()));
            prgBarBSpeed.setProgress(Integer.parseInt(weapon.getBulletSpeed()));
            // uding Glide to load image
            Glide.with(this).load(weapon.getImage()).into(imgWeaponDetail);
        }
    }

    private void bindingAction(View view) {
        btnBuyWeapon.setOnClickListener(this::buyWeapon);
    }

    private void buyWeapon(View view) {

    }
   
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_small_weap_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingViews(view);
        bindingAction(view);
        loadData(view);
    }

    private void loadData(View view) {
        setWeaponDetail();
    }
}