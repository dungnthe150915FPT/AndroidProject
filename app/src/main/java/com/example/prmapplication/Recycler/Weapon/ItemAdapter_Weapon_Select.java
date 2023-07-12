package com.example.prmapplication.Recycler.Weapon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prmapplication.Models.Weapon;
import org.jetbrains.annotations.NotNull;
import com.example.prmapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter_Weapon_Select extends RecyclerView.Adapter<ItemHolder_Weapon_Select>{
    private List<Weapon> weapons = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public ItemAdapter_Weapon_Select(List<Weapon> weapons,Context context) {
        this.context = context;
        this.weapons = weapons;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ItemHolder_Weapon_Select holder, int position) {
        Weapon weaponItem = weapons.get(position);
        holder.setData(weaponItem);
    }


    @NonNull
    @NotNull
    @Override
    public ItemHolder_Weapon_Select onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.weapon_select_rcv_item, parent, false);
        return new ItemHolder_Weapon_Select(view);
    }

    @Override
    public int getItemCount() {
        return weapons.size();
    }
}
