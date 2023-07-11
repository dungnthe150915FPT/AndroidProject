package com.example.prmapplication.Recycler.Shop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.prmapplication.Models.Weapon;
import com.example.prmapplication.R;
import org.jetbrains.annotations.NotNull;

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
        tvPrice.setText(String.valueOf(weapon.getPrice()));
        Glide.with(context).load(weapon.getImage()).into(imgWeapon);
    }

    private void bindingAction() {
        itemView.setOnClickListener(this::onWeaponClick);
    }

    private void onWeaponClick(View view) {
        Toast.makeText(context, "Weapon: " + weapon.getDisplayName(), Toast.LENGTH_SHORT).show();
    }

    public ItemHolder_Shop_Weapon(@NonNull @NotNull View itemView) {
        super(itemView);
        this.context = itemView.getContext();
        bindingViews();
        bindingAction();
    }
}
