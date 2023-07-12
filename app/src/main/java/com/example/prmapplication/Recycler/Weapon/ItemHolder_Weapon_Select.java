package com.example.prmapplication.Recycler.Weapon;

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
import com.example.prmapplication.Fragment.SmallWeapDetailFragment;
import com.example.prmapplication.Fragment.WeapnDetailFragment;
import com.example.prmapplication.Models.Weapon;
import com.example.prmapplication.R;
import org.jetbrains.annotations.NotNull;
public class ItemHolder_Weapon_Select extends RecyclerView.ViewHolder{

    private TextView tvWeaponSelect;
    private ImageView imgWeaponSelect;

    private Weapon weapon;

    private Context context;

    private void bindingViews() {
        tvWeaponSelect = itemView.findViewById(R.id.tvWeaponSelect);
        imgWeaponSelect = itemView.findViewById(R.id.imgWeaponSelect);
    }

    public void setData(Weapon weapon) {
        this.weapon = weapon;
        tvWeaponSelect.setText(weapon.getDisplayName());
        Glide.with(context).load(weapon.getImage()).into(imgWeaponSelect);
    }

    private void bindingAction() {
        itemView.setOnClickListener(this::onWeaponClick);
    }

    private void onWeaponClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("weapon", weapon);

        Fragment fragment = new SmallWeapDetailFragment();
        fragment.setArguments(bundle);

        AppCompatActivity activity = (AppCompatActivity) view.getContext();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerViewWeaponDetail, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public ItemHolder_Weapon_Select(@NonNull @NotNull View itemView) {
        super(itemView);
        this.context = itemView.getContext();
        bindingViews();
        bindingAction();
    }
}
