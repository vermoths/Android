package jy16.androidsimplecp;

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
    private ListView lv=null;
    private Button btnRead;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //捕捉
        lv=(ListView)findViewById(R.id.contactlist);
        btnRead=(Button)findViewById(R.id.read);

        //点击事件
                    btnRead.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                //操作暴露出来的数据，查询并显示
                Uri uri=Uri.parse("content://com.android.contacts/data/phones");
                //通过ContentResolver().query方法进行查询
                cursor=MainActivity.this.getContentResolver().query(uri,null,null,null,null);
                String[] from={ContactsContract.Contacts.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
                int[] to={R.id.name,R.id._id};

                SimpleCursorAdapter adapter=new SimpleCursorAdapter(MainActivity.this,R.layout.list_item,cursor,from,to,0);
                    lv.setAdapter(adapter);
            }
        });
    }
}
