package jy16.first;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
//声明控件
    private Button relaBtn;
    private Button gridBtn;
    private Button tabBtn;
    private Button logBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //控件捕捉
        relaBtn=(Button)findViewById(R.id.btnR);
        gridBtn=(Button)findViewById(R.id.btnG);
        tabBtn=(Button)findViewById(R.id.btnT);
        logBtn=(Button)findViewById(R.id.btnL);


        //设置匿名点击事件1
        relaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"相对布局~",Toast.LENGTH_SHORT).show();
                //实现不传值跳转
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,RelativeActivity.class);
                startActivity(intent);
            }
        });

        //设置匿名点击事件2
        tabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"表格布局~",Toast.LENGTH_SHORT).show();
                //实现不传值跳转
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,TableActivity.class);
                startActivity(intent);
            }
        });

        //设置匿名点击事件3
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"登录界面~",Toast.LENGTH_SHORT).show();
                //实现不传值跳转
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        //设置非匿名点击事件4
        gridBtn.setOnClickListener(new GridOnClickListenner());
    }

    private class GridOnClickListenner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"网格布局~",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,GridActivity.class);
            startActivity(intent);
        }
    }


}
