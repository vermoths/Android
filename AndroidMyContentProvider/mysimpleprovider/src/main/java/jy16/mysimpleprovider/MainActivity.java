package jy16.mysimpleprovider;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        MyHelper mh=new MyHelper(this);
        SQLiteDatabase db=mh.getWritableDatabase();
        ContentValues v=new ContentValues();

        v.put("name","老王");
        v.put("number","1111");
        long rowid=db.insert("person",null,v);
        if(rowid!=-1){
            Log.i("hm","成功");
        }else{
            Log.i("hm","失败");
        }
    }
}
