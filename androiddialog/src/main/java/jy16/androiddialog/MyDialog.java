package jy16.androiddialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Vermoths on 2017/9/22.
 */

public class MyDialog extends Dialog{

    //声明控件
    private Button btnOK;
    private Button btnCancel;
    private TextView tvMsg;
    private String dialogName;

   public MyDialog( Context context, String dialogName) {
        super(context);
        this.dialogName = dialogName;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题行
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //引入自定义的对话框布局
        setContentView(R.layout.my_dialog);

        //捕捉引入布局中 的控件
        tvMsg=(TextView)findViewById(R.id.tv_msg);
        btnOK=(Button)findViewById(R.id.btn_ok);
        btnCancel=(Button)findViewById(R.id.btn_cancel);
        //设置对话框显示的内容
        tvMsg.setText(dialogName);
        //设置"确定"点击事件
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"hahahahahah",Toast.LENGTH_SHORT).show();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
