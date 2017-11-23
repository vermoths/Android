package jy16.first;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GridActivity extends Activity {

    private Button btnG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        btnG=(Button)findViewById(R.id.gbtn);

        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(GridActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
