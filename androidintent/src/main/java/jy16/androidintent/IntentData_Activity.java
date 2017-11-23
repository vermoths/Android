package jy16.androidintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentData_Activity extends AppCompatActivity {

    Button btnN;
    EditText edIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_data_);

        btnN=(Button)findViewById(R.id.showN);
        edIn=(EditText)findViewById(R.id.edtIn);

        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edInput=edIn.getText().toString();
                Intent intent=new Intent();
                intent.setClass(IntentData_Activity.this,Show_Activity.class);
                intent.putExtra("show",edInput);
                startActivity(intent);
            }
        });
    }
}
