package com.first.vermoths.monitordata;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView sms_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                sms_tv=(TextView)findViewById(R.id.tv_sms);

                 // 该uri路径指向数据库应用中的数据库info表
               Uri uri = Uri.parse("content://com.first.vermoths.contentoberverdb/info/");
               // Uri uri = Uri.parse("content://sms/");
                //注册内容观察者，参数uri指向要监测的数据库info表，
                //参数true定义了监测的范围，最后一个参数是一个内容观察者对象
                getContentResolver().registerContentObserver(uri, true,
                        new MyObserver(new Handler()));
            }
            //自定义内容观察者
            private class MyObserver extends ContentObserver {
                public MyObserver(Handler handler) {//handler 是一个消息处理器。
                    super(handler);
                }
                @Override
                //当info表中的数据发生变化时则执行该方法
                public void onChange(boolean selfChange) {
                    super.onChange(selfChange);
                    Toast.makeText(MainActivity.this,"监测数据变化,有人动了你的数据库！",Toast.LENGTH_SHORT).show();
                    Uri uri=Uri.parse("content://com.first.vermoths.contentoberverdb/info/");
                    ContentResolver resolver=getContentResolver();
                    Cursor cursor=resolver.query(uri,new String[]{"_id","name"},null,null,null);
                    cursor.moveToFirst();
                    int id=cursor.getInt(0);
                    String name=cursor.getString(1);

                  sms_tv.setText("序号："+id+"\n"+"姓名"+name);
                 //  Log.v("监测数据变化","body");
                    cursor.close();
                }
            }
        }


