package jy16.androidbaseadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //声明ListView
    private ListView mListView;
    //数据
    private String[] names={"京东","斗地主","QQ","Sina","Tmall","UC","WeChat"};
    //图片
    private int[] icons={R.mipmap.jd,R.mipmap.qq_dizhu,R.mipmap.qq,R.mipmap.sina,R.mipmap.tmall,R.mipmap.uc,R.mipmap.weixin};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        mListView=(ListView)findViewById(R.id.lv);
        //创建BA的实例
        MyBaseAdapter myBaseAdapter=new MyBaseAdapter();
        //设置数据适配
        mListView.setAdapter(myBaseAdapter);
    }

    private class MyBaseAdapter extends BaseAdapter {
        @Override
        //条目数
        public int getCount() {
            return names.length;
        }

        @Override
        //某位置的对象
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        //具体位置
        public long getItemId(int position) {
            return position;
        }

        @Override

        //获取视图
        public View getView(int position, View convertView, ViewGroup parent) {
            //使用inflate抓取主布局之外的布局
            View view = View.inflate(MainActivity.this,R.layout.item_list,null);
            //捕捉item中的控件
            TextView mTv=(TextView)view.findViewById(R.id.tv_list);
            ImageView mImage=(ImageView)view.findViewById(R.id.image);
            //设置显示的文字和图片
            mTv.setText(names[position]);
            mImage.setBackgroundResource(icons[position]);
            return view;
        }
    }
}
