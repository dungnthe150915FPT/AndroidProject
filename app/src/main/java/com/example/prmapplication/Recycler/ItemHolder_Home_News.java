package com.example.prmapplication.Recycler;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.prmapplication.Models.News;
import com.example.prmapplication.R;
import org.jetbrains.annotations.NotNull;

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
        itemView.setOnClickListener(v -> {
            Toast.makeText(context, "Click on " + newItem.getTitle(), Toast.LENGTH_SHORT).show();
        });
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
        //Glide.with(context).load(newItem.getImage()).into(imgNews);
    }
}
