package com.example.prmapplication.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    private String name;
    private String description;
    private String detail;
    private int imgId;

    public Item(String name, String description, String detail, int imgId) {
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.imgId = imgId;
    }

    protected Item(Parcel in) {
        name = in.readString();
        description = in.readString();
        detail = in.readString();
        imgId = in.readInt();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(detail);
        dest.writeInt(imgId);
    }
}
