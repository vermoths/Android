package com.first.vermoths.logintoserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //声明
    private EditText et_username;
    private EditText et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        et_password = (EditText) findViewById(R.id.et_password);
        et_username = (EditText) findViewById(R.id.et_username);
    }
    //HttpURLConnection GET方式
    public void click1(View view) {
        //拿到用户输入的用户名
        final String username = et_username.getText().toString().trim();
        //拿到密码
        final String password = et_password.getText().toString().trim();
        new Thread() {
            public void run() {
                //调用LoginService里面的方法访问服务器  并拿到服务器返回的信息
                final String result = LoginService.loginByGet(username,
                        password);
                if (result != null) {
                    //UI线程更改界面
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, result,Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    // 请求失败  UI线程弹出toast
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "请求失败...", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    });
                }
            };
        }.start();
    }
    //HttpURLConnection POST方式
    public void click2(View view) {
        //首先获取界面用户输入的用户名和密码
        final String username = et_username.getText().toString().trim();
        final String password = et_password.getText().toString().trim();
        new Thread() {//开启子线程访问网络
            public void run() {
                //调用LoginService里面的方法访问网络
                final String result = LoginService.loginByPost(username,
                        password);
                if (result != null) {
                    //ui线程更改界面
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    // 请求失败,使用UI线程更改UI界面
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "请求失败...", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    });
                }
            };
        }.start();
    }

}
