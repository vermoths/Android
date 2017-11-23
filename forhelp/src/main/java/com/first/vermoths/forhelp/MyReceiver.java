package com.first.vermoths.forhelp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MyReceiver","自定义广播接收者接到了二货的求救信息");
        Log.i("MyReceiver",intent.getAction());
    }
}
