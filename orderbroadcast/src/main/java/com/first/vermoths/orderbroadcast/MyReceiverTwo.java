package com.first.vermoths.orderbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiverTwo extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MyReceiverTwo","自定义广播two，接收完毕！");
//        abortBroadcast();//拦截有序广播
//        Log.i("MyReceiver","我是广播接收者two，广播被我终结啦~");
    }
}
