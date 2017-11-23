package jy16.androidbreadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
      Log.i("MyReceiver","收到二货的求救信息~");
        Toast.makeText(context,"收到啦~",Toast.LENGTH_LONG).show();
        Log.i("MyReceicer",intent.getAction());
    }
}
