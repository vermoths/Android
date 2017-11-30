package jy16.bindsercices;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyService.MyBinder myBinder;
    //连接的作用是通过连接去调用服务中的方法
    private MyConn myconn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bind(View view) {
        if(myconn == null){
            myconn=new MyConn();
        }
        Intent intent=new Intent(this,MyService.class);
        bindService(intent,myconn,BIND_AUTO_CREATE);
    }

    public void call(View view) {
        myBinder.callMethodInService();
    }

    public void unbind(View view) {
        if(myconn!=null){
            unbindService(myconn);
            myconn=null;
        }
    }

    private class MyConn implements ServiceConnection{
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder=(MyService.MyBinder) iBinder;
            Log.i("bindS","服务成功绑定，内存地址："+myBinder.toString());
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
}
