package jy16.androidcall;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_callNumber;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_callNumber=(EditText)findViewById(R.id.et_ipnumber);
        //创建sp对象
        sp=getSharedPreferences("config",MODE_PRIVATE);
    }
    //按钮点击事件
    //TestGitTIme
    public void click(View view){
        //获取用户输入的号码
        String number=et_callNumber.getText().toString().trim();
        //创建Editor对象，保存数据
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("number",number);
        editor.commit();
        Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
    }
}
