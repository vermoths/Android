package jy16.mycontent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vermoths on 2017/11/9.
 */

public class PeopleOpenHelper extends SQLiteOpenHelper {
    public PeopleOpenHelper(Context context) {
        super(context, "Miao.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table info(_id integer primary key autoincrement ,name varchar(20),money integer(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
