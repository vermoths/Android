package jy16.batterylevel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv_cell,tv_netWork;
    private BatteryReceiver batteryReceiver;
    private ConnectivityReceiver connectivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_cell=(TextView)findViewById(R.id.tv_cell);
        tv_netWork=(TextView)findViewById(R.id.tv_netWork);
        //动态注册电池电量以及网络信号
        IntentFilter intentFilter=new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        //注册
        batteryReceiver=new BatteryReceiver();
        registerReceiver(batteryReceiver,intentFilter);

        IntentFilter mFileter=new IntentFilter();
        mFileter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        connectivity=new ConnectivityReceiver();
        registerReceiver(connectivity,mFileter);

    }
    public class BatteryReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if(Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())){
                //获取当前电量
                int level=intent.getIntExtra("level",0);
                //总电量刻度
                int scale=intent.getIntExtra("scale",100);
                //转换成百分比
                tv_cell.setText("电池电量"+((level*100)/scale)+"%");
            }
        }
    }

    public class ConnectivityReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            NetworkInfo.State wifiState=null;
            NetworkInfo.State mobileState=null;
            ConnectivityManager cm=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            wifiState=cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
            mobileState=cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
            if (wifiState != null && mobileState != null
                    && NetworkInfo.State.CONNECTED != wifiState
                    && NetworkInfo.State.CONNECTED == mobileState) {

                Toast.makeText(context, "手机网络连接成功",
                        Toast.LENGTH_SHORT).show();
                tv_netWork.setText("手机网络连接成功");
                // 手机网络连接成功
            } else if (wifiState != null && mobileState != null
                    && NetworkInfo.State.CONNECTED != wifiState
                    && NetworkInfo.State.CONNECTED != mobileState) {
                // 手机没有任何的网络
                Toast.makeText(context, "手机没有网络",
                        Toast.LENGTH_SHORT).show();
                tv_netWork.setText("手机没有网络");
            } else if (wifiState != null && NetworkInfo.State.CONNECTED == wifiState) {
                // 无线网络连接成功
                Toast.makeText(context, "无限网络连接成功",
                        Toast.LENGTH_SHORT).show();
                tv_netWork.setText("无限网络连接成功");
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(batteryReceiver);
        unregisterReceiver(connectivity);
    }
}
