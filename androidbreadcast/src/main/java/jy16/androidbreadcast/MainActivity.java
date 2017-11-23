package jy16.androidbreadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
//发送广播的操作
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View view) {
        Intent intent=new Intent();
        //定义发送广播的名称类型
        intent.setAction("Help");
        sendBroadcast(intent);
    }
}
