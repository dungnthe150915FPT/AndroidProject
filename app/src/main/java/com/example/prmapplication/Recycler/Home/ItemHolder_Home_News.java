package com.example.prmapplication.Recycler.Home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import com.bumptech.glide.Glide;
import com.example.prmapplication.Fragment.ReadNewFragment;
import com.example.prmapplication.Models.News;
import com.example.prmapplication.R;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class ItemHolder_Home_News extends RecyclerView.ViewHolder {

    private TextView txtTitle, txtDescription, txtDate;

    private ImageView imgNews;

    private News newItem;

    private Context context;

    private void bindingView() {
        txtTitle = itemView.findViewById(R.id.txtTitleItemHomeNews);
        txtDescription = itemView.findViewById(R.id.txtDescriptionItemHomeNews);
        txtDate = itemView.findViewById(R.id.txtDateItemHomeNews);
        imgNews = itemView.findViewById(R.id.imgItemHomeNews);
    }

    private void bindingAction() {
        itemView.setOnClickListener(this::onNewsClick);
    }

    private void onNewsClick(View view) {
        Bundle bundle = new Bundle();
        // bundle.putSerializable("news", (Serializable) newItem);
        bundle.putString("title", newItem.getTitle());
        bundle.putString("description", newItem.getDescription());
        bundle.putString("date", newItem.getDate());
        bundle.putString("image", newItem.getImage());
        bundle.putString("content", newItem.getContent());
        Fragment fragment = new ReadNewFragment();
        fragment.setArguments(bundle);

        AppCompatActivity activity = (AppCompatActivity) view.getContext();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerViewMainActivity, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    public ItemHolder_Home_News(@NonNull @NotNull View itemView) {
        super(itemView);
        this.context = itemView.getContext();
        bindingView();
        bindingAction();
    }

    public void setData(News newItem) {
        this.newItem = newItem;
        txtTitle.setText(newItem.getTitle());
        txtDescription.setText(newItem.getDescription());
        txtDate.setText(newItem.getDate());
        Glide.with(context)
                .load(newItem.getImage())
                .fitCenter()
                .into(imgNews);
    }
}
