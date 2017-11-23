package jy16.androidintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener{

    private ItemInfo itemInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        //通过构造型将值进行给定
        itemInfo=new ItemInfo("金剑",40,100,20);
        //绑定点击事件
        findViewById(R.id.activity_shop).setOnClickListener(this);
        //捕捉控件
        TextView mLifeTv=(TextView)findViewById(R.id.tv_life);
        TextView mNameTv=(TextView)findViewById(R.id.tv_name1);
        TextView mAttackTv=(TextView)findViewById(R.id.tv_attack);
        TextView mSpeedTv=(TextView)findViewById(R.id.tv_speed);
        //获取数值
        mLifeTv.setText("生命值+"+itemInfo.getLife());
        mNameTv.setText(itemInfo.getName()+"");
        mAttackTv.setText("攻击力+"+itemInfo.getAttack());
        mSpeedTv.setText("速度值+"+itemInfo.getSpeed());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_shop:
                Intent intent=new Intent();
                //将itemInfo中的数据放入变量euip中
                intent.putExtra("equip",itemInfo);
                setResult(1,intent);//第一个参数为结果码
                finish();//没有finish数据不会回传
                break;
        }
    }
}
