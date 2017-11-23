package com.first.vermoths.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vermoths on 2017/3/28.
 */

public class dbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="he.db";
    private static final int version=1;


    public dbHelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table user(username varchar(20) not null , password varchar(60) not null );";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
