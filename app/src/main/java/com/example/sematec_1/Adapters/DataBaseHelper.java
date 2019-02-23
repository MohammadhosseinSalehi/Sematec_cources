package com.example.sematec_1.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    String db_create_query = "" +
            "CREATE TABLE azanTable (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
            "city TEXT ," +
            "azanTime TEXT " +
            ")" +
            "";

    public DataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(db_create_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertToDB(String city, String azanTime) {

        String insertQuery = "INSERT INTO " +
                "azanTable" +
                "(city , azanTime)" +
                "VALUES( '" + city + "' , '" + azanTime + "' )";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(insertQuery);
        db.close();
    }

    public String getAzanTime(){
        String test = "";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT azanTime from "+
                "azanTable",null);
        while (cursor.moveToNext()){
            test +=cursor.getString(0)+"\n";
        }
        db.close();
        return test;

    }
}
