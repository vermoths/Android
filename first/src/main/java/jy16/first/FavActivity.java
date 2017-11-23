package jy16.first;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class FavActivity extends AppCompatActivity {
    //声明各种按钮以及下拉框
    private RadioButton rbBoy=null;
    private RadioButton rbGirl=null;
    private CheckBox cbFoot=null;
    private CheckBox cbBusketD=null;
    private CheckBox cbCang=null;
    private CheckBox cbGame=null;
    private Button btnSN=null;
    private Spinner spinnerProvince=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
//捕捉控件
        rbBoy=(RadioButton)super.findViewById(R.id.rbboy);
        rbGirl=(RadioButton)super.findViewById(R.id.rbgirl);
        cbFoot=(CheckBox)super.findViewById(R.id.cb1);
        cbBusketD=(CheckBox)super.findViewById(R.id.cb2);
        cbCang=(CheckBox)super.findViewById(R.id.cb3);
        cbGame=(CheckBox)super.findViewById(R.id.cb4);
        btnSN=(Button)super.findViewById(R.id.button);

        spinnerProvince=(Spinner)super.findViewById(R.id.spinner);

        btnSN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击事件中声明
                String sGender="";
                String sFav="";
                String sProv="";
                String sInfo="";
                //单选按钮进行选择
                if(rbBoy.isChecked())
                    sGender=rbBoy.getText().toString();
                if (rbGirl.isChecked())
                    sGender=rbGirl.getText().toString();
                //复选框进行选择
                if(cbFoot.isChecked())
                    sFav=sFav+cbFoot.getText().toString();
                if(cbBusketD.isChecked())
                    sFav=sFav+cbBusketD.getText().toString();
                if(cbCang.isChecked())
                    sFav=sFav+cbCang.getText().toString();
                if(cbGame.isChecked())
                    sFav=sFav+cbGame.getText().toString();
                //对籍贯下拉框进行选择
                sProv=spinnerProvince.getSelectedItem().toString();

                sInfo="性别："+sGender+"😜籍贯："+sProv+"😒爱好："+sFav;

                Toast.makeText(getApplicationContext(),sInfo,Toast.LENGTH_LONG).show();

                Intent intent=new Intent();
                intent.setClass(FavActivity.this,PicActivity.class);
                startActivity(intent);
            }
        });

    }
    }