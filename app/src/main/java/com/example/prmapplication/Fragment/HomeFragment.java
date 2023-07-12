package com.example.prmapplication.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prmapplication.Handler.NewsDBContext;
import com.example.prmapplication.Models.DefaultData;
import com.example.prmapplication.Models.News;

import java.util.ArrayList;
import java.util.List;

import com.example.prmapplication.R;
import com.example.prmapplication.Recycler.Home.ItemAdapter_Home_News;

public class HomeFragment extends Fragment {

    private RecyclerView rcvHomeNews;
    private NewsDBContext newsDBContext;

    private void bindingViews(View view) {
        rcvHomeNews = view.findViewById(R.id.rcvHomeNews);
        rcvHomeNews.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // add data
        addData();
        bindingViews(view);
        loadData(view);
    }

    private void loadData(View view) {
        newsDBContext = new NewsDBContext(getContext());
        List<News> news = newsDBContext.getAllNews();
        if (news.size() == 0) {
            Toast.makeText(getContext(), "Load data fail", Toast.LENGTH_SHORT).show();
        }
        ItemAdapter_Home_News itemAdapter_home_news = new ItemAdapter_Home_News(news, getContext());
        rcvHomeNews.setAdapter(itemAdapter_home_news);

        // // delete new have id = 6
        // newsDBContext.deleteNews(6);
    }

    private void onOpenNew(News news) {
        Toast.makeText(getContext(), news.getTitle(), Toast.LENGTH_SHORT).show();
    }

    private void addData() {
        newsDBContext = new NewsDBContext(getContext());
        List<News> newsList = DefaultData.getDefaultNews();
        for (News news2 : newsList) {
            newsDBContext.addNews(news2);
        }
    }
}