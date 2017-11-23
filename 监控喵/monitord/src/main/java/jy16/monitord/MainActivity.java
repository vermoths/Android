package jy16.monitord;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri=Uri.parse("content://jy16.mycontent/info");
        getContentResolver().registerContentObserver(uri,true,new MyObersrver(new Handler()));
    }

    private class MyObersrver extends ContentObserver {
        public MyObersrver(Handler handler) {
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            Log.i("监测数据变化","有人动了你的数据库！！！！");
        }

    }
}
