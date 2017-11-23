package jy16.androidsp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_save;
    private Button btn_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_save=(Button)findViewById(R.id.btn_save);
        btn_show=(Button)findViewById(R.id.btn_show);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=MainActivity.this.getSharedPreferences("examp", Activity.MODE_PRIVATE);
                //获得可编辑的对象
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("url","ftp://192.168.20.20");
                editor.putString("name","计算机Android程序设计");
                editor.commit();
                Toast.makeText(getApplicationContext(),"OKOKOKOK",Toast.LENGTH_SHORT).show();
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=MainActivity.this.getSharedPreferences("examp",Activity.MODE_PRIVATE);
                String url=sp.getString("url","");
                String name=sp.getString("name","");
                String info="作业提交地址："+url+"课程名称："+name;
                Toast.makeText(getApplicationContext(),info,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
