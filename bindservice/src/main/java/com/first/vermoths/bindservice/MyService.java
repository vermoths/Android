package com.first.vermoths.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.i("bindS","调用onCreate()方法！");
        super.onCreate();
    }
//调用服务中的方法
    class MyBind extends Binder{
        public void CallMethodInService(){
            methodInService();
        }
    }

    private void methodInService() {
        Log.i("bindS","自定义方法methodInService()调用!");
    }

    @Override
    public IBinder onBind(Intent intent) {
       Log.i("bindS","绑定服务onBind()！");
        return new MyBind();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("bindS","解除绑定onUnbind()");
        return super.onUnbind(intent);
    }

}
