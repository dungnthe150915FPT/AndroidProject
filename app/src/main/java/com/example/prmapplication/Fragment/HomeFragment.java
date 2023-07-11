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
        if (news.size() > 0) {
            Toast.makeText(getContext(), "Load data success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Load data fail", Toast.LENGTH_SHORT).show();
        }
        ItemAdapter_Home_News itemAdapter_home_news = new ItemAdapter_Home_News(news, getContext());
        rcvHomeNews.setAdapter(itemAdapter_home_news);
    }

    private void onOpenNew(News news) {
        Toast.makeText(getContext(), news.getTitle(), Toast.LENGTH_SHORT).show();
    }

    private void addData() {
        newsDBContext = new NewsDBContext(getContext());
        List<News> newsList = new ArrayList<>();
        newsList.add(new News(
                "Game nuôi mèo \"Duet Cats\" của startup Việt Amanotes đang khuấy đảo thị trường game âm nhạc Mỹ như thế nào?",
                "Duet Cats là thành quả của sự hợp tác giữa Amanotes và Yogame Studio. Chỉ trong vòng một tháng, Duet Cats đã thu hút gần 500.000 lượt tải xuống trên thị trường Mỹ. Con số này tương đương với số lượng tải xuống hàng tháng của những trò chơi được cho là hit game. Mỗi ngày, có đến 33.000 người chơi tham gia chơi trò chơi (daily active user), chứng tỏ sự phổ biến của trò chơi.",
                "2023-03-02",
                "https://cafefcdn.com/thumb_w/640/203337114487263232/2023/3/2/photo1677723353707-1677723353852917527014.jpg",
                "Những đầu tư trong vài năm trở lại đây để hướng đến mục tiêu trở thành hệ sinh thái game âm nhạc hàng đầu thế giới của Amanotes đã có những thành quả ban đầu rất đáng khích lệ. Mới đây, game Duet Cats mà họ hợp tác với Yogame Studio đã ‘phá đảo’ thị trường game âm nhạc ở nước Mỹ.\n"
                        +
                        "\n" +
                        "Yogame Studio được thành lập vào tháng 8/2021, là liên doanh giữa Amanotes và Yotel. Công ty Yotel được thành lập vào năm 2008, hoạt động trong lĩnh vực dịch vụ số gồm: Nội dung số (game); Chuyển đổi số truyền hình; Công nghệ tài chính - Fintech. Yogame là Trung tâm game thuộc công ty Yotel, được thành lập từ 2016. Yogame là đối tác lâu năm với Amanotes."));
        newsList.add(new News(
                "Game online: Làm sao để “kéo” tiền thuế về Việt Nam?",
                "Trong khi các game online ngoại đang “kéo” tiền thuế về nước thì các game online Việt Nam lại đang “kéo” tiền thuế ra nước ngoài. Điều này đang khiến cho ngành công nghiệp game online Việt Nam đang bị thiệt thòi nghiêm trọng.",
                "2023-03-02",
                "https://cafefcdn.com/thumb_w/640/203337114487263232/2023/1/7/photo1673052915746-16730529158461222567544.jpg",
                "Theo thống kê của Cục Phát thanh Truyền hình và Thông tin Điện tử, Bộ Thông tin và Truyền thông, thời gian qua, ngành kinh doanh trò chơi tại Việt Nam tăng trưởng mạnh mẽ. Tại Việt Nam, ước tính có khoảng gần 28,5 triệu người chơi. Năm 2021, tổng doanh thu từ thị trường game Việt đạt khoảng 665 triệu USD, xếp thứ 5 khu vực Đông Nam Á. Doanh thu các trò chơi sản xuất tại Việt Nam phát hành ở thị trường toàn cầu lên đến 200 triệu USD/năm. 50% tựa trò chơi di động được chơi nhiều nhất có nguồn gốc từ Việt Nam, 5/10 công ty trò chơi hàng đầu châu Á - Thái Bình Dương và Australia là của Việt Nam. Tuy nhiên, số tiền đóng thuế cho Nhà nước Việt Nam chỉ chiếm 50%, còn lại là các cá nhân, tổ chức đóng thuế cho nước ngoài, chủ yếu ở Singapore."));
        for (News news2 : newsList) {
            newsDBContext.addNews(news2);
        }
    }
}