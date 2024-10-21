package com.example.kurshact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "your_database.db";
    private static final String TABLE_CLIENTS = "clients";
    private static final String TABLE_TOVAR = "tovar";

    private static final String COL_ID = "id";
    private static final String COL_LOGIN = "login";
    private static final String COL_PASSWORD = "password";

    private static final String COL_TOVAR_NAME = "name";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Создаем таблицу пользователей
        db.execSQL("CREATE TABLE " + TABLE_CLIENTS + " (id INTEGER PRIMARY KEY AUTOINCREMENT, login TEXT, password TEXT)");

        // Создаем таблицу товаров
        db.execSQL("CREATE TABLE " + TABLE_TOVAR + " (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");

        // Вставляем пример данных в таблицу товаров
        //db.execSQL("INSERT INTO " + TABLE_TOVAR + " (name) VALUES ('Товар 1'), ('Товар 2'), ('Товар 3')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TOVAR);
        onCreate(db);
    }

    // Метод для регистрации пользователя
    public boolean insertUser(String login, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_LOGIN, login);
        contentValues.put(COL_PASSWORD, password);
        long result = db.insert(TABLE_CLIENTS, null, contentValues);
        return result != -1; // Если результат -1, значит вставка не удалась
    }

    // Метод для проверки логина и пароля
    public boolean checkUser(String login, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CLIENTS + " WHERE login=? AND password=?", new String[]{login, password});
        boolean userExists = cursor.getCount() > 0;
        cursor.close();
        return userExists;
    }

    // Метод для получения списка товаров
    public List<String> getAllTovars() {
        List<String> tovars = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT name FROM " + TABLE_TOVAR, null);
        if (cursor.moveToFirst()) {
            do {
                tovars.add(cursor.getString(0)); // Добавляем название товара в список
            } while (cursor.moveToNext());
        }
        cursor.close();
        return tovars;
    }
}