package jy16.androidorder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiverThree extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("order","自定义广播three接收完毕");
    }
}
