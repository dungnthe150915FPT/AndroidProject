package com.example.prmapplication.Fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.example.prmapplication.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Objects;

public class ReadNewFragment extends Fragment {

    private TextView tvTitle, tvContent, tvDate, tvDescription;

    private ImageView imgNew;

    private void bindingViews(View view) {
        // tvTitle = view.findViewById(R.id.tvTitle);
        tvContent = view.findViewById(R.id.textContent);
        // tvDate = view.findViewById(R.id.tvDate);
        // tvDescription = view.findViewById(R.id.tvDescription);
        // imgNew = view.findViewById(R.id.imgNew);
    }

    private String title;
    private String content;
    private String image;
    private String date;
    private String description;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            title = bundle.getString("title");
            content = bundle.getString("content");
            image = bundle.getString("image");
            date = bundle.getString("date");
            description = bundle.getString("description");
        }
        return inflater.inflate(R.layout.fragment_read_new, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingViews(view);
        loadData();
    }

    private void loadData() {
        // bold title with <b> tag
        String stringBuilder = "<b>" + title + "</b>" + "<br>" +
                "<p>" + description + "</p>" +
                "<p>" + content + "</p>" +
                "<img src=\"" + image + "\"/>" +
                "<p>" + date + "</p>";
        tvContent.setText(Html.fromHtml(stringBuilder));
        // set drawable top compat for textview content
        //tvContent.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_baseline_arrow_drop_down_24, 0, 0);


        // tvTitle.setText(title);
        //tvContent.setText(content);
        // tvDate.setText(date);
        // tvDescription.setText(description);
        // imgNew.setImageResource(image);
    }



}