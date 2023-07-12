package com.example.prmapplication.Recycler.Shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prmapplication.Models.Weapon;
import com.example.prmapplication.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter_Shop_Weapon extends RecyclerView.Adapter<ItemHolder_Shop_Weapon>{
    private List<Weapon> weapons = new ArrayList<>();

    private Context context;

    private LayoutInflater inflater;

    public ItemAdapter_Shop_Weapon(List<Weapon> weapons, Context context) {
        this.weapons = weapons;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @NotNull
    @Override
    public ItemHolder_Shop_Weapon onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.shop_weapon_rcv_item, parent, false);
        return new ItemHolder_Shop_Weapon(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ItemHolder_Shop_Weapon holder, int position) {
        Weapon weaponItem = weapons.get(position);
        holder.setData(weaponItem);
    }

    @Override
    public int getItemCount() {
        return weapons.size();
    }
}
