package jy16.androidintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Show_Activity extends AppCompatActivity {

    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_);

        tvShow=(TextView)findViewById(R.id.tvShow);

        Intent intent=getIntent();
        String outShow=intent.getStringExtra("show");
       tvShow.setText(outShow);

    }
}
