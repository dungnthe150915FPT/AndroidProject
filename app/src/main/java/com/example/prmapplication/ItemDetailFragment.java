package com.example.prmapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prmapplication.Models.Item;

public class ItemDetailFragment extends Fragment {
    private ImageView imageView;
    private TextView tvItemName;
    private TextView tvDetail;

    private Item item;

    public ItemDetailFragment() {
        // Required empty public constructor
    }

    public static ItemDetailFragment newInstance(Item item) {
        ItemDetailFragment fragment = new ItemDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("item", item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            item = getArguments().getParcelable("item");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);

        imageView = view.findViewById(R.id.imageDetail);
        tvItemName = view.findViewById(R.id.itemNameDetail);
        tvDetail = view.findViewById(R.id.itemDetail);

        if (item != null) {
            imageView.setImageResource(item.getImgId());
            tvItemName.setText(item.getName());
            tvDetail.setText(item.getDetail());
        }

        return view;
    }
}
