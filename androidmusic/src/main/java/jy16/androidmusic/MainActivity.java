package jy16.androidmusic;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText path;
    private Intent intent;
    private myConn conn;
    MyService.MyBinder binder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //捕捉控件
        path=(EditText)findViewById(R.id.et_inputpath);
        findViewById(R.id.tv_play).setOnClickListener(this);
        findViewById(R.id.tv_pause).setOnClickListener(this);
        //创建服务链接，服务启动方式设置
        conn=new myConn();
        intent=new Intent(this,MyService.class);
        bindService(intent,conn,BIND_AUTO_CREATE);

    }

    @Override
    public void onClick(View view) {
        //获取你要播放的音乐的路径
        String pathway=path.getText().toString().trim();
        File SDPath= Environment.getExternalStorageDirectory();
        File file=new File(SDPath,pathway);
        String path=file.getAbsolutePath();

        switch (view.getId()){
            case R.id.tv_play:
                if (file.exists()&&file.length()>0){
                    Toast.makeText(this,"正在播放。。。",Toast.LENGTH_SHORT).show();
                    binder.play(path);
                }else {
                    Toast.makeText(this,"找不到",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tv_pause:
                Toast.makeText(this,"暂停播放",Toast.LENGTH_SHORT).show();
                binder.pause();
                break;
            default:
                break;
        }
    }

    private class myConn implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            binder=(MyService.MyBinder)iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
}
