package com.example.prmapplication.Fragment;

import android.os.Bundle;
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
import com.example.prmapplication.Models.News;

import java.util.List;

import com.example.prmapplication.R;
import com.example.prmapplication.Recycler.ItemAdapter_Home_News;

public class HomeFragment extends Fragment {

    private RecyclerView rcvHomeNews;
    private NewsDBContext newsDBContext;

    private  void bindingViews(View view){
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
        if(news.size() > 0){
            Toast.makeText(getContext(), "Load data success", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getContext(), "Load data fail", Toast.LENGTH_SHORT).show();
        }
        // set adapter
        ItemAdapter_Home_News itemAdapter_home_news = new ItemAdapter_Home_News(news, getContext());
        rcvHomeNews.setAdapter(itemAdapter_home_news);
    }

    private void addData(){
                // News news = new News();
        // news.setTitle("TitleTest");
        // news.setDescription("DescriptionTest");
        // news.setDate("DateTest");
        // news.setImage("ImageTest");
        // news.setContent("ContentTest");
        // add news to database
        // newsDBContext = new NewsDBContext(getContext());
        // newsDBContext.addNews(news);

//        newsDBContext = new NewsDBContext(getContext());
//        // update news to database
//        News news = newsDBContext.getNewsById(1);
//        // real data to news
//        news.setTitle("Thị trường game Việt đặt mục tiêu tỷ USD");
//        news.setDescription("Tại Diễn đàn Game Việt 2023, đại diện Bộ Thông tin và Truyền thông cho biết Bộ đặt kế hoạch sau 5 năm, doanh thu ngành game tăng từ 600 triệu USD lên một tỷ USD.");
//        news.setDate("2023-04-01");
//        news.setImage("https://upcdn.io/FW25bVU/raw/7777-jpeg-1680327297-8997-1680327305.jpg");
//        news.setContent("Ông Antoine Brochet nói, khi một nhà phát triển game nghĩ đến việc thâm nhập thị trường mới, điều quan trọng là họ phải hiểu những đặc điểm độc đáo của thị trường (về hành vi người dùng, thói quen chi tiêu, văn hóa, ngôn ngữ, chiến thuật kinh doanh). Đi cùng, đơn vị phải tìm hiểu xem những thị trường nào khác có chung những đặc điểm đó. Những kiến thức họ có về những đặc điểm này sẽ giúp họ có lợi thế khi thâm nhập vào những thị trường mới đó.");
//        newsDBContext.updateNews(news);
    }
}