package jy16.androidonclick;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btnClick;
    private Button btnClick2;
    private Button btnClick3;
    private Button btnClick4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick=(Button)findViewById(R.id.btn1);
        btnClick2=(Button)findViewById(R.id.btn2);
        btnClick3=(Button)findViewById(R.id.btn3);
        btnClick4=(Button)findViewById(R.id.btn4);

        btnClick3.setOnClickListener(this);
        btnClick2.setOnClickListener(new MyOcClickListener());
        btnClick4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("匿名内部类方式点击事件", "button  is clicked。。。。。。");
                //   Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void click(View v){
        Log.i("指定onClick属性方式", "button  is clicked");

    }

    @Override
    public void onClick(View v) {
        Log.i("接口方式", "button  is clicked again and again~");
    }

    private class MyOcClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Log.i("独立点击事件方式", "button  is clicked again~");
        }
    }
}
