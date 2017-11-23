package com.first.vermoths.bindservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyService.MyBind myBind;
    private MyConn myconn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
//绑定服务
    public void bind(View view) {
        //用于判断是否有连接调用的服务方法
        if(myconn==null){
            myconn=new MyConn();
        }
        Intent intent =new Intent(this,MyService.class);
        bindService(intent,myconn,BIND_AUTO_CREATE);
    }

    //解除绑定
    public void unbind(View view) {
        if(myconn!=null){
            unbindService(myconn);
            myconn=null;
        }
    }
//调用服务中的方法
    public void call(View view) {
        myBind.CallMethodInService();
    }

//创建MyConn类用于连接服务
    private class MyConn implements ServiceConnection{

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        myBind =(MyService.MyBind) service;
        Log.i("MainActivity","服务成功绑定，内存地址为："+myBind.toString());
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
}
