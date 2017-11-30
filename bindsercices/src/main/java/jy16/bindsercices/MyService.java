package jy16.bindsercices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
   class MyBinder extends Binder{
//绑定后要运行的方法
    public void callMethodInService(){
        methodInService();
    }
   }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("bindS","创建服务调用onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
       Log.i("bindS","绑定服务调用onBind");
       return new MyBinder();
    }


    public void methodInService(){
Log.i("bindS","自定义方法运行methodServices");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("bindS","解除绑定，调用UnBind");
        return super.onUnbind(intent);
    }
}
