package com.example.prmapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.prmapplication.Models.Item;

import java.util.ArrayList;

public class ItemListFragment extends Fragment {
    private ListView listView;
    private ListAdapter listAdapter;
    private ArrayList<Item> itemsList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemsList = generateItems();
        listAdapter = new ListAdapter(requireContext(), itemsList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        listView = view.findViewById(R.id.listview);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = itemsList.get(position);
                showItemDetail(item);
            }
        });

        return view;
    }

    private void showItemDetail(Item item) {
        ItemDetailFragment itemDetailFragment = ItemDetailFragment.newInstance(item);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, itemDetailFragment)
                .addToBackStack(null)
                .commit();
    }

    private ArrayList<Item> generateItems() {
        int[] imgId = {R.drawable.a1, R.drawable.a1, R.drawable.a2,
                R.drawable.a6, R.drawable.a3, R.drawable.a4, R.drawable.a5};

        String[] name = {"Garena chính thức ra mắt tại Việt Nam", "Garena được cộng đồng đón nhận",
                "Liên Minh Huyền Thoại chính thức ra mắt ở Việt Nam", "DDTank - game bắn súng tọa độ chính thức ra mắt ở Việt Nam",
                "Fifa online 3 chính thức ra mắt ở Việt Nam", "Freefire chính thức ra mắt ở Việt Nam",
                "Liên quân mobile chính thức ra mắt ở Việt Nam"};

        String[] description = {"Garena chính thức ra mắt tại Việt Nam", "Garena được cộng đồng đón nhận",
                "Liên Minh Huyền Thoại chính thức ra mắt ở Việt Nam", "DDTank - game bắn súng tọa độ chính thức ra mắt ở Việt Nam",
                "Fifa online 3 chính thức ra mắt ở Việt Nam", "Freefire chính thức ra mắt ở Việt Nam",
                "Liên quân mobile chính thức ra mắt ở Việt Nam"};

        String[] detail = {"Vào ngày 8/8/2012, tựa game Liên Minh Huyền Thoại chính thức phát hành tại Việt Nam...",
                "Garena được đông đảo cộng đồng đón nhận và thích thú vì nhiều kho game hay và giao diện web bắt mắt",
                "Vào ngày 8/8/2012, tựa game Liên Minh Huyền Thoại chính thức phát hành tại Việt Nam. Khi ấy, đơn vị vận hành và quản lý máy chủ tại server Việt Nam là công ty Garena - một trong những nhà phát hành game lớn tại Việt Nam, thường được giới game thủ biết tới với tên gọi “thân thương” hơn: Gà Rán. Liên Minh Huyền Thoại (LMHT) làm một trong những trò chơi điện tử có cộng đồng người chơi lớn nhất thế giới, có hệ thống giải đấu chuyên nghiệp ở nhiều khu vực địa lý. Tại Việt Nam, trò chơi ấy đã khiến bao thanh thiếu niên mê say, và dưới sự vận hành và chăm sóc của Gà Rán, LMHT đã có một chỗ đứng vững chắc trong lòng cộng đồng game thủ Việt.",
                "Mới đây, trang chủ và hệ thống Garena Platform của Việt Nam vừa chính thức giới thiệu một tựa game mới trên di động. Tựa game này có tên DDTank – một game mobile bắn súng tọa độ được yêu thích nhất trên thế giới. Mặc dù phải cạnh tranh với Gunny Việt, Gunny Trung Quốc thế nhưng trò chơi này vẫn được game thủ Việt tìm đến dù rằng họ phải đi qua cửa “pirate” để chơi. Điều đó đã đủ nói lên sức hút của DDTank với gamer Việt Nam. Và giờ đây chúng ta sẽ được đắm mình trong thế giới của DDTank một cách “đường đường chính chính”.",
                "FIFA Online 3 là một trò chơi bóng đá trực tuyến nhiều người chơi miễn phí được công bố vào ngày 13 tháng 8 năm 2012 và bắt đầu đợt closed beta đầu tiên vào ngày 20 tháng 9 năm 2012 tới 23 tháng 9 năm 2012 tại Hàn Quốc. Vào ngày 18 tháng 12 năm 2012, trò chơi được phát hành tại Hàn Quốc. FIFA Online 3 được phát triển cho máy tính bởi Electronic Arts Seoul Studio dựa trên nền tảng của FIFA 11. Game được phát hành thông qua các thỏa thuận cấp phép tại Hàn Quốc (được xuất bản bởi Nexon), Thái Lan (xuất bản bởi Garena), Indonesia (xuất bản bởi Garena), Việt Nam (xuất bản bởi Garena), Singapore và Malaysia (được xuất bản bởi Garena), Trung Quốc (được xuất bản bởi Tencent). Giao diện và bình luận của mỗi phiên bản đã được dịch thành ngôn ngữ của mỗi quốc gia.",
                "Không ít người chơi muốn biết FF ra mắt khi nào và đa số người chơi đều bị nhầm lẫn thời điểm game phát hành chính thức. Trên thực tế, ban đầu Free Fire được phát hành vào ngày 30 tháng 9 năm 2017 trên nền tảng Android đầu tiên tại Việt Nam với tên gọi Battle Royale Mobile. Đến tháng 11/2017, Garena mới mua lại bản quyền và thử nghiệm trò chơi từ ngày 03/11/2017. Trong giai đoạn này, các máy chủ được mở cho game thủ chơi thử trong vòng 1 tháng, chắc hẳn cũng có nhiều lỗi xảy ra trong trò chơi. Thế nên Garena đã phải cập nhật điều chỉnh, sửa lỗi 2 lần trước khi chính thức phát hành. Ngày 04/12/2017, game Free Fire ra mắt toàn thế giới trên cả hai nền tảng Android lẫn iOS thay vì chỉ 1 như lúc đầu. Vào thời điểm đó, trò chơi đã có hơn 15 bản cập nhật, cho thấy nhà phát triển rất chú trọng đến chất lượng game.",
                "Liên Quân Mobile có tên quốc tế là Arena of Valor là một tựa game trên di dộng thuộc thể loại MOBA, được Timi-J6 Studios cùng Tencent Games phát triển. Tại Việt Nam, Liên Quân Mobile được phát hành bởi Garena Việt Nam, phân phối trên các nền tảng di động Android và iOS. Liên Quân Mobile có nguồn gốc từ trò chơi Vương Giả Vinh Diệu (King of Glory) của Tencent Games phát triển và phát hành tại Trung Quốc. Sau này, Tencent Games đã thay đổi, cải thiện hình ảnh các Tướng trong game và phân phối cho Garena phát hành tại các thị trường: Đài Loan, Việt Nam, Thái Lan sau đó Tencent còn mở rộng ra các thị trường châu Âu, Hoa Kỳ, Nhật Bản... Liên Quân Mobile được tung ra ở Đài Loan vào ngày 14 tháng 10 năm 2016. 1 tháng sau đó, Liên Quân Mobile cũng chính thức được phất hành tại Việt Nam vào ngày 21 tháng 11 năm 2016. Ngày 29 tháng 7 năm 2018 được đánh dấu như là ngày kỷ niệm sinh nhật Liên Quân đầu tiên trên toàn thế giới, đồng thời đây cũng là ngày trận chung kết AWC 2018 diễn ra tại Los Angeles, Hoa Kỳ."};

        ArrayList<Item> itemsList = new ArrayList<>();
        for (int i = 0; i < imgId.length; i++) {
            Item item = new Item(name[i], description[i], detail[i], imgId[i]);
            itemsList.add(item);
        }

        return itemsList;
    }
}
