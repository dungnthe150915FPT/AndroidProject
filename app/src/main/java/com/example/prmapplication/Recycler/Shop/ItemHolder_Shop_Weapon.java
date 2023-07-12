package com.example.prmapplication.Recycler.Shop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.prmapplication.Fragment.WeapnDetailFragment;
import com.example.prmapplication.Models.Weapon;
import com.example.prmapplication.R;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class ItemHolder_Shop_Weapon extends RecyclerView.ViewHolder {

    private TextView tvDisplayName, tvDescription, tvPrice;

    private ImageView imgWeapon;

    private Weapon weapon;

    private Context context;

    private void bindingViews() {
        tvDisplayName = itemView.findViewById(R.id.tvDisplayName);
        tvDescription = itemView.findViewById(R.id.tvDescription);
        tvPrice = itemView.findViewById(R.id.tvPrice);
        imgWeapon = itemView.findViewById(R.id.imgWeapon);
    }

    public void setData(Weapon weapon) {
        this.weapon = weapon;
        tvDisplayName.setText(weapon.getDisplayName());
        tvDescription.setText(weapon.getDescription());
        String price = "$" + String.valueOf(weapon.getPrice());
        tvPrice.setText(price);
        Glide.with(context).load(weapon.getImage()).into(imgWeapon);
    }

    private void bindingAction() {
        itemView.setOnClickListener(this::onWeaponClick);
    }

    private void onWeaponClick(View view) {
        Toast.makeText(context, "Weapon: " + weapon.getDisplayName(), Toast.LENGTH_SHORT).show();

        Bundle bundle = new Bundle();
        bundle.putSerializable("weapon", weapon);

        Fragment fragment = new WeapnDetailFragment();
        fragment.setArguments(bundle);

        AppCompatActivity activity = (AppCompatActivity) view.getContext();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerViewMainActivity, fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
    }

    public ItemHolder_Shop_Weapon(@NonNull @NotNull View itemView) {
        super(itemView);
        this.context = itemView.getContext();
        bindingViews();
        bindingAction();
    }
}
