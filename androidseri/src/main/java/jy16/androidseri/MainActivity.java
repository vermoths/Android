package jy16.androidseri;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Xml;
import android.view.View;
import android.widget.Toast;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //声明保存数据的集合
    private List<PersonInfo> userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建模拟数据
        userData=new ArrayList<PersonInfo>();
        for(int i=0;i<5;i++){
            userData.add(new PersonInfo("杨"+i,20+i,100-i));
        }
    }
//点击按钮进行序列化
    public void Seri(View view) {
        try{
            //使用序列化器新建序列化对象
            XmlSerializer serializer= Xml.newSerializer();
            //序列化对象的存储
            File file=new File(Environment.getExternalStorageDirectory(),"personNew.xml");
            FileOutputStream os=new FileOutputStream(file);
            //序列化
            serializer.setOutput(os,"UTF-8");
            serializer.startDocument("UTF-8",true);
            serializer.startTag(null,"persons");
            int count=0;
            //foreach循环
            for(PersonInfo person:userData){
                //person节点
                serializer.startTag(null,"person");
                //person节点的id属性
                serializer.attribute(null,"id",count+"");
                //name节点及值
                serializer.startTag(null,"name");
                serializer.text(person.getName());
                serializer.endTag(null,"name");
                //age节点
                serializer.startTag(null,"age");
                serializer.text(String.valueOf(person.getAge()));
                serializer.endTag(null,"age");
                //score节点
                serializer.startTag(null,"score");
                serializer.text(String.valueOf(person.getScore()));
                serializer.endTag(null,"score");

                serializer.endTag(null,"person");
                count++;
            }
            serializer.endTag(null,"persons");
            serializer.endDocument();
            serializer.flush();
            os.close();
            Toast.makeText(this,"操作成功",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this,"操作失败",Toast.LENGTH_SHORT).show();
        }
    }
}
