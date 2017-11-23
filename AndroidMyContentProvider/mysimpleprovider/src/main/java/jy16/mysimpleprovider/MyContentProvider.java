package jy16.mysimpleprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class MyContentProvider extends ContentProvider {
    public MyContentProvider() {
    }

    private UriMatcher um=new UriMatcher(UriMatcher.NO_MATCH);{
        um.addURI("jy16.mysimpleprovider","insert",1);
        um.addURI("jy16.mysimpleprovider","delete",4);
        um.addURI("jy16.mysimpleprovider","update",3);
        um.addURI("jy16.mysimpleprovider","query",2);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Log.i("hm","provider delete"+um.match(uri));
            if(um.match(uri)==1){

        }
       return 0;
    }

    @Override
    public String getType(Uri uri) {
        Log.i("hm","provider Type"+um.match(uri));
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.i("hm","provider insert"+um.match(uri));
        getContext().getContentResolver().notifyChange(uri,null);
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        Log.i("hm","provider onCreate");
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Log.i("hm","provider query"+um.match(uri));
        if(um.match(uri)==1){
            MyHelper mh=new MyHelper(getContext());
            SQLiteDatabase db=mh.getWritableDatabase();
            Cursor cursor=db.query("person",projection,selection,selectionArgs,null,null,sortOrder);
            return cursor;
        }else{
            return null;
        }
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        Log.i("hm","provider update"+um.match(uri));
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
