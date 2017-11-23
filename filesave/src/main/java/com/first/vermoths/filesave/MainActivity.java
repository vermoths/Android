package com.first.vermoths.filesave;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //声明
    private EditText et_info;
    private Button btn_save;
    private Button btn_read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取布局
        et_info=(EditText)findViewById(R.id.ed_info);
        btn_save=(Button)findViewById(R.id.btn_save);
        btn_read=(Button)findViewById(R.id.btn_read);
        //点击事件
        btn_read.setOnClickListener(this);
        btn_save.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                //点击保存按钮后
                String saveInfo = et_info.getText().toString().trim();
                FileOutputStream fos;//新建文件对象用于存指定文件
                try {
                    //保存数据
                    //使用openFileOutPut()方法获取文件对象fos
                    fos=openFileOutput("data.txt", Context.MODE_APPEND);
                    fos.write(saveInfo.getBytes());
                    fos.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, "数据保存成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_read:
                //点击读取按钮
                String content = "";
                try {
                    //读取数据
                    //新建文件对象fis用于读取数据，使用对应的openFileInPut()方法读取存储的文件
                    FileInputStream fis=openFileInput("data.txt");
                    byte[] buffer=new byte[fis.available()];
                    fis.read(buffer);
                    content=new String(buffer);
                    fis.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, "保存的数据是：" + content, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}

