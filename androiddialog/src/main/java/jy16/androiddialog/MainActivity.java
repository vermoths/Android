package jy16.androiddialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //普通对话框
//        AlertDialog dialog;
//        dialog = new AlertDialog.Builder(this)
//                .setTitle("这是普通对话框") //设置标题
//                .setMessage("是否退出这个普通的框子")//设置提示信息
//                .setIcon(R.mipmap.ic_launcher)//设置对话框图标
//                .setPositiveButton("确定",null)//添加确定按钮以及相应的点击事件
//                .setNegativeButton("取消",null)//添加取消按钮以及相应点击事件
//                .create();
//        dialog.show();

//        //单选对话框
//        new AlertDialog.Builder(this)  //生成对话框
//        .setTitle("请选择性取向")
//        .setIcon(R.mipmap.ic_launcher)
//        .setSingleChoiceItems(new String[]{"男","女"},0, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//                Toast.makeText(getApplication(),"选了什么",Toast.LENGTH_SHORT).show();
//            }
//        })
//                .setPositiveButton("确定",null)
//                .show();

//        //多选对话框
//        new AlertDialog.Builder(this)
//                .setTitle("请添加兴趣爱好！")
//                .setIcon(R.mipmap.ic_launcher)
//                .setMultiChoiceItems(new String[]{"旅游", "美食", "汽车", "宠物"},
//                        null, null)
//                .setPositiveButton("确定", null)
//                .show();

//        //进度条对话框
//        ProgressDialog prodialog; //声明
//        prodialog = new ProgressDialog(this); //绑定
//        prodialog.setTitle("进度条对话框");
//        prodialog.setIcon(R.mipmap.ic_launcher);
//        prodialog.setMessage("正在下载请等候...");
//        prodialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);//设定进度条形状
//        proialog.show();

        //自定义对话框
        MyDialog myDialog=new MyDialog(this,"我是自定义对话框");
        myDialog.show();
    }
}
