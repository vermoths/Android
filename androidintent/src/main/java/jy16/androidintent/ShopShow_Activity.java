package jy16.androidintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ShopShow_Activity extends AppCompatActivity {
    private TextView tv_name;
    private TextView tv_passwd;
    //声名进度条
    private ProgressBar mProgB1;
    private ProgressBar mProgB2;
    private ProgressBar mProgB3;
    private TextView mLifeTv;
    private TextView mAttackTv;
    private TextView mSpeedTv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopshow_);

        //获取Intent值
        Intent intent=getIntent();

        //取出key对应值
        String name=intent.getStringExtra("name");
        String psd=intent.getStringExtra("password");

        //捕捉控件
        tv_name=(TextView)findViewById(R.id.tv_name);
        tv_passwd=(TextView)findViewById(R.id.tv_paswd);

        //显示字符串
        tv_name.setText("用户名："+name);
        tv_passwd.setText("密    码："+psd);

        //捕捉数值TextView
        mLifeTv=(TextView)findViewById(R.id.tv_progs_life);
        mAttackTv=(TextView)findViewById(R.id.tv_progs_attack);
        mSpeedTv=(TextView)findViewById(R.id.tv_progs_speed);

        //初始化进度条
        iniProgress();
    }

    private void iniProgress() {
        //捕捉进度条控件
        mProgB1=(ProgressBar)findViewById(R.id.progB1);
        mProgB2=(ProgressBar)findViewById(R.id.progB2);
        mProgB3=(ProgressBar)findViewById(R.id.progB3);

        //设置最大值
        mProgB1.setMax(1000);
        mProgB2.setMax(1000);
        mProgB3.setMax(1000);
    }
    //用来请求商品信息数据，用于回传
    public void click(View view) {
        Intent intent=new Intent(this,ShopActivity.class);
        startActivityForResult(intent,1);//返回请求结果，请求码1
    }
    //为了得到传回的数据，需要重写onActivityResult方法


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null){
            //判断结果码与请求码是否为1，等于1时获得回传数据
            if(requestCode==1){
                if(resultCode==1){
                    ItemInfo info=(ItemInfo)data.getSerializableExtra("equip");
                    //更新数据条
                    updatePrograssBar(info);
                }
            }
        }
    }

    private void updatePrograssBar(ItemInfo info) {
        int prograss1=mProgB1.getProgress();
        int prograss2=mProgB2.getProgress();
        int prograss3=mProgB3.getProgress();
        mProgB1.setProgress(prograss1+info.getLife());
        mProgB2.setProgress(prograss2+info.getAttack());
        mProgB3.setProgress(prograss3+info.getSpeed());
        mLifeTv.setText(mProgB1.getProgress()+"");
        mAttackTv.setText(mProgB2.getProgress()+"");
        mSpeedTv.setText(mProgB3.getProgress()+"");
    }
}

