package jy16.androidreadsms;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//声明控件
    private TextView tvSms;
    private TextView tvDes;
//要显示的短信内容
    private String text="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSms=(TextView)findViewById(R.id.tv_sms);
        tvDes=(TextView)findViewById(R.id.tv_des);
    }
    //实现点击事件
    public void readSMS(View view) {
//要查询的数据的地址
        Uri uri=Uri.parse("content://sms/");
//获取Resolver对象，以便进行操作
        ContentResolver resolver=getContentResolver();
//进行查询，并且使用游标指向你要查询的数据结果
        Cursor cursor=resolver.query(uri,new String[]{"_id","address","type","body","date"},null,null,null);
        List<SmsInfo> smsInfos=new ArrayList<SmsInfo>();
        //挪动游标，向集合中放数据
        if(cursor!=null&&cursor.getCount()>0){
            tvDes.setVisibility(View.VISIBLE);
            while(cursor.moveToNext()){
                int _id=cursor.getInt(0);
                String address=cursor.getString(1);
                int type=cursor.getInt(2);
                String body=cursor.getString(3);
                long date=cursor.getLong(4);
                SmsInfo smsInfo=new SmsInfo(_id,address,type,body,date);
                smsInfos.add(smsInfo);
            }
            cursor.close();
        }
        for (int i = 0; i < smsInfos.size(); i++) {
            text += "手机号码：" + smsInfos.get(i).getAddress() + "\n";
            text += "短信内容：" + smsInfos.get(i).getBody() + "\n\n";
            tvSms.setText(text);
    }

    }

    }

