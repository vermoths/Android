package jy16.androidorder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiverTwo extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("order","自定义广播2接收完毕");
        abortBroadcast();
        Log.i("order","哈哈，我拦截到了~");
    }
}
