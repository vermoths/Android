package jy16.androidwebinmage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    //声明TAG
    protected static final int CHANGE_UI=1;
    protected static final int ERROR=2;
    private EditText et_path;
    private ImageView ivPic;

//创建主线程Handler
    private Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
       if(msg.what==CHANGE_UI){
           Bitmap bitmap=(Bitmap)msg.obj;
           ivPic.setImageBitmap(bitmap);
       }else if(msg.what==ERROR){
           Toast.makeText(MainActivity.this,"图片显示错误",Toast.LENGTH_SHORT).show();
       }
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_path=(EditText)findViewById(R.id.et_path);
        ivPic=(ImageView) findViewById(R.id.iv_pic);
    }

    public void click(View view) {
        final String path=et_path.getText().toString().trim();
       //判断路径不为空
        if(TextUtils.isEmpty(path)){
            Toast.makeText(this,"图片路径不能为空",Toast.LENGTH_SHORT).show();
        }else{
            //路径有效时请求数据,创建子线程请求网络服务数据
            new Thread(){
                private HttpURLConnection conn;
                private Bitmap bitmap;
                public void run(){
                    try{
                        URL url=new URL(path);
                        conn=(HttpURLConnection)url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.setConnectTimeout(5000);
                        int code=conn.getResponseCode();
                        if(code==200){
                            InputStream is=conn.getInputStream();
                            bitmap= BitmapFactory.decodeStream(is);
                            Message msg=new Message();
                            msg.what=CHANGE_UI;
                            msg.obj=bitmap;
                            handler.sendMessage(msg);
                        }else{
                            Message msg=new Message();
                            msg.what=ERROR;
                            handler.sendMessage(msg);
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                        Message msg=new Message();
                        msg.what=ERROR;
                        handler.sendMessage(msg);
                    }
                   conn.disconnect();
                }

            }.start();
        }
    }
}
