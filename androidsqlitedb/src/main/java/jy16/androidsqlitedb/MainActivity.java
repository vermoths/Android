package jy16.androidsqlitedb;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

 //   private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获得可读写的SQLite对象
        dbHelper database=new dbHelper(this);
        SQLiteDatabase db=null;
        db=database.getWritableDatabase();

              //事务处理
        db.beginTransaction();
        try{
            db.execSQL("update students set username=? where username=?",new Object[]{"zhang","Lucy"});
            db.execSQL("update students set username=? where username=?",new Object[]{"Li","Jane"});
            db.setTransactionSuccessful();

        }catch (Exception e){
            Log.i("失败",e.toString());
        }finally {
            db.endTransaction();
            db.close();
        }

       // tv=(TextView)findViewById(R.id.tv) ;

        //插入数据
//        ContentValues v=new ContentValues();
//        v.put("username","Lucy");
//        v.put("password","33333");
//        db.insert("students",null,v);
//        db.close();

        //修改数据
//        v.put("username","Jane");
//        db.update("students",v,"username=?",new String[]{"Lucy"});
//        db.close();

        //删除数据
//        db.delete("students",null,null);
//        db.close();

        //查询数据
//        Cursor cursor=db.query("students",null,null,null,null,null,null);
//        if(cursor.getCount()==0){
//            tv.setText("");
//
//        }else{
//            cursor.moveToFirst();
//            tv.setText("用户名："+cursor.getString(0)+"\n"+"密码："+cursor.getString(1));
//        }

    }
}
