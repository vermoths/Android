package com.first.vermoths.forhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//定义点击事件
    public void send(View view) {
        Intent intent=new Intent();
        //定义广播类型
        intent.setAction("Help_me");
        //发送广播
        sendBroadcast(intent);
    }
}
