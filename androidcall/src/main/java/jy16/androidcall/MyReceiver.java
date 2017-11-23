package jy16.androidcall;

import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //获取拨打的电话
        String outCall=getResultData();
        //获取刚保存的要拦截的电话
        SharedPreferences sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        String number=sp.getString("number"," ");
        if(outCall.equals(number)){
            setResultData(null);
            Toast.makeText(context, "不可以打出去！", Toast.LENGTH_SHORT).show();
        }
    }
}
