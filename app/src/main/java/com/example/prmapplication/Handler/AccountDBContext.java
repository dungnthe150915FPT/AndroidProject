package com.example.prmapplication.Handler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.prmapplication.Models.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountDBContext extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Sakura";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_ACCOUNT = "Account";
    private static final String ACCOUNT_KEY_ID = "id";
    private static final String ACCOUNT_KEY_USERNAME = "username";
    private static final String ACCOUNT_KEY_PASSWORD = "password";
    private static final String ACCOUNT_KEY_EMAIL = "email";
    private static final String ACCOUNT_KEY_PHONE = "phone";
    private static final String CREATE_ACCOUNT_DB = "CREATE TABLE " + TABLE_ACCOUNT + "("
            + ACCOUNT_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ACCOUNT_KEY_USERNAME + " TEXT,"
            + ACCOUNT_KEY_PASSWORD + " TEXT,"
            + ACCOUNT_KEY_EMAIL + " TEXT,"
            + ACCOUNT_KEY_PHONE + " TEXT" + ")";

    public AccountDBContext(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ACCOUNT_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNT);
        // create table again
        onCreate(db);
    }

    // CRUD operations with Account table
    public Boolean addAccount(Account account) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO " + TABLE_ACCOUNT + " (" + ACCOUNT_KEY_USERNAME + ", " + ACCOUNT_KEY_PASSWORD + ", "
                + ACCOUNT_KEY_EMAIL + ", " + ACCOUNT_KEY_PHONE + ") VALUES ('" + account.getUsername() + "', '"
                + account.getPassword() + "', '" + account.getEmail() + "', '" + account.getPhone() + "')");
        return true;
    }

    public Boolean updateAccount(Account account) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_ACCOUNT + " SET " + ACCOUNT_KEY_USERNAME + " = '" + account.getUsername() + "', "
                + ACCOUNT_KEY_PASSWORD + " = '" + account.getPassword() + "', " + ACCOUNT_KEY_EMAIL + " = '"
                + account.getEmail() + "', " + ACCOUNT_KEY_PHONE + " = '" + account.getPhone() + "' WHERE "
                + ACCOUNT_KEY_ID + " = " + account.getId());
        return true;
    }

    public Boolean deleteAccount(Account account) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_ACCOUNT + " WHERE " + ACCOUNT_KEY_ID + " = " + account.getId());
        return true;
    }

    public Account getAccount(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ACCOUNT + " WHERE " + ACCOUNT_KEY_ID + " = " + id, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        assert cursor != null;
        return new Account(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4));
    }

    public Account getAccount(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ACCOUNT + " WHERE " + ACCOUNT_KEY_USERNAME + " = '"
                + username + "'", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        assert cursor != null;
        return new Account(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4));
    }

    public Account getAccount(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ACCOUNT + " WHERE " + ACCOUNT_KEY_USERNAME + " = '"
                + username + "' AND " + ACCOUNT_KEY_PASSWORD + " = '" + password + "'", null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        assert cursor != null;
        return new Account(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4));
    }

    public List<Account> getAllAccounts() {
        List<Account> accountList = new ArrayList<Account>();
        String selectQuery = "SELECT * FROM " + TABLE_ACCOUNT;
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Account account = new Account();
                account.setId(Integer.parseInt(cursor.getString(0)));
                account.setUsername(cursor.getString(1));
                account.setPassword(cursor.getString(2));
                account.setEmail(cursor.getString(3));
                account.setPhone(cursor.getString(4));
                accountList.add(account);
            } while (cursor.moveToNext());
        }
        return accountList;
    }

    public Boolean checkUsernameExists(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ACCOUNT + " WHERE " + ACCOUNT_KEY_USERNAME + " = '"
                + username + "'", null);
        return cursor.getCount() > 0;
    }

    public Boolean checkEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ACCOUNT + " WHERE " + ACCOUNT_KEY_EMAIL + " = '"
                + email + "'", null);
        return cursor.getCount() > 0;
    }

    public Boolean checkPhoneExists(String phone) {
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ACCOUNT + " WHERE " + ACCOUNT_KEY_PHONE + " = '"
                + phone + "'", null);
        return cursor.getCount() > 0;
    }
}
