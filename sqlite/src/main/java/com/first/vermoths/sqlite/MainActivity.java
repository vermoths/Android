package com.first.vermoths.sqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获得可读写的SQLite对象
        dbHelper database=new dbHelper(this);
        SQLiteDatabase db=null;
        db=database.getWritableDatabase();

        ContentValues cv = new ContentValues();//实例化一个ContentValues用来装载待插入的数据
        cv.put("username","Jack Jo");//添加用户名
        cv.put("password","8888"); //添加密码

        db.insert("user",null,cv);//执行插入操作

    }
}
