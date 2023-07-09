package com.example.prmapplication.Handler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.prmapplication.Models.Product;

import java.util.ArrayList;

public class ProductDBContext extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Sakura";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_PRODUCT = "Product";
    private static final String PRODUCT_KEY_ID = "id";
    private static final String PRODUCT_KEY_DISPLAY_NAME = "displayName";
    private static final String PRODUCT_KEY_DESCRIPTION = "description";
    private static final String PRODUCT_KEY_PRICE = "price";
    private static final String PRODUCT_KEY_IMAGE = "image";
    private static final String CREATE_PRODUCT_DB = "CREATE TABLE " + TABLE_PRODUCT + "("
            + PRODUCT_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + PRODUCT_KEY_DISPLAY_NAME + " TEXT,"
            + PRODUCT_KEY_DESCRIPTION + " TEXT,"
            + PRODUCT_KEY_PRICE + " TEXT,"
            + PRODUCT_KEY_IMAGE + " TEXT" + ")";
    public ProductDBContext(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PRODUCT_DB);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        // create table again
        onCreate(db);
    }

    // check duplicate product
    public Boolean checkDuplicateProduct(String displayName) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCT + " WHERE " + PRODUCT_KEY_DISPLAY_NAME + " = '" + displayName + "'";
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(query, null);
        return cursor.getCount() > 0;
    }

    // CRUD operations with Product table, check duplicate product first
    public Boolean addProduct(Product product) {
        if (checkDuplicateProduct(product.getDisplayName())) {
            return false;
        }
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO " + TABLE_PRODUCT + " (" + PRODUCT_KEY_DISPLAY_NAME + ", " + PRODUCT_KEY_DESCRIPTION + ", "
                + PRODUCT_KEY_PRICE + ", " + PRODUCT_KEY_IMAGE + ") VALUES ('" + product.getDisplayName() + "', '"
                + product.getDescription() + "', '" + product.getPrice() + "', '" + product.getImage() + "')");
        return true;
    }

    public Boolean updateProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_PRODUCT + " SET " + PRODUCT_KEY_DISPLAY_NAME + " = '" + product.getDisplayName() + "', "
                + PRODUCT_KEY_DESCRIPTION + " = '" + product.getDescription() + "', "
                + PRODUCT_KEY_PRICE + " = '" + product.getPrice() + "', "
                + PRODUCT_KEY_IMAGE + " = '" + product.getImage() + "' WHERE " + PRODUCT_KEY_ID + " = " + product.getId());
        return true;
    }

    public Boolean deleteProduct(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PRODUCT + " WHERE " + PRODUCT_KEY_ID + " = " + id);
        return true;
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PRODUCT, null);
        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setId(cursor.getString(0));
                product.setDisplayName(cursor.getString(1));
                product.setDescription(cursor.getString(2));
                product.setPrice(cursor.getString(3));
                product.setImage(cursor.getString(4));
                products.add(product);
            } while (cursor.moveToNext());
        }
        return products;
    }

    public Product getProductById(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PRODUCT + " WHERE " + PRODUCT_KEY_ID + " = " + id, null);
        if (cursor.moveToFirst()) {
            Product product = new Product();
            product.setId(cursor.getString(0));
            product.setDisplayName(cursor.getString(1));
            product.setDescription(cursor.getString(2));
            product.setPrice(cursor.getString(3));
            product.setImage(cursor.getString(4));
            return product;
        }
        return null;
    }

    public ArrayList<Product> searchProduct(String displayName) {
        ArrayList<Product> products = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PRODUCT + " WHERE " + PRODUCT_KEY_DISPLAY_NAME + " LIKE '%" + displayName + "%'", null);
        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setId(cursor.getString(0));
                product.setDisplayName(cursor.getString(1));
                product.setDescription(cursor.getString(2));
                product.setPrice(cursor.getString(3));
                product.setImage(cursor.getString(4));
                products.add(product);
            } while (cursor.moveToNext());
        }
        return products;
    }

}
