package jy16.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PicActivity extends AppCompatActivity {

    private ImageView imvPic=null;
    private Button btnpre=null;
    private Button btnnext=null;

    private Integer[] iImage={R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e,R.mipmap.f,R.mipmap.g};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic);

        imvPic=(ImageView)super.findViewById(R.id.imageView);
        btnpre=(Button)super.findViewById(R.id.prev);
        btnnext=(Button)super.findViewById(R.id.nextb);

        btnpre.setOnClickListener(new ProvOnClickListener());
        btnnext.setOnClickListener(new NextOnClickListener());
    }


    private class ProvOnClickListener implements View.OnClickListener {
        private int i=7;
        @Override
        public void onClick(View v) {
            if(i>0){
                imvPic.setImageResource(iImage[--i]);
            }else if(i==0){
                i=6;
                imvPic.setImageResource(iImage[6]);
            }
        }
    }

    private class NextOnClickListener implements View.OnClickListener {
        int i=0;
        @Override
        public void onClick(View v) {
            if(i<7){
                imvPic.setImageResource(iImage[i++]);
            }else if(i==6){
                i=0;
                imvPic.setImageResource(iImage[0]);
            }
        }
    }
}
