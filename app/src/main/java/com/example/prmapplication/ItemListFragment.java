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
                "Fifa online 4 chính thức ra mắt ở Việt Nam", "Freefire chính thức ra mắt ở Việt Nam",
                "Liên quân mobile chính thức ra mắt ở Việt Nam"};

        String[] description = {"Garena chính thức ra mắt tại Việt Nam", "Garena được cộng đồng đón nhận",
                "Liên Minh Huyền Thoại chính thức ra mắt ở Việt Nam", "DDTank - game bắn súng tọa độ chính thức ra mắt ở Việt Nam",
                "Fifa online 4 chính thức ra mắt ở Việt Nam", "Freefire chính thức ra mắt ở Việt Nam",
                "Liên quân mobile chính thức ra mắt ở Việt Nam"};

        String[] detail = {"Vào ngày 8/8/2012, tựa game Liên Minh Huyền Thoại chính thức phát hành tại Việt Nam...",
                "Garena được đông đảo cộng đồng đón nhận và thích thú vì nhiều kho game hay và giao diện web bắt mắt...",
                "Vào ngày 8/8/2012, tựa game Liên Minh Huyền Thoại chính thức phát hành tại Việt Nam...",
                "Mới đây, trang chủ và hệ thống Garena Platform của Việt Nam vừa chính thức giới thiệu một tựa game mới trên di động...",
                "Trong buổi họp báo sáng ngày 7/6, NPH Garena đã công bố ngày ra mắt chính thức của FIFA ONLINE 4 tại Việt Nam...",
                "Không ít người chơi muốn biết FF ra mắt khi nào và đa số người chơi đều bị nhầm lẫn thời điểm game phát hành chính thức...",
                "Liên Quân Mobile có tên quốc tế là Arena of Valor là một tựa game trên di dộng thuộc thể loại MOBA..."};

        ArrayList<Item> itemsList = new ArrayList<>();
        for (int i = 0; i < imgId.length; i++) {
            Item item = new Item(name[i], description[i], detail[i], imgId[i]);
            itemsList.add(item);
        }

        return itemsList;
    }
}
