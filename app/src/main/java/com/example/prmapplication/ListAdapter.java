package com.example.prmapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.prmapplication.Models.Item;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Item> {
    private Context context;

    public ListAdapter(Context context, ArrayList<Item> itemsArrayList) {
        super(context, R.layout.list_item, itemsArrayList);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Item item = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageItem);
        TextView tvItemName = convertView.findViewById(R.id.itemName);

        if (item != null) {
            imageView.setImageResource(item.getImgId());
            tvItemName.setText(item.getName());
        }

        return convertView;
    }
}
