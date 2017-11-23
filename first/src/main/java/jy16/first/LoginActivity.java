package jy16.first;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    //声明按钮以及编辑框
    private EditText userName;
    private EditText pasw;
    private Button btnShow;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //捕捉
        userName=(EditText)findViewById(R.id.edt1);
        pasw=(EditText)findViewById(R.id.edt2);
        btnShow=(Button)findViewById(R.id.saveBtn);
        btnNext=(Button)findViewById(R.id.nextBtn);


        //点击事件获取用户名密码
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=userName.getText().toString();
                String psword=pasw.getText().toString();
                String Info="用户名："+username+"🍨🍨🍨🍨🍨🍨🍨密码："+psword;

                Toast.makeText(getApplicationContext(),Info,Toast.LENGTH_SHORT).show();

            }
        });


        //点击事件进行页面跳转
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(LoginActivity.this,FavActivity.class);
                startActivity(intent);
            }
        });

    }
}
