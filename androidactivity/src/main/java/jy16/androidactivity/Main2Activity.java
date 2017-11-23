package jy16.androidactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn2=(Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Activity[2]","onStart执行");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Activity[2]","onStop执行");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Activity[2]","onDestroy执行");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Activity[2]","onPause执行");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Activity[2]","onResume执行");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Activity[2]","onRestart执行");
    }
}
