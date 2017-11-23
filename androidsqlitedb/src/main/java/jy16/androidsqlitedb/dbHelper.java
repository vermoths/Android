package jy16.androidsqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vermoths on 2017/11/1.
 */

public class dbHelper extends SQLiteOpenHelper {
    public dbHelper(Context context) {
        super(context, "jy16.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
   db.execSQL("create table students(username varchar(20) not null,password varchar(20) not null);");
//        String sql="create table students(username varchar(20) not null,password varchar(20) not null);";
//        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
