package com.first.vermoths.startservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button start=(Button)findViewById(R.id.btn_start);
//        Button stop=(Button)findViewById(R.id.btn_stop);
    }

    public void start(View view) {
        Intent intent=new Intent(this,MyService.class);
        startService(intent);
    }

    public void stop(View view) {
        Intent intent=new Intent(this,MyService.class);
        stopService(intent);
    }
}
