package com.example.prmapplication.Fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prmapplication.Handler.NewsDBContext;
import com.example.prmapplication.Models.Weapon;
import com.example.prmapplication.R;
import com.example.prmapplication.Recycler.Weapon.ItemAdapter_Weapon_Select;

import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
public class WeapnDetailFragment extends Fragment {

    private FragmentContainerView fragmentContainerViewWeaponDetail;

    private RecyclerView rcvWeaponSelect;

    private void bindingViews(View view) {
        rcvWeaponSelect = view.findViewById(R.id.rcvWeaponSelect);
        rcvWeaponSelect.setLayoutManager(new LinearLayoutManager(view.getContext(),
                LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weapn_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingViews(view);
        loadData(view);
    }

    private void loadData(View view) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            Weapon weapon = (Weapon) bundle.getSerializable("weapon");
            setWeaponDetail(view, weapon);
        }
        loadWeaponSelect(view);
    }

    private void setWeaponDetail(View view, Weapon weapon) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("weapon", weapon);

        Fragment fragment = new SmallWeapDetailFragment();
        fragment.setArguments(bundle);

        AppCompatActivity activity = (AppCompatActivity) view.getContext();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerViewWeaponDetail, fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
    }

    private void loadWeaponSelect(View view) {
        NewsDBContext newsDBContext = new NewsDBContext(view.getContext());
        List<Weapon> weaponsNew = newsDBContext.getAllWeapon();
        ItemAdapter_Weapon_Select itemAdapter_weapon_select = new ItemAdapter_Weapon_Select(weaponsNew, getContext());
        rcvWeaponSelect.setAdapter(itemAdapter_weapon_select);
    }
}