package jy16.mycontent;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {

    private SQLiteOpenHelper poh;
   private UriMatcher um=new UriMatcher(UriMatcher.NO_MATCH);{
        um.addURI("jy16.mycontent","info",1);
    }


    @Override
    public boolean onCreate() {
        poh=new PeopleOpenHelper(getContext());

        return false;
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (um.match(uri) == 1) {
            SQLiteDatabase db = poh.getReadableDatabase();
            long rowid = db.insert("info", null, values);
            if (rowid > 0) {
                Uri insertedUri = ContentUris.withAppendedId(uri, rowid);
                getContext().getContentResolver().notifyChange(insertedUri, null);
            }
            db.close();
            return uri;
        } else {


            throw new UnsupportedOperationException("路径不正确，我是不会让你随便删除数据的!");
        }
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
       if(um.match(uri)==1){
           SQLiteDatabase db = poh.getWritableDatabase();
           int count = db.delete("info", selection, selectionArgs);
           //提示数据库的内容变化了
           if (count > 0) {
               getContext().getContentResolver().notifyChange(uri, null);
           }
           db.close();
           return count;
       } else {
           throw new IllegalArgumentException("路径不正确，我是不会让你随便删除数据的!");
       }
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }



    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        if(um.match(uri)==1){
            SQLiteDatabase db = poh.getReadableDatabase();
            return db.query("info", projection, selection, selectionArgs,
                    null, null, sortOrder);
        } else {
            throw new IllegalArgumentException("路径不正确，我是不会给你提供数据的！");
        }
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        if(um.match(uri)==1){
            SQLiteDatabase db = poh.getWritableDatabase();
            int count = db.update("info", values, selection, selectionArgs);
            //提示数据库的内容变化了
            if (count > 0) {
                getContext().getContentResolver().notifyChange(uri, null);
            }
            db.close();
            return count;
        } else {
            throw new IllegalArgumentException("路径不正确，我是不会让你更新数据的！");
        }
}
}
