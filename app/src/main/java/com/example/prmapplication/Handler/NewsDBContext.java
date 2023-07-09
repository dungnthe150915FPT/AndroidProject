package com.example.prmapplication.Handler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.prmapplication.Models.News;

import androidx.annotation.Nullable;

import java.util.List;

public class NewsDBContext extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Sakura";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NEWS = "News";
    private static final String NEWS_KEY_ID = "id";
    private static final String NEWS_KEY_TITLE = "title";
    private static final String NEWS_KEY_DESCRIPTION = "description";
    private static final String NEWS_KEY_DATE = "date";
    private static final String NEWS_KEY_IMAGE = "image";
    private static final String NEWS_KEY_CONTENT = "content";
    private static final String CREATE_NEWS_DB = "CREATE TABLE " + TABLE_NEWS + "("
            + NEWS_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NEWS_KEY_TITLE + " TEXT,"
            + NEWS_KEY_DESCRIPTION + " TEXT,"
            + NEWS_KEY_DATE + " TEXT,"
            + NEWS_KEY_IMAGE + " TEXT,"
            + NEWS_KEY_CONTENT + " TEXT" + ")";
    public NewsDBContext(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NEWS_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NEWS);
        // create table again
        onCreate(db);
    }

    // check duplicate news
    public Boolean checkDuplicateNews(String title) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NEWS + " WHERE " + NEWS_KEY_TITLE + " = '" + title + "'";
        @SuppressLint("Recycle") android.database.Cursor cursor = db.rawQuery(query, null);
        return cursor.getCount() > 0;
    }

    // CRUD operations with News table
    public Boolean addNews(com.example.prmapplication.Models.News news) {
        if (checkDuplicateNews(news.getTitle())) {
            return false;
        }
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO " + TABLE_NEWS + " (" + NEWS_KEY_TITLE + ", " + NEWS_KEY_DESCRIPTION + ", "
                + NEWS_KEY_DATE + ", " + NEWS_KEY_IMAGE + ", " + NEWS_KEY_CONTENT + ") VALUES ('" + news.getTitle() + "', '"
                + news.getDescription() + "', '" + news.getDate() + "', '" + news.getImage() + "', '" + news.getContent() + "')");
        return true;
    }

    public Boolean updateNews(com.example.prmapplication.Models.News news) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_NEWS + " SET " + NEWS_KEY_TITLE + " = '" + news.getTitle() + "', "
                + NEWS_KEY_DESCRIPTION + " = '" + news.getDescription() + "', " + NEWS_KEY_DATE + " = '" + news.getDate() + "', "
                + NEWS_KEY_IMAGE + " = '" + news.getImage() + "', " + NEWS_KEY_CONTENT + " = '" + news.getContent() + "' WHERE "
                + NEWS_KEY_ID + " = " + news.getId());
        return true;
    }

    public Boolean deleteNews(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NEWS + " WHERE " + NEWS_KEY_ID + " = " + id);
        return true;
    }

    public News getNews(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NEWS + " WHERE " + NEWS_KEY_ID + " = " + id;
        @SuppressLint("Recycle") android.database.Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        assert cursor != null;
        return new com.example.prmapplication.Models.News(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5));
    }

    public List<News> getAllNews() {
        java.util.List<com.example.prmapplication.Models.News> newsList = new java.util.ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NEWS;
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") android.database.Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                com.example.prmapplication.Models.News news = new com.example.prmapplication.Models.News();
                news.setId(cursor.getInt(0));
                news.setTitle(cursor.getString(1));
                news.setDescription(cursor.getString(2));
                news.setDate(cursor.getString(3));
                news.setImage(cursor.getString(4));
                news.setContent(cursor.getString(5));
                newsList.add(news);
            } while (cursor.moveToNext());
        }
        return newsList;
    }

    public News getNewsById(int i) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NEWS + " WHERE " + NEWS_KEY_ID + " = " + i;
        @SuppressLint("Recycle") android.database.Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        assert cursor != null;
        return new com.example.prmapplication.Models.News(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5));
    }
}
