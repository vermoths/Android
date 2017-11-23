package jy16.mysimpleread;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver resolver=this.getContentResolver();

        Uri uri=Uri.parse("content://jy16.mysimpleprovider/query");

        Cursor cursor=resolver.query(uri,null,null,null,null);

        Log.i("hm",cursor+"--------");
        while(cursor!=null&&cursor.moveToNext()){
            int id=cursor.getInt(cursor.getColumnIndex("id"));
            String number=cursor.getString(2);
            Log.i("hm","id:"+id+"number:"+number);
        }
        }
    }
