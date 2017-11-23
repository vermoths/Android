package com.first.vermoths.simplecontentptovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //声明控件
    //声明控件，游标以及按钮
    private ListView lvContacts=null;
    private Cursor cursor=null;
    private Button btnRead=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //捕获控件
        lvContacts=(ListView)super.findViewById(R.id.contactlist);
        btnRead=(Button)super.findViewById(R.id.read);

        //添加点击事件
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //对应静态常量为ContactsContract.CommonDataKinds.Phone.CONTENT_URI
                Uri uri=Uri.parse("content://com.android.contacts/data/phones");

                //使用游标获取内容位置并返回具体值
                //通过ContentResolver().query方法，传入不同的URI即可访问相应的数据集。
                cursor=MainActivity.this.getContentResolver()
                        .query(uri,
                                null,
                                null,
                                null,
                                null);
                //定义后续Adapter数据适配的传入值
                String[] from={ContactsContract.Contacts.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
                int to[]={R.id._id,R.id.name};
                //使用SimpleCursorAdapter数据适配，方便展示数据库内容，简单ListView展示
                SimpleCursorAdapter  adapter = new SimpleCursorAdapter(
                        MainActivity.this,R.layout.list_item,cursor, from, to);
                lvContacts.setAdapter(adapter);  //设置适配器
            }

        });
    }
}
