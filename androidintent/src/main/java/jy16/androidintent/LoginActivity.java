package jy16.androidintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    //声明控件
    private EditText et_name;
    private EditText et_passwd;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //捕捉控件
        et_name=(EditText)findViewById(R.id.et_name);
        et_passwd=(EditText)findViewById(R.id.et_psw);
        btn_send=(Button)findViewById(R.id.btn_send);

        //点击事件开始数据单向传递
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passData();
            }
        });
    }

    private void passData() {
        //创建Intent对象，启动显示界面
        Intent intent=new Intent(this,ShopShow_Activity.class);
        //存入数据
        intent.putExtra("name",et_name.getText().toString().trim());
        intent.putExtra("password",et_passwd.getText().toString().trim());
        startActivity(intent);
    }
}
