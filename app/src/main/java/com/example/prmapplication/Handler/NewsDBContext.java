package com.example.prmapplication.Handler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.prmapplication.Models.News;

import androidx.annotation.Nullable;
import com.example.prmapplication.Models.Weapon;

import java.util.ArrayList;
import java.util.List;

public class NewsDBContext extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Sakuraa";
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

    private static final String TABLE_WEAPON = "Weapon";
    private static final String COLUMN_WEAPON_ID = "id";
    private static final String COLUMN_WEAPON_DISPLAYNAME = "displayName";
    private static final String COLUMN_WEAPON_DESCRIPTION = "description";
    private static final String COLUMN_WEAPON_IMAGE = "image";
    private static final String COLUMN_WEAPON_FIRERATE = "fireRate";
    private static final String COLUMN_WEAPON_DAMAGE = "damage";
    private static final String COLUMN_WEAPON_AMMO = "ammo";
    private static final String COLUMN_WEAPON_RELOADTIME = "reloadTime";
    private static final String COLUMN_WEAPON_BULLETSPEED = "bulletSpeed";
    private static final String COLUMN_WEAPON_TYPE = "type";
    private static final String COLUMN_WEAPON_FIREMODE = "fireMode";
    private static final String COLUMN_WEAPON_PRICE = "price";

    private static final String CREATE_WEAPON_DB = "CREATE TABLE " + TABLE_WEAPON + "("
            + COLUMN_WEAPON_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_WEAPON_DISPLAYNAME + " TEXT,"
            + COLUMN_WEAPON_DESCRIPTION + " TEXT,"
            + COLUMN_WEAPON_IMAGE + " TEXT,"
            + COLUMN_WEAPON_FIRERATE + " TEXT,"
            + COLUMN_WEAPON_DAMAGE + " TEXT,"
            + COLUMN_WEAPON_AMMO + " TEXT,"
            + COLUMN_WEAPON_RELOADTIME + " TEXT,"
            + COLUMN_WEAPON_BULLETSPEED + " TEXT,"
            + COLUMN_WEAPON_TYPE + " TEXT,"
            + COLUMN_WEAPON_FIREMODE + " TEXT,"
            + COLUMN_WEAPON_PRICE + " TEXT" + ")";

    public NewsDBContext(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NEWS_DB);
        db.execSQL(CREATE_WEAPON_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NEWS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WEAPON);
        onCreate(db);
    }

    // check duplicate news
    public Boolean checkDuplicateNews(String title) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NEWS + " WHERE " + NEWS_KEY_TITLE + " = '" + title + "'";
        @SuppressLint("Recycle")
        android.database.Cursor cursor = db.rawQuery(query, null);
        return cursor.getCount() > 0;
    }

    // CRUD operations with News table
    public void addNews(News news) {
        if (checkDuplicateNews(news.getTitle())) {
            return;
        }
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO " + TABLE_NEWS + " (" + NEWS_KEY_TITLE + ", " + NEWS_KEY_DESCRIPTION + ", "
                + NEWS_KEY_DATE + ", " + NEWS_KEY_IMAGE + ", " + NEWS_KEY_CONTENT + ") VALUES ('" + news.getTitle()
                + "', '"
                + news.getDescription() + "', '" + news.getDate() + "', '" + news.getImage() + "', '"
                + news.getContent() + "')");
    }

    public Boolean updateNews(com.example.prmapplication.Models.News news) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_NEWS + " SET " + NEWS_KEY_TITLE + " = '" + news.getTitle() + "', "
                + NEWS_KEY_DESCRIPTION + " = '" + news.getDescription() + "', " + NEWS_KEY_DATE + " = '"
                + news.getDate() + "', "
                + NEWS_KEY_IMAGE + " = '" + news.getImage() + "', " + NEWS_KEY_CONTENT + " = '" + news.getContent()
                + "' WHERE "
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
        @SuppressLint("Recycle")
        android.database.Cursor cursor = db.rawQuery(query, null);
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
        @SuppressLint("Recycle")
        android.database.Cursor cursor = db.rawQuery(query, null);
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
         db.close();
        return newsList;
    }

    public News getNewsById(int i) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NEWS + " WHERE " + NEWS_KEY_ID + " = " + i;
        @SuppressLint("Recycle")
        android.database.Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        assert cursor != null;
        return new com.example.prmapplication.Models.News(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5));
    }

    // get all table in database to list
    @SuppressLint("Range")
    public List<String> getAllTable() {
        List<String> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                list.add(cursor.getString(cursor.getColumnIndex("name")));
                cursor.moveToNext();
            }
        }
        return list;
    }

    // check duplicate weapon
    public Boolean checkDuplicateWeapon(String displayName) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_WEAPON + " WHERE " + COLUMN_WEAPON_DISPLAYNAME + " = '" + displayName
                + "'";
        @SuppressLint("Recycle")
        android.database.Cursor cursor = db.rawQuery(query, null);
        return cursor.getCount() > 0;
    }

    public void addWeapon(Weapon weapon) {
        if (checkDuplicateWeapon(weapon.getDisplayName())) {
            return;
        }
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "INSERT INTO " + TABLE_WEAPON + " ("
                + COLUMN_WEAPON_DISPLAYNAME + ", " + COLUMN_WEAPON_DESCRIPTION + ", "
                + COLUMN_WEAPON_IMAGE + ", " + COLUMN_WEAPON_FIRERATE + ", "
                + COLUMN_WEAPON_DAMAGE + ", " + COLUMN_WEAPON_AMMO + ", "
                + COLUMN_WEAPON_RELOADTIME + ", " + COLUMN_WEAPON_BULLETSPEED + ", "
                + COLUMN_WEAPON_TYPE + ", " + COLUMN_WEAPON_FIREMODE + ", "
                + COLUMN_WEAPON_PRICE
                + ") VALUES ('"
                + weapon.getDisplayName() + "', '"
                + weapon.getDescription() + "', '"
                + weapon.getImage() + "', '"
                + weapon.getFireRate() + "', '"
                + weapon.getDamage() + "', '"
                + weapon.getAmmo() + "', '"
                + weapon.getReloadTime() + "', '"
                + weapon.getBulletSpeed() + "', '"
                + weapon.getType() + "', '"
                + weapon.getFireMode() + "', '"
                + weapon.getPrice() + "')";
        db.execSQL(sql);
        // close connection
        db.close();
    }

    // get all weapon in database to list
    public List<Weapon> getAllWeapon() {
        List<Weapon> weaponList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_WEAPON;
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle")
        android.database.Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Weapon weapon = new Weapon();
                weapon.setId(cursor.getInt(0));
                weapon.setDisplayName(cursor.getString(1));
                weapon.setDescription(cursor.getString(2));
                weapon.setImage(cursor.getString(3));
                weapon.setFireRate(cursor.getString(4));
                weapon.setDamage(cursor.getString(5));
                weapon.setAmmo(cursor.getString(6));
                weapon.setReloadTime(cursor.getString(7));
                weapon.setBulletSpeed(cursor.getString(8));
                weapon.setType(cursor.getString(9));
                weapon.setFireMode(cursor.getString(10));
                weapon.setPrice(cursor.getString(11));
                weaponList.add(weapon);
            } while (cursor.moveToNext());
        }
         db.close();
        return weaponList;

    }
}
