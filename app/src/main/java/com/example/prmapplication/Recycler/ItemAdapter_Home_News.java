package com.example.prmapplication.Recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prmapplication.Models.News;
import com.example.prmapplication.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter_Home_News extends RecyclerView.Adapter<ItemHolder_Home_News> {

    private List<News> news = new ArrayList<>();

    private Context context;

    private LayoutInflater inflater;

    public ItemAdapter_Home_News(List<News> news, Context context) {
        this.news = news;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NotNull
    @Override
    public ItemHolder_Home_News onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.home_rcv_item, parent, false);
        return new ItemHolder_Home_News(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ItemHolder_Home_News holder, int position) {
        News newItem = news.get(position);
        holder.setData(newItem);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }


}
