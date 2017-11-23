package com.first.vermoths.startservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
      return  null;
    }

    @Override
    public void onCreate() {
        Log.i("startService","onCreate()");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        Log.i("startService","onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("startService","onDestroy()");
        super.onDestroy();
    }
}
