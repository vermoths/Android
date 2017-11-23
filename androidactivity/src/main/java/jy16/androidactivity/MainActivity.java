package jy16.androidactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Activity[1]","onStart执行");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Activity[1]","onStop执行");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Activity[1]","onDestroy执行");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Activity[1]","onPause执行");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Activity[1]","onResume执行");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Activity[1]","onRestart执行");

    }
}
